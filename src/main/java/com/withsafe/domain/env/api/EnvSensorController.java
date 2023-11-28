package com.withsafe.domain.env.api;


import com.withsafe.domain.env.appplication.EnvSensorService;
import com.withsafe.domain.env.dto.EnvSensorDTO;
import com.withsafe.domain.outdoorMap.domain.QOutdoorMap;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.parameters.P;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 1. 센서 등록(디바이스 등록)
 * 2. 시리얼 번호로 검색
 * 3. 부서로 검색 (대시보드 활성 개수 확인용)
 */
@RestController
@RequestMapping("/env-sensor")
@RequiredArgsConstructor
public class EnvSensorController {
    private final EnvSensorService envSensorService;

    @PostMapping
    @Transactional
    public Long saveEnvSensor(@RequestBody EnvSensorDTO.SaveRequest request){

        Long envSensorId = envSensorService.saveEnvSensor(request);
        return envSensorId;
    }

    //부서로 검색 -> 실외지도 테이블에서 파라미터로 넘어오는 부서로 select 후 envsensor 테이블과 조인
    @GetMapping("/dept-name")
    @Transactional
   public List<EnvSensorDTO.FindRequest> findEnvSensorByDept(@RequestParam String departmentName ){
        return envSensorService.findByDept(departmentName);
    }

    @GetMapping("/serial-num")
    @Transactional
    public List<EnvSensorDTO.FindRequest> findEnvSensorBySerialNum(@RequestParam String serialNum ){
        return envSensorService.findBySerialNum(serialNum);
    }
}

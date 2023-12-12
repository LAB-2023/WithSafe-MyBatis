package com.withsafe.domain.env.api;


import com.withsafe.domain.env.appplication.EnvSensorService;
import com.withsafe.domain.env.domain.EnvSensor;
import com.withsafe.domain.env.dto.EnvSensorAndDataDTO;
import com.withsafe.domain.env.dto.EnvSensorDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 1. 센서 등록(디바이스 등록)
 * 2. 시리얼 번호로 검색
 * 3. 부서로 검색 (대시보드 활성 개수 확인용)
 */
@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/env-sensor")
@RequiredArgsConstructor
public class EnvSensorController {
    private final EnvSensorService envSensorService;

    @PostMapping
    public EnvSensorDTO.EnvSensorSaveResponseDTO saveEnvSensor(@RequestParam(name = "outdoorMapId") Long outdoorMapId, @RequestBody EnvSensorDTO.EnvSensorSaveRequestDTO request) {
        EnvSensor envSensor = envSensorService.saveEnvSensor(outdoorMapId, request);
        return EnvSensorDTO.toEnvSensorSaveResponseDTO(envSensor);
    }

    //부서로 검색 -> 실외지도 테이블에서 파라미터로 넘어오는 부서로 select 후 envsensor 테이블과 조인
    @GetMapping("/department")
    public List<EnvSensorDTO.EnvSensorFindResponseDTO> findEnvSensorByDeptName(@RequestParam(name = "departmentName") String deptName) {
        List<EnvSensor> envSensorList = envSensorService.findEnvSensorByDeptName(deptName);
        List<EnvSensorDTO.EnvSensorFindResponseDTO> envSensorFindResponseDTOList = envSensorList.stream()
                .map(EnvSensorDTO::toEnvSensorFindResponseDTO).collect(Collectors.toList());
        return envSensorFindResponseDTOList;
    }

    @GetMapping("/serialNum")
    public EnvSensorDTO.EnvSensorFindResponseDTO findEnvSensorBySerialNum(@RequestParam(name = "serialNum") String serialNum) {
        EnvSensor envSensor = envSensorService.findEnvSensorBySerialNum((serialNum));
        return EnvSensorDTO.toEnvSensorFindResponseDTO(envSensor);
    }

//
//    //테스트 실패..
//    @GetMapping("/sensor-and-data")
//    public List<EnvSensorAndDataDTO.EnvSensorAndDataFindResponseDTO> findEnvSensorAndDataByDeptName(@RequestParam(name = "departmentName") String deptName) {
//        return envSensorService.findEnvSensorAndDataByDeptName(deptName);
//    }
//
}

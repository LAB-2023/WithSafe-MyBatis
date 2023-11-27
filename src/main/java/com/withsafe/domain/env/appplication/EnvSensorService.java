package com.withsafe.domain.env.appplication;

import com.withsafe.domain.env.dao.EnvSensorRepository;
import com.withsafe.domain.env.domain.EnvSensor;
import com.withsafe.domain.env.dto.EnvSensorDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EnvSensorService {

    private final EnvSensorRepository envSensorRepository;

    //디바이스 등록
    @Transactional
    public Long saveEnvSensor(EnvSensorDTO.SaveRequest saveRequest){
        EnvSensor envSensor = saveRequest.toSaveEntity();
        envSensorRepository.save(envSensor);
        return envSensor.getId();
    }

    //부서로 검색 (대시보드용)
    @Transactional
    public List<EnvSensorDTO> findByDept(String deptName){

        return null;
    }

}

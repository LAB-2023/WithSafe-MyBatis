package com.withsafe.domain.env.appplication;

import com.withsafe.domain.env.dao.EnvSensorRepository;
import com.withsafe.domain.env.domain.EnvSensor;
import com.withsafe.domain.env.dto.EnvSensorDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
    public List<EnvSensorDTO.FindRequest> findByDept(String deptName){
        List<EnvSensor> findSensorList = envSensorRepository.findEnvSensorByDept(deptName);
        List<EnvSensorDTO.FindRequest> findSensorDTO = new ArrayList<>();

        for (EnvSensor envSensor : findSensorList) {
            findSensorDTO.add(EnvSensorDTO.FindRequest.toFindRequestDTO(envSensor));
        }

        return findSensorDTO;
    }

    //시리얼 번호로 검색
    @Transactional
    public List<EnvSensorDTO.FindRequest> findBySerialNum(String deptName){
        List<EnvSensor> findSensorList = envSensorRepository.findBySerialNum(deptName);
        List<EnvSensorDTO.FindRequest> findSensorDTO = new ArrayList<>();

        for (EnvSensor envSensor : findSensorList) {
            findSensorDTO.add(EnvSensorDTO.FindRequest.toFindRequestDTO(envSensor));
        }

        return findSensorDTO;
    }

}

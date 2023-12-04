package com.withsafe.domain.env.appplication;

import com.withsafe.domain.env.dao.EnvSensorDataRepository;
import com.withsafe.domain.env.domain.EnvSensorData;
import com.withsafe.domain.env.dto.EnvSensorDataDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class EnvSensorDataService {
    private final EnvSensorDataRepository envSensorDataRepository;

    //데이터 조회
    @Transactional(readOnly = true)
    public List<Map<String, Object>> findEnvData(){
        //EnvSensorData findData = envSensorDataRepository.findTopByOrderByCreatedDateDesc();
        List<EnvSensorData> all = envSensorDataRepository.findAll();
        List<Map<String, Object>> result = new ArrayList<>();
        for (EnvSensorData envSensorData : all) {
            result.add(EnvSensorDataDTO.FindRequest.toFindRequest(envSensorData).getDataValues());
        }
//        if (findData == null) {
//            throw new NoSuchElementException("데이터가 존재하지 않습니다.");
//        }
        return result;
    }
}

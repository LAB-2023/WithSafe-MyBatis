package com.withsafe.domain.env.appplication;

import com.withsafe.domain.env.dao.EnvSensorDataRepository;
import com.withsafe.domain.env.dao.EnvSensorRepository;
import com.withsafe.domain.env.domain.EnvSensor;
import com.withsafe.domain.env.dto.EnvSensorDTO;
import com.withsafe.domain.outdoorMap.dao.OutdoorMapRepository;
import com.withsafe.domain.outdoorMap.domain.OutdoorMapJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EnvSensorService {

    private final EnvSensorRepository envSensorRepository;
    private final OutdoorMapRepository outdoorMapRepository;
    private final EnvSensorDataRepository envSensorDataRepository;

    //디바이스 등록
    @Transactional
    public EnvSensor saveEnvSensor(Long outdoorMapId, EnvSensorDTO.EnvSensorSaveRequestDTO request) {
        EnvSensor envSensor = EnvSensorDTO.toEnvSensor(request);
        OutdoorMapJpa outdoorMap = outdoorMapRepository.findById(outdoorMapId)
                .orElseThrow(() -> new IllegalArgumentException("해당 실외지도가 존재하지 않습니다."));
        envSensor.setOutdoorMap(outdoorMap);

        return envSensorRepository.save(envSensor);
    }

    @Transactional(readOnly = true)
    public List<EnvSensor> findEnvSensorByDeptName(String deptName) {
        List<EnvSensor> envSensorList = envSensorRepository.findEnvSensorByDept(deptName);
        return envSensorList;
    }

    @Transactional(readOnly = true)
    public EnvSensor findEnvSensorBySerialNum(String serialNum){
        EnvSensor envSensor = envSensorRepository.findBySerialNum(serialNum);
        return envSensor;
    }



//    @Transactional(readOnly = true)
//    public List<EnvSensorAndDataDTO.EnvSensorAndDataFindResponseDTO> findEnvSensorAndDataByDeptName(String deptName) {
//
////        List<EnvSensorData> envSensorDataList = envSensorDataRepository.findEnvSensorAndDataByDept(deptName);
//        List<EnvSensorData> envSensorDataList = envSensorDataRepository.findAllById(1L);
//        List<EnvSensorAndDataDTO.EnvSensorAndDataFindResponseDTO> envSensorAndDataFindResponseDTOList = new ArrayList<>();
//        System.out.println("테스트" + envSensorDataList);
//        for (EnvSensorData envSensorData : envSensorDataList) {
//            EnvSensorAndDataDTO.EnvSensorAndDataFindResponseDTO responseDTO = new EnvSensorAndDataDTO.EnvSensorAndDataFindResponseDTO();
//            Long envSensorId = envSensorData.getEnvSensor().getId();
//            String enSensorSerialNum = envSensorData.getEnvSensor().getSerialNum();
//            Map<String, Object> envSensorDataValue = envSensorData.getDataValues();
//            responseDTO.setId(envSensorId);
//            responseDTO.setSerialNum(enSensorSerialNum);
//            responseDTO.setEnvSensorData(envSensorDataValue);
//            envSensorAndDataFindResponseDTOList.add(responseDTO);
//        }
//
//        return envSensorAndDataFindResponseDTOList;
//    }


}

package com.withsafe.domain.env.appplication;

import com.withsafe.domain.env.dao.EnvSensorDataRepository;
import com.withsafe.domain.env.domain.EnvSensorData;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Rollback(value = false)
class EnvSensorDataServiceTest {
    @Autowired
    EnvSensorDataRepository envSensorDataRepository;
    @Autowired
    EnvSensorDataService envSensorDataService;

    @Test
    public void 환경데이터조회() {
        Map<String, Double> data = new HashMap<>();
        data.put("O2", 11.1);
        data.put("CO2", 12.1);
        EnvSensorData newData = EnvSensorData.builder()
                .dataValues(data)
                .build();
        System.out.println(data);
        System.out.println(newData);
        envSensorDataRepository.save(newData);

        Map<String, Double> data1 = new HashMap<>();
        data1.put("O2", 21.1);
        data1.put("CO2", 22.1);
        EnvSensorData newData1 = EnvSensorData.builder()
                .dataValues(data1)
                .build();
        System.out.println(data1);
        System.out.println(newData1);
        envSensorDataRepository.save(newData1);

        System.out.println("========="+ envSensorDataService.findEnvData()+"=========");
        System.out.println("========="+ envSensorDataService.findEnvData().getClass().getName()+"=========");
    }
}
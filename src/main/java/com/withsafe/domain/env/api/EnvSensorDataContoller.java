package com.withsafe.domain.env.api;

import com.withsafe.domain.env.appplication.EnvSensorDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/env-sensor-data")
@RequiredArgsConstructor
public class EnvSensorDataContoller {

    private final EnvSensorDataService envSensorDataService;

    @GetMapping
    public Map<String, Double> findEnvData() {
        return envSensorDataService.findEnvData();
    }
}

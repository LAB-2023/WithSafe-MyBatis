package com.withsafe.domain.env.api;

import com.withsafe.domain.env.appplication.EnvSensorDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/env-sensor-data")
@RequiredArgsConstructor
public class EnvSensorDataController {

    private final EnvSensorDataService envSensorDataService;

    @GetMapping
    public Map<String, Object> findEnvData() {
        return envSensorDataService.findEnvData();
    }
}

package com.withsafe.domain.beacon.api;

import com.withsafe.domain.beacon.application.BeaconService;
import com.withsafe.domain.beacon.dto.BeaconDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.withsafe.domain.beacon.dto.BeaconDto.*;

@RequestMapping("/beacon-api")
@RestController
@RequiredArgsConstructor
public class BeaconController {

    private final BeaconService beaconService;

    @PostMapping
    public RequestSave requestSave(@RequestBody RequestSave requestSave){
        beaconService.saveBeaconInfo(requestSave);
        return requestSave;
    }
}

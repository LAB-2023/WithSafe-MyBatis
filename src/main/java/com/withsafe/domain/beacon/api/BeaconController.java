package com.withsafe.domain.beacon.api;

import com.withsafe.domain.beacon.application.BeaconService;
import com.withsafe.domain.beacon.dto.BeaconDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static com.withsafe.domain.beacon.dto.BeaconDto.*;

@CrossOrigin("http://localhost:3000")
@RequestMapping("/beacon")
@RestController
@RequiredArgsConstructor
public class BeaconController {

    private final BeaconService beaconService;

    @PostMapping
    public Long requestSave(@RequestBody RequestSave requestSave){
        return beaconService.saveBeaconInfo(requestSave);
    }
}

package com.withsafe.domain.outdoorMap.api;

import com.withsafe.domain.outdoorMap.application.OutdoorMapService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static com.withsafe.domain.outdoorMap.dto.OutdoorMapDto.*;

@CrossOrigin("http://localhost:3000")
@RestController
@RequiredArgsConstructor
@RequestMapping("/outdoor-map")
public class OutdoorMapController {

    private final OutdoorMapService outdoorMapService;

    @PostMapping
    public Long save(@RequestBody SaveRequestDto request, @RequestParam String departmentName){
        return outdoorMapService.save(request, departmentName);
    }
}

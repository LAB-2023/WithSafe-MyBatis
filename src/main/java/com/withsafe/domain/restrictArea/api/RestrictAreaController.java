package com.withsafe.domain.restrictArea.api;

import com.withsafe.domain.restrictArea.application.RestrictAreaService;
import com.withsafe.domain.restrictArea.dto.RestrictAreaDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static com.withsafe.domain.restrictArea.dto.RestrictAreaDto.*;

@CrossOrigin("http://localhost:3000")
@RestController
@RequiredArgsConstructor
@RequestMapping("/restrict-area")
public class RestrictAreaController {

    private final RestrictAreaService restrictAreaService;

    @PostMapping
    public Long saveRestrictArea(@RequestParam String departmentName, @RequestBody SaveRequest request){
        Long restrictAreaId = restrictAreaService.saveRestrictArea(departmentName, request);
        return restrictAreaId;
    }
}

package com.withsafe.domain.helmet.api;

import com.withsafe.domain.helmet.application.HelmetService;
import com.withsafe.domain.helmet.dto.HelmetDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.withsafe.domain.helmet.dto.HelmetDTO.*;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/helmet")
@RequiredArgsConstructor
public class HelmetController {

    private final HelmetService helmetService;

    @PostMapping
    public Long saveHelmet(@RequestBody SaveRequest saveRequest, @RequestParam String departmentName){
        return helmetService.saveHelmetDTO(saveRequest, departmentName);
    }
}

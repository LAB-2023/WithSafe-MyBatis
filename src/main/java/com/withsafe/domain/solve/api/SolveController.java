package com.withsafe.domain.solve.api;

import com.withsafe.domain.solve.application.SolveService;
import com.withsafe.domain.solve.dto.SolveDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/solve-api")
@RequiredArgsConstructor
public class SolveController {

    private final SolveService solveService;
    @PostMapping
    public SolveDto.SaveRequest createSolve(@RequestBody SolveDto.SaveRequest saveRequest){
        solveService.saveSolve(saveRequest);
        return saveRequest;
    }
}

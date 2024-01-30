package com.withsafe.domain.solve.api;

import com.withsafe.domain.solve.application.SolveService;
import com.withsafe.domain.solve.dto.SolveDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.withsafe.domain.solve.dto.SolveDto.*;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/solve")
@RequiredArgsConstructor
public class SolveController {

    private final SolveService solveService;

    @PostMapping
    public ResponseEntity<SaveRequest> createSolve(@RequestBody SaveRequest saveRequest){
        solveService.saveSolve(saveRequest);
        return ResponseEntity.ok(saveRequest);
    }
}

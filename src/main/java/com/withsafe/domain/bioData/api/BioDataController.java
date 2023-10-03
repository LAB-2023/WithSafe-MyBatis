package com.withsafe.domain.bioData.api;

import com.withsafe.domain.bioData.application.BioDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bioData")
@RequiredArgsConstructor
public class BioDataController {
    private final BioDataService bioDataService;

}

package com.withsafe.domain.watchData.api;

import com.withsafe.domain.watch.dto.WatchDTO;
import com.withsafe.domain.watchData.application.WatchDataService;
import com.withsafe.domain.watchData.dto.WatchDataDTO;
import com.withsafe.domain.watchData.dto.WatchDataDTO.FindRequest;
import com.withsafe.domain.watchData.dto.WatchDataDTO.SaveRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/WatchData")
@RequiredArgsConstructor
public class WatchDataController {
    private final WatchDataService watchDataService;

    @PostMapping
    @Transactional
    public Long saveWatchData(@RequestBody SaveRequest request, @RequestParam Long watchId){
        return watchDataService.saveWatchData(request, watchId);
    }

    @PutMapping
    @Transactional
    public Long updateWatchData(@RequestBody SaveRequest request, @RequestParam Long watchId){
        return watchDataService.updateWatchData(request, watchId);
    }
    @GetMapping
    @Transactional
    public List<FindRequest> findWatchData(@RequestParam String departmentName){
        return watchDataService.findAllWatchData(departmentName);
    }
}
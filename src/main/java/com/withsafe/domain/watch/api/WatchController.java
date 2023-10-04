package com.withsafe.domain.watch.api;

import com.withsafe.domain.watch.application.WatchService;
import com.withsafe.domain.watch.domain.Watch;
import com.withsafe.domain.watch.dto.WatchDTO.DeleteRequest;
import com.withsafe.domain.watch.dto.WatchDTO.FindRequest;
import com.withsafe.domain.watch.dto.WatchDTO.SaveRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/watch")
@RequiredArgsConstructor
public class WatchController {

    private final WatchService watchService;
    /**
     * 워치 등록
     * @param request
     * @return
     */
    @PostMapping("/save")
    @Transactional
    public Long saveWatch(SaveRequest request){
        Long watchId = watchService.saveWatchDTO(request);
        return watchId;
    }
    /**
     * 워치 삭제
     * @param request
     * @return
     */
    @DeleteMapping("/delete")
    @Transactional
    public Long deleteWatch(@RequestBody DeleteRequest request){
        Long watchId = watchService.deleteWatchDTO(request);
        return watchId;
    }
    /**
     * 워치 검색
     * @param request
     * @return
     */
    @GetMapping("/find")
    public Watch findWatch(@RequestBody FindRequest request){
        Watch watch = watchService.findWatch(request);
        return watch;
    }
}


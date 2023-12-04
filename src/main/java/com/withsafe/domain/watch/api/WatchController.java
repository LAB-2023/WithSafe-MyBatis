
package com.withsafe.domain.watch.api;

import com.withsafe.domain.watch.application.WatchService;
import com.withsafe.domain.watch.dto.WatchDTO.FindRequest;
import com.withsafe.domain.watch.dto.WatchDTO.SaveRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/watch")
@RequiredArgsConstructor
public class WatchController {

    private final WatchService watchService;
    /**
     * 워치 저장
     * @param request
     * @return
     */
    @PostMapping
    @Transactional
    public Long saveWatch(@RequestBody SaveRequest request, @RequestParam String departmentName){
        Long watchId = watchService.saveWatch(request, departmentName);
        return watchId;
    }
    /**
     * 모든 워치 조회
     * @return
     */
    @GetMapping
    public List<FindRequest> findWatch(@RequestParam String departmentName){
        List<FindRequest> findRequestList = watchService.findAllWatch(departmentName);
        return findRequestList;
    }
    /**
     * 워치에 유저 등록
     */
    @PutMapping
    public Long saveUserToWatch(@RequestParam Long userId, @RequestParam String departmentName ,@RequestParam Long watchId){
        Long savedUserToWatchId = watchService.saveUserToWatch(userId, watchId);
        return savedUserToWatchId;
    }
}
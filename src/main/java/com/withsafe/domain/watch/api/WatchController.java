
package com.withsafe.domain.watch.api;

import com.withsafe.domain.watch.application.WatchService;
import com.withsafe.domain.watch.dto.StartRequestDto;
import com.withsafe.domain.watch.dto.WatchDTO;
import com.withsafe.domain.watch.dto.WatchDTO.FindRequest;
import com.withsafe.domain.watch.dto.WatchDTO.SaveRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.withsafe.domain.watch.dto.WatchDTO.*;

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
        return watchService.saveWatch(request, departmentName);
    }
    /**
     * 모든 워치 조회 프론트용
     * @return
     */
    @GetMapping
    public List<FindRequest> findWatch(@RequestParam String departmentName){
        return watchService.findAllWatch(departmentName);
    }
    /**
     * 워치에 유저 등록 프론트용
     */
    @PutMapping
    public Long saveUserToWatch(@RequestParam Long userId ,@RequestParam Long watchId){
        return watchService.saveUserToWatch(userId, watchId);
    }

    @GetMapping("/initial")
    public StartRequestDto startWatch(@RequestParam String SerialNum){
        return watchService.initializeWatch(SerialNum);
    }
}
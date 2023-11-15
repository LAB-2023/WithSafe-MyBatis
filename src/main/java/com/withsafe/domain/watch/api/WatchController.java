
package com.withsafe.domain.watch.api;

import com.withsafe.domain.watch.application.WatchService;
import com.withsafe.domain.watch.dto.WatchDTO.FindRequest;
import com.withsafe.domain.watch.dto.WatchDTO.SaveRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public Long saveWatch(@RequestBody SaveRequest request){
        Long watchId = watchService.saveWatch(request);
//        System.out.println("request.getModel() = " + request.getModel());
        return watchId;
    }
    /**
     * 모든 워치 조회
     * @param request
     * @return
     */
    @GetMapping
    public List<FindRequest> findWatch(@RequestBody FindRequest request){
        List<FindRequest> findRequestList = watchService.findAllWatch(request);
        return findRequestList;
    }
}


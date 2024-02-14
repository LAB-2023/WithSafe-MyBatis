
package com.withsafe.domain.watch.api;

import com.github.pagehelper.PageInfo;
import com.withsafe.domain.watch.application.WatchService;
import com.withsafe.domain.watch.dto.SearchCondition;
import com.withsafe.domain.watch.dto.WatchDTO.SaveRequest;
import com.withsafe.domain.watch.dto.WatchFindDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
        return watchService.saveWatch(request, departmentName);
    }
//    /**
//     * 모든 워치 조회 프론트용
//     * @return
//     */
//    @GetMapping
//    public List<WatchFindDto> findWatch(@RequestParam String departmentName){
//        return watchService.findAllWatch(departmentName);
//    }

    /**
     * 워치 검색, 조회
     */
    @GetMapping
    public ResponseEntity<PageInfo> findBySerialNum(@RequestParam("page") int page,
                                                    @RequestParam("size") int size,
                                                    @RequestParam("departmentName") String departmentName,
                                                    @RequestParam(value = "serialNum", required = false) String serialNum,
                                                    @RequestParam(value = "username", required = false) String username) {
        SearchCondition searchCondition = SearchCondition.toSearchCondition(serialNum, departmentName, username);
        return ResponseEntity.ok(watchService.findWatchBySearchCondition(page, size, searchCondition));
    }


    /**
     * 워치에 유저 등록 프론트용
     */
    @PutMapping("/user")
    public Long saveUserToWatch(@RequestParam(required = false) Long userId ,@RequestParam Long watchId){
        return watchService.saveUserToWatch(userId, watchId);
    }

    /**
     * 워치에 헬멧 등록 프론트용
     */
    @PutMapping("/helmet")
    public Long saveHelmetToWatch(@RequestParam Long helmetId, @RequestParam Long watchId){
        return watchService.saveHelmetToWatch(helmetId, watchId);
    }


//
//    @GetMapping("/initial")
//    public StartRequestDto startWatch(@RequestParam String SerialNum){
//        return watchService.initializeWatch(SerialNum);
//    }
}
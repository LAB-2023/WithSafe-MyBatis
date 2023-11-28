package com.withsafe.domain.bioData.api;

import com.withsafe.domain.bioData.application.BioDataService;
import com.withsafe.domain.bioData.dto.BioDataDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

import java.util.List;

import static com.withsafe.domain.bioData.dto.BioDataDto.*;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/bioData")
@RequiredArgsConstructor
public class BioDataController {
    private final BioDataService bioDataService;
    /**
     * 생체 데이터 저장
     */
    @PostMapping
    @Transactional
    public Long saveBioData(@RequestBody SaveRequest request){
        Long bioDataId = bioDataService.saveBioData(request);
        return bioDataId;
    }
    /**
     * 생체 세부 데이터 조회
     * 심박수 1주일치 평균, 최대, 최소
     */
//    @RequestMapping(value = "/{userId}",method = RequestMethod.GET)
//    public List<FindRequest> findBioData(@PathVariable Long userId, @RequestBody FindRequest request){
//        List<FindRequest> findRequestList = bioDataService.findWeekBioData(userId, request);
//        return findRequestList;
//    }

}

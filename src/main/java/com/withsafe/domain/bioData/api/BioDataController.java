package com.withsafe.domain.bioData.api;

import com.withsafe.domain.bioData.application.BioDataService;
import com.withsafe.domain.bioData.dto.BioDataSaveDto;
import com.withsafe.domain.user.dao.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.withsafe.domain.bioData.dto.BioDataSaveDto.*;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/bioData")
@RequiredArgsConstructor
public class BioDataController {
    private final BioDataService bioDataService;
    private final UserRepository userRepository;
    /**
     * 생체 데이터 저장
     */
    @PostMapping
    public Long saveBioData(@RequestBody BioDataSaveDto request, @RequestParam Long userId){
        return bioDataService.saveBioData(request, userId);
    }
    /**
     * 생체 세부 데이터 조회
     * 심박수 1주일치 평균, 최대, 최소
     */
    @GetMapping
    public List<BioDataSaveDto> findBioData(@RequestParam Long userId){
        List<BioDataSaveDto> request = bioDataService.findRequest(userId);
        return request;
    }

//    @PostMapping("/test50")
//    public void test(@RequestParam Long userId){
//        for(int i=0;i<50;i++) {
//            Integer heartRate = (int) (Math.random() * 100);
//            Double temperature = Math.random() * 36.5;
//            Integer walkCount = (int) (Math.random() * 1000);
//            Double oxygen = Math.random() * 50;
//            Integer calorie = (int) (Math.random() * 300);
//            Boolean isFall = false;
//            SaveRequest request = SaveRequest.builder().heartRate(heartRate).temperature(temperature)
//                    .walkCount(walkCount).oxygen(oxygen).calorie(calorie).isFall(isFall).build();
//            bioDataService.saveBioData(request, userId);
//        }
//    }
//    @RequestMapping(value = "/{userId}",method = RequestMethod.GET)
//    public List<FindRequest> findBioData(@PathVariable Long userId, @RequestBody FindRequest request){
//        List<FindRequest> findRequestList = bioDataService.findWeekBioData(userId, request);
//        return findRequestList;
//    }

}

package com.withsafe.domain.indoorEntrance.api;

import com.withsafe.domain.indoorEntrance.application.IndoorEntranceService;
import com.withsafe.domain.indoorEntrance.domain.IndoorEntrance;
import com.withsafe.domain.indoorEntrance.dto.IndoorEntranceDto;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/indoorEntrance")
public class IndoorEntranceController {
    private IndoorEntranceService indoorEntranceService;

    //전체조회
    @GetMapping
    public List<IndoorEntranceDto.SearchResult> getEntranceInfo(){
        List<IndoorEntranceDto.SearchResult> results = indoorEntranceService.findRecords();
        return results;
    }

    //이름, 기간으로 검색
    @GetMapping("/search")
    public List<IndoorEntranceDto.SearchResult> search(@RequestBody IndoorEntranceDto.SearchCondition searchCondition){
        List<IndoorEntranceDto.SearchResult> results = indoorEntranceService.findByNameAndDateRange
                (searchCondition.getUserName(), searchCondition.getStartDate(), searchCondition.getEndDate());
        return results;
    }

}

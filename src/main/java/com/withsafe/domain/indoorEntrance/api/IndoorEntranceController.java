package com.withsafe.domain.indoorEntrance.api;

import com.withsafe.domain.indoorEntrance.application.IndoorEntranceService;
import com.withsafe.domain.indoorEntrance.domain.IndoorEntrance;
import com.withsafe.domain.indoorEntrance.dto.IndoorEntranceDto;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping()
public class IndoorEntranceController {
    private IndoorEntranceService indoorEntranceService;

//    @GetMapping("/search")
//    public String search(@RequestBody IndoorEntranceDto.SearchCondition searchCondition){
//        List<IndoorEntrance> results = indoorEntranceService.findByNameAndDateRange
//                (searchCondition.getUserName(), searchCondition.getStartDate(), searchCondition.getEndDate());
//
//
//    }

}

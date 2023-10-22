package com.withsafe.domain.indoorEntrance.api;

import com.withsafe.domain.indoorEntrance.application.IndoorEntranceService;
import com.withsafe.domain.indoorEntrance.domain.IndoorEntrance;
import com.withsafe.domain.indoorEntrance.dto.IndoorEntranceDto;
import com.withsafe.domain.indoorEntrance.dto.IndoorEntranceDto.SearchCondition;
import com.withsafe.domain.indoorEntrance.dto.SearchResultDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.naming.directory.SearchResult;
import java.time.LocalDateTime;
import java.util.List;

import static com.withsafe.domain.indoorEntrance.dto.IndoorEntranceDto.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/indoorEntrance")
public class IndoorEntranceController {
    private IndoorEntranceService indoorEntranceService;

    @GetMapping
    public Page<SearchResultDto> getIndoorEntranceList(@RequestParam(required = false) String username,
                                                       @RequestParam(required = false) LocalDateTime startDate,
                                                       @RequestParam(required = false) LocalDateTime endDate,
                                                       @PageableDefault Pageable pageable){

        SearchCondition searchCondition = SearchCondition.toSearchCondition(username,startDate,endDate);

        // 서비스로 검색 조건 객체 전달
        Page<SearchResultDto> IndoorEntranceList = indoorEntranceService.getIndoorEntranceList(searchCondition, pageable);

        return IndoorEntranceList;

    }

}

package com.withsafe.domain.indoorEntrance.api;

import com.github.pagehelper.PageInfo;
import com.withsafe.domain.indoorEntrance.application.IndoorEntranceService;
import com.withsafe.domain.indoorEntrance.dto.IndoorEntranceDto.SearchCondition;
import com.withsafe.domain.indoorEntrance.dto.SearchResultDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.naming.directory.SearchResult;
import java.time.LocalDateTime;
import java.util.List;

import static com.withsafe.domain.indoorEntrance.dto.IndoorEntranceDto.*;

@CrossOrigin("http://localhost:3000")
@RestController
@RequiredArgsConstructor
@RequestMapping("/indoor-entrance")
public class IndoorEntranceController {
    private final IndoorEntranceService indoorEntranceService;

    @PostMapping
    public Long save(@RequestBody SaveRequest request){
        return indoorEntranceService.save(request);
    }

    @GetMapping
    public ResponseEntity<PageInfo> getIndoorEntranceList(@RequestParam int page,
                                                          @RequestParam int size,
                                                          @RequestParam(required = false) String username,
                                                          @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime startDate,
                                                          @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime endDate){

        SearchCondition searchCondition = SearchCondition.toSearchCondition(username,startDate,endDate);

        // 서비스로 검색 조건 객체 전달
        return ResponseEntity.ok(indoorEntranceService.getIndoorEntranceList(searchCondition, page, size));
    }

}

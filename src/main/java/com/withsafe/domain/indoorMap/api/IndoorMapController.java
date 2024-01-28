package com.withsafe.domain.indoorMap.api;

import com.withsafe.domain.indoorEntrance.dto.IndoorEntranceDto;
import com.withsafe.domain.indoorMap.application.IndoorMapService;
import com.withsafe.domain.indoorMap.dto.IndoorMapDto;
import com.withsafe.domain.indoorMap.dto.IndoorMapDto.IndoorMapInfo;
import com.withsafe.domain.indoorMap.dto.IndoorMapDto.SearchCondition;
import com.withsafe.domain.indoorMap.dto.IndoorMapLocationInfo;
import lombok.RequiredArgsConstructor;
import org.locationtech.jts.geom.Point;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.withsafe.domain.indoorMap.dto.IndoorMapDto.*;

@CrossOrigin("http://localhost:3000")
@RestController
@RequiredArgsConstructor
@RequestMapping("/indoor-map")
public class IndoorMapController {

    private final IndoorMapService indoorMapService;

    @PostMapping
    public Long save(@RequestBody IndoorMapSaveDto request, @RequestParam String departmentName){
        return indoorMapService.save(request, departmentName);
    }

    @GetMapping("/list")
    public List<IndoorMapInfo> getIndoorMapInfo(@RequestParam String departmentName){
        return indoorMapService.getIndoorMapList(departmentName);
    }

    @GetMapping("/location-info")
    public List<IndoorMapLocationInfo> getIndoorMapLocationInfo(@RequestParam String departmentName,
                                                                @RequestParam Long indoorMapId,
                                                                @RequestParam(required = false) String userName,
                                                                @RequestParam(required = false) Integer deviceNum){

        SearchCondition searchCondition = SearchCondition.toSearchCondition(departmentName, indoorMapId, userName, deviceNum);

        return indoorMapService.getIndoorMapLocationList(searchCondition);
    }
}

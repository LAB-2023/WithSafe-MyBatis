package com.withsafe.domain.indoorMap.api;

import com.withsafe.domain.indoorMap.application.IndoorMapService;
import com.withsafe.domain.indoorMap.dto.IndoorMapDto;
import lombok.RequiredArgsConstructor;
import org.locationtech.jts.geom.Point;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/indoorMap")
public class IndoorMapController {

    private final IndoorMapService indoorMapService;

    //도면 모니터링 페이지 (정보 한번에 DTO로 담아서 리턴)
    //DTO 안에 DTO 가져도 되는가..
//    @GetMapping("/{mapName}")
//    public IndoorMapDto.AreaInfo show(@PathVariable("mapName") String mapName){
//
//        String mapURL = indoorMapService.getMap(mapName);
//        List<IndoorMapDto.RestrictCoordinate> restrictArea = indoorMapService.getRestrictArea(mapName);
//        List<IndoorMapDto.UserInfo> userInfo = indoorMapService.getUserInfo(mapName);
//
//        return IndoorMapDto.AreaInfo.builder()
//                .URL(mapURL)
//                .restrictCoordinate(restrictArea)
//                .userCoordinate(userInfo)
//                .build();
//    }
}

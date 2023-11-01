package com.withsafe.domain.indoorMap.application;

import com.withsafe.domain.indoorMap.dao.IndoorMapRepository;
import com.withsafe.domain.indoorMap.domain.IndoorMap;
import com.withsafe.domain.indoorMap.dto.IndoorMapDto;
import com.withsafe.domain.indoorMap.dto.IndoorMapDto.IndoorMapInfo;
import com.withsafe.domain.restrictArea.domain.RestrictArea;
import lombok.RequiredArgsConstructor;
import org.locationtech.jts.geom.Point;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.withsafe.domain.indoorMap.dto.IndoorMapDto.*;

/**
 * 페이지 : 도면 모니터링
 * 기능 : 원하는 구역 선택, 구역에 따른 지도 보여주기, 지도 내에서 위험 구역 표시
 *
 * 검색 기능 필요
 * Input : 사용자 이름, 검색 기간
 *
 * Output : 사용자 이름, 번호, 날짜, 경고알림(경고, 유형), 조치여부
 */
@Service
@RequiredArgsConstructor
public class IndoorMapService {

    private final IndoorMapRepository indoorMapRepository;

    //사용자가 선택한 map 이미지, 위험구역 반환
    public IndoorMapInfo getIndoorMapInfo(String departmentName, String mapName){
        IndoorMap map = indoorMapRepository.findByDepartmentNameAndName(departmentName, mapName);

        IndoorMapInfo indoorMapInfo = IndoorMapInfo.builder()
                .id(map.getId())
                .name(map.getName())
                .URL(map.getImageUrl())
                .build();

        for (RestrictArea area : map.getRestrictAreaList()) {
            RestrictCoordinate restrictCoordinateList = RestrictCoordinate.builder()
                    .coordinate_left(area.getCoordinate_left())
                    .coordinate_right(area.getCoordinate_right())
                    .build();
            indoorMapInfo.getRestrictCoordinateList().add(restrictCoordinateList);
        }

        return indoorMapInfo;
    }

//    //IndoorMap DTO로 변환
//    public List<IndoorMapDto.IndoorMapInfo> getAllIndoorMap(){
//        List<IndoorMap> indoorMapList = indoorMapRepository.findAll();
//
//        return indoorMapList.stream()
//                .map(indoorMap -> IndoorMapDto.IndoorMapInfo.builder()
//                        .id(indoorMap.getId())
//                        .name(indoorMap.getName())
//                        .URL(indoorMap.getImageUrl())
//                        .uwbMapId(indoorMap.getUwbMapId())
//                        .build())
//                .collect(Collectors.toList());
//    }
//
//    //사용자가 선택한 구역의 지도 이미지 url 반환
//    public String getMap(String mapName){
//        IndoorMap byName = indoorMapRepository.findByName(mapName);
//        return byName.getImageUrl();
//    }
//
//    //사용자가 선택한 구역의 위험 구역 좌표 반환
//    public List<IndoorMapDto.RestrictCoordinate> getRestrictArea(String mapName){
//        IndoorMap byName = indoorMapRepository.findByName(mapName);
//
//        List<RestrictArea> restrictAreaList = byName.getRestrictAreaList();
//        List<IndoorMapDto.RestrictCoordinate> coordinateList = new ArrayList<>();
//
//        for (RestrictArea restrictArea : restrictAreaList) {
//            Point coordinate = restrictArea.getCoordinate();
//
//            IndoorMapDto.RestrictCoordinate temp = new IndoorMapDto.RestrictCoordinate();
//            temp.setCoordinate(coordinate); // 좌표 정보를 DTO에 설정
//
//            coordinateList.add(temp);
//        }
//
//        return coordinateList;
//
//    }

    //사용자 위치 및 정보 반환
    //경고 알림이랑 조치 현황은 일단 생략 ..
//    public List<IndoorMapDto.UserInfo> getUserInfo(String mapName){
//        IndoorMap byName = indoorMapRepository.findByName(mapName);
//        String mapId = byName.getUwbMapId();
//        List<IndoorUserLocation> indoorUserLocationList = indoorMapRepository.findLocationByMapId(mapId);
//        List<IndoorMapDto.UserInfo> userList = new ArrayList<>();
//
//        for (IndoorUserLocation location : indoorUserLocationList) {
//            String name = location.getUwbTag().getUser().getName();
//            String phone_num = location.getUwbTag().getUser().getPhone_num();
//            Point coordinate = location.getCoordinate();
//            LocalDateTime time = location.getCreatedDate();
//
//            IndoorMapDto.UserInfo temp = IndoorMapDto.UserInfo.builder()
//                    .name(name)
//                    .phone_num(phone_num)
//                    .coordinate(coordinate)
//                    .time(time)
//                    .build();
//
//            userList.add(temp);
//        }
//
//        return userList;
//    }
}

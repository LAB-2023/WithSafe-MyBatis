//package com.withsafe.domain.indoorMap.application;
//
//import com.querydsl.core.Tuple;
//import com.withsafe.domain.beacon.domain.Beacon;
//import com.withsafe.domain.indoorMap.dao.IndoorMapLocationRepository;
//import com.withsafe.domain.indoorMap.dao.IndoorMapRepository;
//import com.withsafe.domain.indoorMap.domain.IndoorMap;
//import com.withsafe.domain.indoorMap.dto.IndoorMapDto;
//import com.withsafe.domain.indoorMap.dto.IndoorMapDto.IndoorMapInfo;
//import com.withsafe.domain.restrictArea.domain.RestrictArea;
//import com.withsafe.domain.user.domain.User;
//import lombok.RequiredArgsConstructor;
//import org.locationtech.jts.geom.Point;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//
//import static com.withsafe.domain.indoorMap.dto.IndoorMapDto.*;
//
///**
// * 페이지 : 도면 모니터링
// * 기능 : 원하는 구역 선택, 구역에 따른 지도 보여주기, 지도 내에서 위험 구역 표시
// *
// * 검색 기능 필요
// * Input : 사용자 이름, 검색 기간
// *
// * Output : 사용자 이름, 번호, 날짜, 경고알림(경고, 유형), 조치여부
// */
//@Service
//@RequiredArgsConstructor
//    public class IndoorMapService {
//
//    private final IndoorMapRepository indoorMapRepository;
//    private final IndoorMapLocationRepository indoorMapLocationRepository;
//
//
//    //해당 부서의 실내 지도 리스트 반환
//    public List<IndoorMapInfo> getIndoorMapList(String departmentName){
//
//        List<IndoorMap> indoorMapList = indoorMapRepository.findByDepartmentName(departmentName);
//
//        List<IndoorMapInfo> indoorMapInfoList = indoorMapList.stream()
//                .map(indoorMap -> IndoorMapInfo.toIndoorMapInfo(
//                        indoorMap.getId(), indoorMap.getName(), indoorMap.getImageUrl()))
//                .collect(Collectors.toList());
//
//
//        return indoorMapInfoList;
//
//    }
//
//
//    //해당 실내 지도의 모든 정보 반환 (위험 구역, 비콘, 사용자 위치)
//    public List<IndoorMapLocationInfo> getIndoorMapLocationList(SearchCondition searchCondition){
//        return indoorMapLocationRepository.findAllBySearchCondition(searchCondition);
//    }
//
//
//
//}

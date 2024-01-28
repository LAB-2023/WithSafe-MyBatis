package com.withsafe.domain.indoorMap.application;

import com.withsafe.domain.department.dao.DepartmentMapper;
import com.withsafe.domain.department.domain.Department;
import com.withsafe.domain.indoorMap.dao.IndoorMapMapper;
import com.withsafe.domain.indoorMap.domain.IndoorMap;
import com.withsafe.domain.indoorMap.dto.IndoorMapDto.IndoorMapInfo;
import com.withsafe.domain.indoorMap.dto.IndoorMapLocationInfo;
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

    private final IndoorMapMapper indoorMapMapper;
    private final DepartmentMapper departmentMapper;

    public Long save(IndoorMapSaveDto request, String departmentName){
        Department department = departmentMapper.findByName(departmentName)
                .orElseThrow(() -> new IllegalArgumentException("해당 부서가 없습니다."));;
        IndoorMap indoorMap = IndoorMap.toEntity(request, department);
        indoorMapMapper.save(indoorMap);
        return indoorMap.getId();
    }


    //해당 부서의 실내 지도 리스트 반환
    public List<IndoorMapInfo> getIndoorMapList(String departmentName){

        List<IndoorMap> indoorMapList = indoorMapMapper.findByDepartmentName(departmentName);

        List<IndoorMapInfo> indoorMapInfoList = indoorMapList.stream()
                .map(indoorMap -> IndoorMapInfo.toIndoorMapInfo(
                        indoorMap.getId(), indoorMap.getName(), indoorMap.getImageUrl()))
                .collect(Collectors.toList());

        return indoorMapInfoList;
    }

    //해당 실내 지도의 모든 정보 반환 (위험 구역, 비콘, 사용자 위치)
    public List<IndoorMapLocationInfo> getIndoorMapLocationList(SearchCondition searchCondition){
        return indoorMapMapper.findAllBySearchCondition(searchCondition);
    }
}

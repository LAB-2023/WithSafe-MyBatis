package com.withsafe.domain.restrictArea.application;

import com.withsafe.domain.department.dao.DepartmentRepository;
import com.withsafe.domain.department.domain.Department;
import com.withsafe.domain.indoorMap.dao.IndoorMapRepository;
import com.withsafe.domain.indoorMap.domain.IndoorMap;
import com.withsafe.domain.outdoorMap.Repository.OutdoorMapRepository;
import com.withsafe.domain.outdoorMap.domain.OutdoorMap;
import com.withsafe.domain.restrictArea.dao.RestrictAreaRepository;
import com.withsafe.domain.restrictArea.domain.RestrictArea;
import com.withsafe.domain.restrictArea.dto.RestrictAreaDto;
import com.withsafe.domain.restrictArea.dto.RestrictAreaDto.SaveRequest;
import lombok.RequiredArgsConstructor;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.geom.PrecisionModel;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RestrictAreaService {

    private final RestrictAreaRepository restrictAreaRepository;
    private final DepartmentRepository departmentRepository;
    private final IndoorMapRepository indoorMapRepository;
    private final OutdoorMapRepository outdoorMapRepository;

    //사용자가 지정한 위험 구역 저장
    public Long saveRestrictArea(String departmentName, SaveRequest request) {
        Department department = departmentRepository.findByName(departmentName).orElseThrow(() -> new IllegalArgumentException("해당 부서가 없습니다."));
        IndoorMap indoorMap = null;
        OutdoorMap outdoorMap = null;

        Point coordinate_left = getPoint(request.getCoordinate_left_x(), request.getCoordinate_left_y());
        Point coordinate_right = getPoint(request.getCoordinate_right_x(), request.getCoordinate_right_y());

        if (department.containsIndoorMap(request.getMapName())){
            indoorMap = indoorMapRepository.findByName(request.getMapName()).orElseThrow(() -> new IllegalArgumentException("해당 indoor가 없습니다."));
        }
        else{
            outdoorMap = outdoorMapRepository.findByName(request.getMapName()).orElseThrow(() -> new IllegalArgumentException("해당 outdoor가 없습니다."));
        }

        RestrictArea savedRestrictArea = restrictAreaRepository.save(
                request.toEntity(coordinate_left, coordinate_right, indoorMap, outdoorMap));

        return savedRestrictArea.getId();
    }

    //point형으로 변환
    private Point getPoint(double x, double y){
        GeometryFactory geometryFactory;
        geometryFactory = new GeometryFactory(new PrecisionModel(), 4326);
        return geometryFactory.createPoint(new Coordinate(x, y));
    }
}

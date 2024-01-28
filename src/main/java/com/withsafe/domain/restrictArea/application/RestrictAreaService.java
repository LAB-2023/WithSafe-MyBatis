package com.withsafe.domain.restrictArea.application;

import com.withsafe.domain.department.dao.DepartmentMapper;
import com.withsafe.domain.department.domain.Department;
import com.withsafe.domain.indoorMap.dao.IndoorMapMapper;
import com.withsafe.domain.indoorMap.domain.IndoorMap;
import com.withsafe.domain.outdoorMap.Repository.OutdoorMapRepository;
import com.withsafe.domain.outdoorMap.domain.OutdoorMap;
import com.withsafe.domain.restrictArea.dao.RestrictAreaMapper;
import com.withsafe.domain.restrictArea.dao.RestrictAreaRepository;
import com.withsafe.domain.restrictArea.domain.RestrictArea;
import com.withsafe.domain.restrictArea.dto.RestrictAreaDto.SaveRequest;
import lombok.RequiredArgsConstructor;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.geom.PrecisionModel;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RestrictAreaService {

    private final DepartmentMapper departmentMapper;
    private final IndoorMapMapper indoorMapMapper;
    private final RestrictAreaMapper restrictAreaMapper;
    private final OutdoorMapRepository outdoorMapRepository;

    //사용자가 지정한 위험 구역 저장
    public Long saveRestrictArea(String departmentName, SaveRequest request) {
        Department department = departmentMapper.findByName(departmentName).orElseThrow(() -> new IllegalArgumentException("해당 부서가 없습니다."));
        IndoorMap indoorMap = null;
        OutdoorMap outdoorMap = null;

        Point coordinate_left = getPoint(request.getCoordinate_left_x(), request.getCoordinate_left_y());
        Point coordinate_right = getPoint(request.getCoordinate_right_x(), request.getCoordinate_right_y());

        indoorMap = indoorMapMapper.findByDepartmentNameAndIndoorMapName(departmentName, request.getMapName());
        if (indoorMap == null){
            outdoorMap = outdoorMapRepository
                    .findByName(request.getMapName()).orElseThrow(() -> new IllegalArgumentException("해당 outdoor가 없습니다."));
        }

        RestrictArea savedRestrictArea = request.toEntity(coordinate_left, coordinate_right, indoorMap, outdoorMap);
        restrictAreaMapper.save(savedRestrictArea);

        return savedRestrictArea.getId();
    }

    //point형으로 변환
    private Point getPoint(double x, double y){
        GeometryFactory geometryFactory;
        geometryFactory = new GeometryFactory(new PrecisionModel(), 4326);
        return geometryFactory.createPoint(new Coordinate(x, y));
    }
}

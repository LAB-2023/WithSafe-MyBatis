package com.withsafe.domain.outdoorMap.application;

import com.withsafe.domain.department.dao.DepartmentMapper;
import com.withsafe.domain.department.domain.Department;
import com.withsafe.domain.indoorMap.domain.IndoorMap;
import com.withsafe.domain.outdoorMap.dao.OutdoorMapper;
import com.withsafe.domain.outdoorMap.domain.OutdoorMap;
import com.withsafe.domain.outdoorMap.domain.OutdoorMapJpa;
import com.withsafe.domain.outdoorMap.dto.OutdoorMapDto;
import com.withsafe.domain.restrictArea.domain.RestrictArea;
import lombok.RequiredArgsConstructor;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.geom.PrecisionModel;
import org.springframework.stereotype.Service;

import static com.withsafe.domain.outdoorMap.dto.OutdoorMapDto.*;

@RequiredArgsConstructor
@Service
public class OutdoorMapService {

    private final OutdoorMapper outdoorMapper;
    private final DepartmentMapper departmentMapper;

    public Long save(SaveRequestDto request, String departmentName) {
        Department department = departmentMapper.findByName(departmentName)
                .orElseThrow(() -> new IllegalArgumentException("해당 부서가 없습니다."));
        Point coordinate= getPoint(request.getCoordinate_x(), request.getCoordinate_y());

        OutdoorMap outdoorMap = OutdoorMap.toEntity(request.getMapName(), coordinate, department);
        outdoorMapper.save(outdoorMap);
        return outdoorMap.getId();
    }

    //point형으로 변환
    private Point getPoint(double x, double y){
        GeometryFactory geometryFactory;
        geometryFactory = new GeometryFactory(new PrecisionModel(), 4326);
        return geometryFactory.createPoint(new Coordinate(x, y));
    }
}

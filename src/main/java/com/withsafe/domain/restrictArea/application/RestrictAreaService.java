package com.withsafe.domain.restrictArea.application;

import com.withsafe.domain.beacon.domain.Beacon;
import com.withsafe.domain.beacon.dto.BeaconResponseDto;
import com.withsafe.domain.indoorMap.dao.IndoorMapMapper;
import com.withsafe.domain.indoorMap.domain.IndoorMap;
import com.withsafe.domain.outdoorMap.dao.OutdoorMapper;
import com.withsafe.domain.outdoorMap.domain.OutdoorMap;
import com.withsafe.domain.outdoorMap.dto.OutdoorMapFindRequestDto;
import com.withsafe.domain.restrictArea.dao.RestrictAreaMapper;
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

    private final IndoorMapMapper indoorMapMapper;
    private final RestrictAreaMapper restrictAreaMapper;
    private final OutdoorMapper outdoorMapper;

    //사용자가 지정한 위험 구역 저장
    public Long saveRestrictArea(String departmentName, SaveRequest request) {
        IndoorMap indoorMap = null;
        OutdoorMap outdoorMap = null;

        Point coordinate_left = getPoint(request.getCoordinate_left_x(), request.getCoordinate_left_y());
        Point coordinate_right = getPoint(request.getCoordinate_right_x(), request.getCoordinate_right_y());

        indoorMap = indoorMapMapper.findByDepartmentNameAndIndoorMapName(departmentName, request.getMapName());
        if (indoorMap == null){
//            OutdoorMapFindRequestDto outdoorMapFindRequestDto =
//                    outdoorMapper.findByOutdoorMapNameAndDepartmentName(departmentName, request.getMapName())
//                    .orElseThrow(() -> new IllegalArgumentException("해당 외부 지도가 없습니다."));
//            Point coordinate = getPoint(outdoorMapFindRequestDto.getCoordinate_x(), outdoorMapFindRequestDto.getCoordinate_y());
//            outdoorMap = OutdoorMap.toEntity(outdoorMapFindRequestDto, coordinate);
            outdoorMap = outdoorMapper.findByOutdoorMapNameAndDepartmentName(departmentName, request.getMapName()).orElseThrow();
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

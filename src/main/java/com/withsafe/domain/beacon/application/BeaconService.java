package com.withsafe.domain.beacon.application;

import com.withsafe.domain.beacon.dao.BeaconMapper;
import com.withsafe.domain.beacon.domain.Beacon;
import com.withsafe.domain.beacon.dto.BeaconDto;
import com.withsafe.domain.indoorMap.dao.IndoorMapMapper;
import com.withsafe.domain.indoorMap.domain.IndoorMap;
import lombok.RequiredArgsConstructor;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.geom.PrecisionModel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 비콘 정보 저장
 */

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BeaconService {

    private final BeaconMapper beaconMapper;
    private final IndoorMapMapper indoorMapMapper;

    @Transactional
    public Long saveBeaconInfo(BeaconDto.RequestSave requestSave){
        String mapUrl = requestSave.getIndoorMapName();
        IndoorMap indoorMap = indoorMapMapper.findByName(mapUrl)
                .orElseThrow(() -> new IllegalArgumentException("해당 지도가 없습니다."));
        Point coordinate = getPoint(requestSave.getCoordinate_x(), requestSave.getCoordinate_y());
        Beacon saveBeacon = requestSave.toEntity(indoorMap, coordinate);
        beaconMapper.save(saveBeacon);

        return saveBeacon.getId();
    }

    //point형으로 변환
    private Point getPoint(double x, double y){
        GeometryFactory geometryFactory;
        geometryFactory = new GeometryFactory(new PrecisionModel(), 4326);
        return geometryFactory.createPoint(new Coordinate(x, y));
    }
}

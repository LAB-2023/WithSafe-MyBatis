package com.withsafe.domain.beacon.application;

import com.withsafe.domain.beacon.dao.BeaconRepository;
import com.withsafe.domain.beacon.domain.Beacon;
import com.withsafe.domain.beacon.dto.BeaconDto;
import com.withsafe.domain.indoorMap.application.IndoorMapService;
import com.withsafe.domain.indoorMap.dao.IndoorMapRepository;
import com.withsafe.domain.indoorMap.domain.IndoorMap;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 비콘 정보 저장
 */

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BeaconService {

    private final BeaconRepository beaconRepository;
    private final IndoorMapRepository indoorMapRepository;

    @Transactional
    public Long saveBeaconInfo(BeaconDto.RequestSave requestSave){
        String mapUrl = requestSave.getIndoorMapName();
        IndoorMap indoorMap = indoorMapRepository.findByName(mapUrl);
        Beacon saveBeacon = beaconRepository.save(requestSave.toEntity(indoorMap));

        return saveBeacon.getId();
    }
}

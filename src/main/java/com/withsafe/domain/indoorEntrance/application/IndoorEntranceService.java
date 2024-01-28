package com.withsafe.domain.indoorEntrance.application;

import com.withsafe.domain.beacon.dao.BeaconMapper;
import com.withsafe.domain.beacon.domain.Beacon;
import com.withsafe.domain.beacon.dto.BeaconResponseDto;
import com.withsafe.domain.indoorEntrance.dao.IndoorEntranceMapper;
import com.withsafe.domain.indoorEntrance.domain.IndoorEntrance;
import com.withsafe.domain.indoorEntrance.dto.IndoorEntranceDto;
import com.withsafe.domain.indoorEntrance.dto.IndoorEntranceDto.SearchCondition;
import com.withsafe.domain.indoorEntrance.dto.SearchResultDto;
import com.withsafe.domain.watch.dao.WatchMapper;
import com.withsafe.domain.watch.domain.Watch;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 페이지 : 구역 출입 현황
 * 기능 : 검색 세부옵션 사용자 입력, 구역 출입 현황 확인판
 *
 * 검색 기능 필요
 * Input : 사용자 이름, 검색 기간
 * Output : 디바이스 시리얼 번호, 사용자 이름, 출입시간, 구역이름
 */

@Service
@RequiredArgsConstructor
public class IndoorEntranceService {

    private final IndoorEntranceMapper indoorEntranceMapper;
    private final BeaconMapper beaconMapper;
    private final WatchMapper watchMapper;

    //실내 위치 저장
    public Long save(IndoorEntranceDto.SaveRequest request){
        Watch watch = watchMapper.findBySerialNum(request.getWatchSerialNum())
                .orElseThrow(() -> new IllegalArgumentException("해당 워치가 없습니다."));
        BeaconResponseDto beaconDto = beaconMapper.findByMacAddress(request.getBeaconMacAddress())
                .orElseThrow(() -> new IllegalArgumentException("해당 비콘이 없습니다."));
        Beacon beacon = Beacon.toEntity(beaconDto);
        IndoorEntrance indoorEntrance = IndoorEntrance.toEntity(beacon, watch);
        indoorEntranceMapper.save(indoorEntrance);
        return indoorEntrance.getId();
    }

    //리스트 반환
    public Page<SearchResultDto> getIndoorEntranceList (SearchCondition searchCondition, Pageable pageable){
        //Page<SearchResultDto> listBySearchCondition = indoorEntranceRepository.findAllBySearchCondition(searchCondition, pageable);

        return null;
    }

}

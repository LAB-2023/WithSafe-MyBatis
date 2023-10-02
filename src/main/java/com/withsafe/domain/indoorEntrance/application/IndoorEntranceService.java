package com.withsafe.domain.indoorEntrance.application;

import com.withsafe.domain.indoorEntrance.dao.IndoorEntranceRepository;
import com.withsafe.domain.indoorEntrance.domain.IndoorEntrance;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

    private final IndoorEntranceRepository indoorEntranceRepository;

    //indoorEntranceDto로 저장

    //전체 조회
    public List<IndoorEntrance> findRecords(){
        return indoorEntranceRepository.findAll();
    }

    //사용자 이름으로 검색
    public List<IndoorEntrance> findByUser(String name){
        return indoorEntranceRepository.findByWatchUserName(name);
    }

    //기간으로 검색
    public List<IndoorEntrance> findByDateRange(LocalDateTime startDate, LocalDateTime endDate){
        return indoorEntranceRepository.findByCreatedDateBetweenAndModifiedDateBetween(startDate,endDate,startDate,endDate);
    }

    //사용자 이름과 기간으로 검색
    public List<IndoorEntrance> findByNameAndDateRange(String name, LocalDateTime startDate, LocalDateTime endDate){
        return indoorEntranceRepository.findByWatchUserNameAndCreatedDateBetweenAndModifiedDateBetween
                (name,startDate,endDate,startDate,endDate);
    }

}

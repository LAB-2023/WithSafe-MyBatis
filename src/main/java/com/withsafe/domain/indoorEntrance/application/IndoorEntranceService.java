package com.withsafe.domain.indoorEntrance.application;

import com.withsafe.domain.indoorEntrance.dao.IndoorEntranceRepository;
import com.withsafe.domain.indoorEntrance.domain.IndoorEntrance;
import com.withsafe.domain.indoorEntrance.dto.IndoorEntranceDto;
import com.withsafe.domain.indoorEntrance.dto.IndoorEntranceDto.SearchCondition;
import com.withsafe.domain.indoorEntrance.dto.SearchResultDto;
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

    private final IndoorEntranceRepository indoorEntranceRepository;

    //리스트 반환
    public Page<SearchResultDto> getIndoorEntranceList (SearchCondition searchCondition, Pageable pageable){
        Page<SearchResultDto> listBySearchCondition = indoorEntranceRepository.findAllBySearchCondition(searchCondition, pageable);

        return listBySearchCondition;
    }

}

package com.withsafe.domain.indoorEntrance.dao;

import com.withsafe.domain.indoorEntrance.domain.IndoorEntrance;
import com.withsafe.domain.indoorEntrance.dto.IndoorEntranceDto;
import com.withsafe.domain.indoorEntrance.dto.SearchResultDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(value = false)
class IndoorEntranceRepositoryTest {

    @Autowired IndoorEntranceRepository indoorEntranceRepository;


    @Test
    public void testGetIndoorEntranceList(){
        LocalDateTime startTime = null; //LocalDateTime.of(2023, 9, 1, 10, 0, 0);
        LocalDateTime endTime = null; //LocalDateTime.of(2023, 9, 30, 15, 0, 0);

        IndoorEntranceDto.SearchCondition searchCondition = IndoorEntranceDto.SearchCondition.toSearchCondition("lee",startTime,endTime);

        System.out.println("====================");

        System.out.println("searchCondition = " + searchCondition.getUserName());
        System.out.println("searchCondition.getStartDate() = " + searchCondition.getStartDate());
        System.out.println("searchCondition.getEndDate() = " + searchCondition.getEndDate());

        //Pageable pageable = PageRequest.of(0,10);
        PageRequest pageable = PageRequest.of(0, 10);

        Page<SearchResultDto> results = indoorEntranceRepository.findAllBySearchCondition(searchCondition, pageable);

        System.out.println("====================");
        for (SearchResultDto result : results) {
            System.out.println("EnterTime = " + result.getEnterTime());
            System.out.println("result.getUserName() = " + result.getUserName());
        }

    }



}
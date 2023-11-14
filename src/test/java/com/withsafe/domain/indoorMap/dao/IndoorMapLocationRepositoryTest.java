package com.withsafe.domain.indoorMap.dao;

import com.withsafe.domain.indoorMap.domain.IndoorMap;
import com.withsafe.domain.indoorMap.dto.IndoorMapDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Transactional
@Rollback(value = false)
class IndoorMapLocationRepositoryTest {
    @Autowired IndoorMapLocationRepository indoorMapLocationRepository;

    @Test
    void TestFindAllBySearchCondition(){
        Integer deviceNum = 50;
        String userName = "lee";
        IndoorMapDto.SearchCondition searchCondition = IndoorMapDto.SearchCondition.builder()
                //.deviceNum(deviceNum)
                .userName(userName)
                .build();
        indoorMapLocationRepository.findAllBySearchCondition(searchCondition);
    }


}
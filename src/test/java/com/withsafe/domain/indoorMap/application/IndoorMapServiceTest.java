package com.withsafe.domain.indoorMap.application;

import com.withsafe.domain.indoorMap.dao.IndoorMapRepository;
import com.withsafe.domain.indoorMap.dto.IndoorMapDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(value = false)
class IndoorMapServiceTest {

    @Autowired
    private IndoorMapService indoorMapService;

    @Test
    void testGetIndoorMapList(){
        String departmentName = "a부서";
        List<IndoorMapDto.IndoorMapInfo> indoorMapList = indoorMapService.getIndoorMapList(departmentName);

        for (IndoorMapDto.IndoorMapInfo indoorMapInfo : indoorMapList) {
            System.out.println("indoorMapInfo.getName() = " + indoorMapInfo.getName());
        }
    }

    @Test
    void testGetIndoorMapLocationList(){
        String departmentName = "a부서";
        Integer deviceNum = 50;
        String userName = "lee";
        IndoorMapDto.SearchCondition searchCondition = IndoorMapDto.SearchCondition.builder()
                //.departmentName(departmentName)
                //.deviceNum(deviceNum)
                //.userName(userName)
                .build();

        List<IndoorMapDto.IndoorMapLocationInfo> indoorMapLocationList = indoorMapService.getIndoorMapLocationList(searchCondition);

        for (IndoorMapDto.IndoorMapLocationInfo indoorMapLocationInfo : indoorMapLocationList) {
            System.out.println("indoorMapLocationInfo = " + indoorMapLocationInfo.getDepartmentName());
            System.out.println("indoorMapLocationInfo = " + indoorMapLocationInfo.getRestrictAreaId());
            System.out.println("indoorMapLocationInfo = " + indoorMapLocationInfo.getRestrictAreaId());
            System.out.println("indoorMapLocationInfo.getUserName() = " + indoorMapLocationInfo.getUserName());
            System.out.println("=====");
        }

        System.out.println("indoorMapLocationList = " + indoorMapLocationList.size());


    }

}
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
                .departmentName(departmentName)
                //.deviceNum(deviceNum)
                .userName(userName)
                .build();

        List<IndoorMapDto.IndoorMapLocationInfo> indoorMapLocationList = indoorMapService.getIndoorMapLocationList(searchCondition);

        for (IndoorMapDto.IndoorMapLocationInfo indoorMapLocationInfo : indoorMapLocationList) {
            System.out.println("indoorMapLocationInfo = " + indoorMapLocationInfo.getDepartmentName());
            System.out.println("indoorMapLocationInfo = " + indoorMapLocationInfo.getRestrictAreaId());
            System.out.println("=====");
        }


    }


//    @Test
//    void testGetIndoorMapInfo() {
//        String departmentName = "a부서";
//        String mapName = "500ho";
//        IndoorMapDto.IndoorMapInfo indoorMapInfo = indoorMapService.getIndoorMapInfo(departmentName, mapName);
//
//        for (IndoorMapDto.RestrictCoordinate restrictCoordinate : indoorMapInfo.getRestrictCoordinateList()) {
//            System.out.println("restrictCoordinate.getCoordinate_left() = " + restrictCoordinate.getCoordinate_left());
//        }
//
//        for (IndoorMapDto.BeaconCoordinate beaconCoordinate : indoorMapInfo.getBeaconCoordinateList()) {
//            System.out.println("beaconCoordinate.getCoordinate() = " + beaconCoordinate.getCoordinate());
//        }
//    }

    //    @Test
//    public void testFindAllIndoorMap(){
//        List<IndoorMapDto.IndoorMapInfo> result = indoorMapService.getAllIndoorMap();
//
//        for (IndoorMapDto.IndoorMapInfo indoorMapInfo : result) {
//            System.out.println("indoorMapInfo = " + indoorMapInfo.getId());
//        }
//    }
//
//    @Test
//    public void testFindMap(){
//        String name = "431ho";
//        System.out.println("map url = " +  indoorMapService.getMap(name));
//    }
//
//    @Test
//    public void testFindRestrictArea(){
//        String name = "431ho";
//        List<IndoorMapDto.RestrictCoordinate> result = indoorMapService.getRestrictArea(name);
//        for (IndoorMapDto.RestrictCoordinate restrictCoordinate : result) {
//            System.out.println("restrictCoordinate = " + restrictCoordinate.getCoordinate());
//        }
//    }

//    @Test
//    public void testGetUserInfo(){
//        String name = "431ho";
//        List<IndoorMapDto.UserInfo> result = indoorMapService.getUserInfo(name);
//        for (IndoorMapDto.UserInfo userInfo : result) {
//            System.out.println("userInfo.getName() = " + userInfo.getName());
//        }
//    }

}
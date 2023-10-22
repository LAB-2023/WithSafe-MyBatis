//package com.withsafe.domain.indoorEntrance.application;
//
//import com.withsafe.domain.indoorEntrance.domain.IndoorEntrance;
//import com.withsafe.domain.indoorEntrance.dto.IndoorEntranceDto;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.test.annotation.Rollback;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//@Transactional
//@Rollback(value = false)
//class IndoorEntranceServiceTest {
//
//    @Autowired IndoorEntranceService indoorEntranceService;
//
//    @Test
//    public void testFindByNameAndDateRange(){
//        LocalDateTime startTime = LocalDateTime.of(2023, 9, 1, 10, 0, 0);
//        LocalDateTime endTime = LocalDateTime.of(2023, 9, 30, 15, 0, 0);
//
//        List<IndoorEntranceDto.> all = indoorEntranceService.
//                findByNameAndDateRange("lee", startTime,endTime);
//
//        for (IndoorEntranceDto.SearchResult searchResult : all) {
//            System.out.println("searchResult = " + searchResult.getUserName());
//        }
//
//
//    }
//
////    @Test
////    public void testGetIndoorEntranceList(){
////        LocalDateTime startTime = LocalDateTime.of(2023, 9, 1, 10, 0, 0);
////        LocalDateTime endTime = LocalDateTime.of(2023, 9, 30, 15, 0, 0);
////
////        Pageable pageable = PageRequest.of(0,10);
////        Page<IndoorEntranceDto.SearchResult> results = indoorEntranceService.getIndoorEntranceList(IndoorEntranceDto.SearchCondition.toSearchCondition("lee",startTime,endTime), pageable);
////
////        System.out.println("====================");
////        for (IndoorEntranceDto.SearchResult result : results) {
////            System.out.println("result = " + result.getUserName());
////        }
////
////    }
//
//}
package com.withsafe.domain.indoorEntrance.dao;

import com.withsafe.domain.indoorEntrance.domain.IndoorEntrance;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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
    public void testFindAll(){
        List<IndoorEntrance> all = indoorEntranceRepository.findAll();

        System.out.println("FindAll=========================================");
        for (IndoorEntrance indoorEntrance : all) {
            System.out.println("indoorEntrance = " + indoorEntrance.getId());
        }
    }

    @Test
    public void testFindByName(){
        List<IndoorEntrance> all = indoorEntranceRepository.findByWatchUserName("lee");

        System.out.println("이름=========================================");
        for (IndoorEntrance indoorEntrance : all) {
            System.out.println("indoorEntrance = " + indoorEntrance.getId());
        }
    }

    @Test
    public void testFindByDateRange(){

        LocalDateTime startTime = LocalDateTime.of(2023, 9, 1, 10, 0, 0);
        LocalDateTime endTime = LocalDateTime.of(2023, 9, 30, 15, 0, 0);

        List<IndoorEntrance> all = indoorEntranceRepository.
                findByCreatedDateBetweenAndModifiedDateBetween(startTime,endTime,startTime,endTime);

        System.out.println("기간=========================================");
        for (IndoorEntrance indoorEntrance : all) {
            System.out.println("indoorEntrance = " + indoorEntrance.getId());
        }

    }

    @Test
    public void testFindByNameAndDateRange(){

        LocalDateTime startTime = LocalDateTime.of(2023, 9, 1, 10, 0, 0);
        LocalDateTime endTime = LocalDateTime.of(2023, 9, 30, 15, 0, 0);

        List<IndoorEntrance> all = indoorEntranceRepository.
                findByWatchUserNameAndCreatedDateBetweenAndModifiedDateBetween("kim", startTime,endTime,startTime,endTime);

        System.out.println("이름&기간=========================================");
        for (IndoorEntrance indoorEntrance : all) {
            System.out.println("indoorEntrance = " + indoorEntrance.getId());
        }

    }


}
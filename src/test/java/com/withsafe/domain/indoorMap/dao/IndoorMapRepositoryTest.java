package com.withsafe.domain.indoorMap.dao;

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
class IndoorMapRepositoryTest {

    @Autowired IndoorMapRepository indoorMapRepository;

//    @Test
//    public void testFindByMapId(){
//        List<IndoorUserLocation> locationByMapId = indoorMapRepository.findLocationByMapId("1004");
//        for (IndoorUserLocation indoorUserLocation : locationByMapId) {
//            System.out.println("indoorUserLocation = " + indoorUserLocation.getId());
//        }
//    }

}
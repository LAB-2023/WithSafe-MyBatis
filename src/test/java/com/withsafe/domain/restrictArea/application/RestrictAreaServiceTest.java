package com.withsafe.domain.restrictArea.application;

import com.withsafe.domain.restrictArea.dto.RestrictAreaDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
@Rollback(value = false)
class RestrictAreaServiceTest {

    @Autowired RestrictAreaService restrictAreaService;

    @Test
    public void testSaveRestrictArea(){

        RestrictAreaDto.SaveRequest saveRequest = RestrictAreaDto.SaveRequest.builder()
                .areaName("t1-an")
                .mapName("testName2")
                .coordinate_left_x(10D)
                .coordinate_left_y(10D)
                .coordinate_right_x(20D)
                .coordinate_right_y(20D)
                .safetyRule("t1-sr")
                .build();

        Long saved = restrictAreaService.saveRestrictArea("A-Department", saveRequest);
        System.out.println("saved = " + saved);
    }


}
package com.withsafe.domain.env.dao;

import com.withsafe.domain.env.domain.EnvSensor;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EnvSensorRepository extends JpaRepository<EnvSensor, Long> {
    @Query("SELECT es FROM EnvSensor es JOIN es.outdoorMap om WHERE om.department.name = :dept_name")
    List<EnvSensor> findEnvSensorByDept(
            @Param("dept_name") String deptName);
//    @Query("SELECT esd\n" +
//            "FROM Department d\n" +
//            "JOIN d.outdoorMapList om\n" +
//            "JOIN om.envSensorList es\n" +
//            "JOIN es.envSensorDataList esd\n" +
//            "WHERE d.name = :dept_name\n" +
//            "AND esd.id IN (\n" +
//            "    SELECT MAX(esdInner.id)\n" +
//            "    FROM Department dInner\n" +
//            "    JOIN dInner.outdoorMapList omInner\n" +
//            "    JOIN omInner.envSensorList esInner\n" +
//            "    JOIN esInner.envSensorDataList esdInner\n" +
//            "    WHERE dInner.name = :deptName\n" +
//            "    GROUP BY esInner.id\n" +
//            ")")
//    List<EnvSensor> findEnvSensorByDept(
//            @Param("dept_name") String deptName);


    EnvSensor findBySerialNum(String serialNum);

}

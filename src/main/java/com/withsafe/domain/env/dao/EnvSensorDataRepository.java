package com.withsafe.domain.env.dao;

import com.withsafe.domain.env.domain.EnvSensor;
import com.withsafe.domain.env.domain.EnvSensorData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnvSensorDataRepository extends JpaRepository<EnvSensorData, Long> {

    EnvSensorData findTopByOrderByCreatedDateDesc();

//    @Query("SELECT esd\n" +
//            "FROM Department d\n" +
//            "JOIN d.outdoorMapList om\n" +
//            "JOIN om.envSensorList es\n" +
//            "JOIN es.envSensorDataList esd\n" +
//            "WHERE d.name = :deptName\n" +
//            "AND esd.id IN (\n" +
//            "    SELECT MAX(esdInner.createdDate)\n" +
//            "    FROM Department dInner\n" +
//            "    JOIN dInner.outdoorMapList omInner\n" +
//            "    JOIN omInner.envSensorList esInner\n" +
//            "    JOIN esInner.envSensorDataList esdInner\n" +
//            "    WHERE dInner.name = :deptName\n" +
//            "    GROUP BY esInner.id\n" +
//            ")")
    @Query("SELECT esd\n" +
            "FROM Department d\n" +
            "JOIN d.outdoorMapList om\n" +
            "JOIN om.envSensorList es\n" +
            "JOIN es.envSensorDataList esd\n" +
            "WHERE d.name = :deptName\n" +
            "AND esd.createdDate = (\n" +
            "    SELECT MAX(esdInner.createdDate)\n" +
            "    FROM Department dInner\n" +
            "    JOIN dInner.outdoorMapList omInner\n" +
            "    JOIN omInner.envSensorList esInner\n" +
            "    JOIN esInner.envSensorDataList esdInner\n" +
            "    WHERE dInner = d\n" +
            "    AND esInner = es\n" +
            ")")
    List<EnvSensorData> findEnvSensorAndDataByDept(
            @Param("deptName") String deptName);

    List<EnvSensorData> findAllById(Long id);

}

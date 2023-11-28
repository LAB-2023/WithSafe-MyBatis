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

    List<EnvSensor> findBySerialNum(String serialNum);

}

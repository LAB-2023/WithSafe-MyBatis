package com.withsafe.domain.env.dao;

import com.withsafe.domain.env.domain.EnvSensorData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnvSensorDataRepository extends JpaRepository<EnvSensorData, Long> {

    EnvSensorData findTopByOrderByCreatedDateDesc();
}

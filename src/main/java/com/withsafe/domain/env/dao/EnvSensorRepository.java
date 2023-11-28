package com.withsafe.domain.env.dao;

import com.withsafe.domain.env.domain.EnvSensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnvSensorRepository extends JpaRepository<EnvSensor, Long> {
}

package com.withsafe.domain.outdoorMap.dao;

import com.withsafe.domain.outdoorMap.domain.OutdoorMapJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OutdoorMapRepository extends JpaRepository<OutdoorMapJpa, Long> {
    Optional<OutdoorMapJpa> findByName(String mapName);

}

package com.withsafe.domain.outdoorMap.Repository;

import com.withsafe.domain.outdoorMap.domain.OutdoorMap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OutdoorMapRepository extends JpaRepository<OutdoorMap, Long> {
    Optional<OutdoorMap> findByName(String mapName);

}

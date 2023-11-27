package com.withsafe.domain.outdoorUserLocation.repository;

import com.withsafe.domain.outdoorUserLocation.domain.OutdoorUserLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OutdoorUserLocationRepository extends JpaRepository<OutdoorUserLocation, Long> {
}

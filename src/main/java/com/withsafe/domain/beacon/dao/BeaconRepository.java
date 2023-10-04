package com.withsafe.domain.beacon.dao;

import com.withsafe.domain.beacon.domain.Beacon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeaconRepository extends JpaRepository<Beacon, Long> {
}

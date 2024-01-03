package com.withsafe.domain.watchData.dao;

import com.withsafe.domain.watch.domain.Watch;
import com.withsafe.domain.watchData.domain.WatchData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WatchDataRepository extends JpaRepository<WatchData, Long> {
    Optional<Object> findByWatch(Watch watch);
}
package com.withsafe.domain.watchData.dao;

import com.withsafe.domain.watch.domain.WatchJpa;
import com.withsafe.domain.watchData.domain.WatchDataJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WatchDataRepository extends JpaRepository<WatchDataJpa, Long> {
    Optional<Object> findByWatch(WatchJpa watch);
}
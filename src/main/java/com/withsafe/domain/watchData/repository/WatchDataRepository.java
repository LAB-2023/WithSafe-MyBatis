package com.withsafe.domain.watchData.repository;

import com.withsafe.domain.watchData.domain.WatchData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WatchDataRepository extends JpaRepository<WatchData, Long> {
}

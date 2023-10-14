package com.withsafe.domain.watch.dao;

import com.withsafe.domain.watch.domain.Watch;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Primary
@Repository
public interface WatchRepository extends JpaRepository<Watch, Long> {
}

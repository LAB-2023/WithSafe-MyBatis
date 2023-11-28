package com.withsafe.domain.watch.dao;

import com.withsafe.domain.watch.domain.Watch;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Primary
@Repository
public interface WatchRepository extends JpaRepository<Watch, Long> {

    List<Watch> findWatchByDepartmentName(@Param("paramValue") String departmentName);
}

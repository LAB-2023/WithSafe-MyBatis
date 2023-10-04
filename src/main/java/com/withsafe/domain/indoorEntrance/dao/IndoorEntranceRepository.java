package com.withsafe.domain.indoorEntrance.dao;

import com.withsafe.domain.indoorEntrance.domain.IndoorEntrance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface IndoorEntranceRepository extends JpaRepository<IndoorEntrance,Long> {

    //사용자 이름으로 검색
    List<IndoorEntrance> findByWatchUserName(String name);

    //기간으로 검색
    List<IndoorEntrance> findByCreatedDateBetweenAndModifiedDateBetween
    (LocalDateTime startDate, LocalDateTime endTime,LocalDateTime startDate1, LocalDateTime endTime1);

    //이름과 기간으로 검색
    List<IndoorEntrance> findByWatchUserNameAndCreatedDateBetweenAndModifiedDateBetween
    (String name, LocalDateTime startDate, LocalDateTime endTime,LocalDateTime startDate1, LocalDateTime endTime1);

}

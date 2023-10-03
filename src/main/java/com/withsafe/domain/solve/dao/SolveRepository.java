package com.withsafe.domain.solve.dao;

import com.withsafe.domain.solve.domain.Solve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SolveRepository extends JpaRepository<Solve, Long> {

//    @Query("select s from Solve s join s.notice n where n.id = :noticeId")
//    List<Solve> findSolveByNoticeId(@Param("noticeId") Long noticeId);

    //Noice 아이디로 Solve 찾기
    Optional<Solve> findByNoticeId(Long noticeId);
}

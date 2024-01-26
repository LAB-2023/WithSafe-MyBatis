package com.withsafe.domain.solve.dao;

import com.withsafe.domain.solve.domain.SolveJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SolveRepository extends JpaRepository<SolveJpa, Long> {

//    @Query("select s from Solve s join s.notice n where n.id = :noticeId")
//    List<Solve> findSolveByNoticeId(@Param("noticeId") Long noticeId);

    //Noice 아이디로 Solve 찾기
    Optional<SolveJpa> findByNoticeId(Long noticeId);
}

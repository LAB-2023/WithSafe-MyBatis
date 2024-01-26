package com.withsafe.domain.notice.dao;

import com.withsafe.domain.notice.domain.NoticeJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticeRepository extends JpaRepository<NoticeJpa, Long> {
}

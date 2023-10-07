package com.withsafe.domain.notice.dao;

import com.withsafe.domain.notice.domain.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticeRepository extends JpaRepository<Notice, Long>, SearchNoticeRepository {

}

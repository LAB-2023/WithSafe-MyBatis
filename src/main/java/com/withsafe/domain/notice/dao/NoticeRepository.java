package com.withsafe.domain.notice.dao;

import com.withsafe.domain.notice.domain.Notice;
import com.withsafe.domain.notice.dto.NoticeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;

@Repository
public interface NoticeRepository extends JpaRepository<Notice, Long> {

}

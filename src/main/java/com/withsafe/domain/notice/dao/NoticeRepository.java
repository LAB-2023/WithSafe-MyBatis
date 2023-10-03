package com.withsafe.domain.notice.dao;

import com.withsafe.domain.notice.domain.Notice;
import com.withsafe.domain.notice.dto.NoticeDto;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Not;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;

@Repository
public interface NoticeRepository extends JpaRepository<Notice, Long> {

    //경고 알림 메시지에 필요한 엔티티 전부 조회(유저 이름, 부서 이름, 경고 메시지 타입)
    @Query("select n from Notice n join fetch n.warning_message wm join fetch n.watch w join fetch w.user u join fetch  u.department d")
    List<Notice> findAllNotice();
}

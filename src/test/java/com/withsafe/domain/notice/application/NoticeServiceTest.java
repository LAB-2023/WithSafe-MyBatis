package com.withsafe.domain.notice.application;

import com.withsafe.domain.notice.domain.Notice;
import com.withsafe.domain.notice.domain.NoticeType;
import com.withsafe.domain.notice.dto.NoticeWarningContactDto;
import com.withsafe.domain.solve.application.SolveService;
import com.withsafe.domain.solve.dto.SolveDto;
import com.withsafe.domain.user.domain.User;
import com.withsafe.domain.warning.dao.WarningMessageRepository;
import com.withsafe.domain.warning.domain.WarningMessage;
import com.withsafe.domain.warning.domain.WarningMessageType;
import com.withsafe.domain.watch.dao.WatchRepository;
import com.withsafe.domain.watch.domain.Watch;
import com.withsafe.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
@Rollback(value = false)
class NoticeServiceTest {

    @Autowired
    NoticeService noticeService;
    @Autowired
    WatchRepository watchRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    WarningMessageRepository warningMessageRepository;
    @Autowired
    SolveService solveService;

    @Test
    public void 경고알림저장(){

    }

    @Test
    public void 경고알림_전체_조회(){

    }
}
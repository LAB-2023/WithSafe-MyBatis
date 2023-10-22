package com.withsafe.domain.solve.application;

import com.withsafe.domain.notice.dao.NoticeRepository;
import com.withsafe.domain.notice.domain.Notice;
import com.withsafe.domain.notice.domain.NoticeType;
import com.withsafe.domain.solve.domain.Solve;
import com.withsafe.domain.solve.dto.SolveDto;
import com.withsafe.domain.user.dao.UserRepository;
import com.withsafe.domain.user.domain.User;
import com.withsafe.domain.warning.dao.WarningMessageRepository;
import com.withsafe.domain.warning.domain.WarningMessage;
import com.withsafe.domain.warning.domain.WarningMessageType;
import com.withsafe.domain.watch.dao.WatchRepository;
import com.withsafe.domain.watch.domain.Watch;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
@Rollback(value = false)
class SolveServiceTest {

    @Autowired
    SolveService solveService;
    @Autowired
    NoticeRepository noticeRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    WatchRepository watchRepository;
    @Autowired
    WarningMessageRepository warningMessageRepository;

    @Test
    public void 조치_저장(){
        User user = User.builder().name("test").build();
        userRepository.save(user);
        Watch watch = Watch.builder().user(user).model("galaxy").build();
        watchRepository.save(watch);
        WarningMessage warningMessage = WarningMessage.builder().content("hd").type(WarningMessageType.HEART).build();
        warningMessageRepository.save(warningMessage);
        Notice notice =
                Notice.builder().content("gd").noticeType(NoticeType.ENV).warning_message(warningMessage).watch(watch).build();
        Long saveId = noticeRepository.save(notice).getId();

        SolveDto.SaveRequest solveSaveRequest = SolveDto.SaveRequest.builder().content("test").noticeId(saveId).build();
        Long solveId = solveService.saveSolve(solveSaveRequest);

        Solve findSolve = solveService.findById(solveId);

        assertThat(findSolve.getContent()).isEqualTo(solveSaveRequest.getContent());
    }
}
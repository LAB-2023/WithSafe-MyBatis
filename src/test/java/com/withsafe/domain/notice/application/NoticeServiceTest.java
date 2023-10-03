package com.withsafe.domain.notice.application;

import com.withsafe.domain.notice.domain.Notice;
import com.withsafe.domain.notice.domain.NoticeType;
import com.withsafe.domain.notice.dto.NoticeDto;
import com.withsafe.domain.solve.application.SolveService;
import com.withsafe.domain.solve.dao.SolveRepository;
import com.withsafe.domain.solve.dto.SolveDto;
import com.withsafe.domain.user.domain.User;
import com.withsafe.domain.warning.dao.WarningMessageRepository;
import com.withsafe.domain.warning.domain.WarningMessage;
import com.withsafe.domain.warning.domain.WarningMessageType;
import com.withsafe.domain.watch.dao.WatchRepository;
import com.withsafe.domain.watch.domain.Watch;
import com.withsafe.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

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
        User user = User.builder().name("test").build();
        userRepository.save(user);
        Watch watch = Watch.builder().user(user).model("galaxy").build();
        watchRepository.save(watch);
        WarningMessage warningMessage = WarningMessage.builder().content("hd").type(WarningMessageType.HEART).build();
        warningMessageRepository.save(warningMessage);
        NoticeDto.SaveRequest saveRequest = new NoticeDto.SaveRequest("gd", NoticeType.HEART, warningMessage.getId(), watch.getId());
        Long saveId = noticeService.saveNotice(saveRequest);

        Notice noticeById = noticeService.findNoticeById(saveId).get();

        assertThat(noticeById.getContent()).isEqualTo(saveRequest.getContent());
    }

    @Test
    public void 경고알림_전체_조회(){
        User user = User.builder().name("test").build();
        userRepository.save(user);
        Watch watch = Watch.builder().user(user).model("galaxy").build();
        watchRepository.save(watch);
        WarningMessage warningMessage = WarningMessage.builder().content("hd").type(WarningMessageType.HEART).build();
        warningMessageRepository.save(warningMessage);
        NoticeDto.SaveRequest saveRequest = new NoticeDto.SaveRequest("gd", NoticeType.HEART, warningMessage.getId(), watch.getId());
        Long saveId = noticeService.saveNotice(saveRequest);
        SolveDto.SaveRequest solveSaveRequest = new SolveDto.SaveRequest("ㅎㅇ", saveId);
        solveService.saveSolve(solveSaveRequest);

        List<NoticeDto.NoticeResponse> allNotice = noticeService.findAllNotice();
        String result;
        if(allNotice.get(0).getSolveResponse() == null){
            result = "미조치";
        }
        else result = "조치 완료";

        assertThat(allNotice.size()).isEqualTo(1);
        assertThat(result).isEqualTo("조치 완료");
    }
}
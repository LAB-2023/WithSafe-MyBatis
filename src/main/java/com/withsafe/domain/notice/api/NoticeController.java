package com.withsafe.domain.notice.api;

import com.withsafe.domain.notice.application.NoticeService;
import com.withsafe.domain.notice.domain.Notice;
import com.withsafe.domain.notice.domain.NoticeType;
import com.withsafe.domain.notice.dto.NoticeDto;
import com.withsafe.domain.user.domain.User;
import com.withsafe.domain.warning.application.WarningMessageService;
import com.withsafe.domain.warning.dao.WarningMessageRepository;
import com.withsafe.domain.warning.domain.WarningMessage;
import com.withsafe.domain.warning.domain.WarningMessageType;
import com.withsafe.domain.watch.dao.WatchRepository;
import com.withsafe.domain.watch.domain.Watch;
import com.withsafe.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class NoticeController {

    private final NoticeService noticeService;
    private final UserRepository userRepository;
    private final WatchRepository watchRepository;
    private final WarningMessageRepository warningMessageRepository;

    //경고알림 전부 출력
    @GetMapping("/notice-api/list")
    public List<NoticeDto.NoticeResponse> noticeList(){
        return noticeService.findAllNotice();
    }

    @PostMapping("/notice-api/insert")
    public NoticeDto.SaveRequest saveNotice(@RequestBody NoticeDto.SaveRequest saveRequest){

        //테스트용 입력
        User user = new User("name");
        userRepository.save(user);
        Watch watch = new Watch(user, "galaxy");
        watchRepository.save(watch);
        WarningMessage warningMessage = WarningMessage.builder().content("hd").type(WarningMessageType.HEART).build();
        warningMessageRepository.save(warningMessage);

        noticeService.saveNotice(saveRequest);
        return saveRequest;
    }
}

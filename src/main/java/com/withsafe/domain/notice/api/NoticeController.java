package com.withsafe.domain.notice.api;

import com.withsafe.domain.notice.application.NoticeService;
import com.withsafe.domain.notice.domain.NoticeType;
import com.withsafe.domain.notice.dto.NoticeMainResponseDto;
import com.withsafe.domain.notice.dto.NoticeSaveRequestDto;
import com.withsafe.domain.notice.dto.NoticeWarningContactDto;
import com.withsafe.domain.notice.dto.NoticeWarningResponseDto;
import com.withsafe.domain.user.domain.User;
import com.withsafe.domain.warning.dao.WarningMessageRepository;
import com.withsafe.domain.warning.domain.WarningMessage;
import com.withsafe.domain.warning.domain.WarningMessageType;
import com.withsafe.domain.watch.dao.WatchRepository;
import com.withsafe.domain.watch.domain.Watch;
import com.withsafe.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("/notice-api")
@RequiredArgsConstructor
public class NoticeController {

    private final NoticeService noticeService;
    private final UserRepository userRepository;
    private final WatchRepository watchRepository;
    private final WarningMessageRepository warningMessageRepository;

    //메인 화면 경고알림 출력
    @GetMapping(("/main"))
    public List<NoticeMainResponseDto> noticeList(@RequestParam(required = false) NoticeType noticeType){
        return noticeService.findAllMainNotice(noticeType);
    }

    //경고 알림 창 경고 알림 출력
    @GetMapping(("/warning"))
    public List<NoticeWarningResponseDto> noticeList(@RequestParam(required = false) String name,
                                                     @RequestParam(required = false) LocalDateTime startDate,
                                                     @RequestParam(required = false) LocalDateTime endDate,
                                                     @RequestParam int option){
        return noticeService.findAllWarningNotice(name, startDate, endDate, option);
    }

    @GetMapping("/emergency_contact")
    public List<NoticeWarningContactDto> emergencyContactList(@RequestParam(required = false) String name,
                                                              @RequestParam(required = false) String phoneNumber){
        return noticeService.findAllWarningContactNotice(name, phoneNumber);
    }

    @PostMapping
    public NoticeSaveRequestDto saveNotice(@RequestBody NoticeSaveRequestDto saveRequest){
        //테스트용 입력
        User user = User.builder().name("gd").build();
        userRepository.save(user);
        Watch watch = Watch.builder().model("galaxy").user(user).build();
        watchRepository.save(watch);
        WarningMessage warningMessage = WarningMessage.builder().content("hd").type(WarningMessageType.HEART).build();
        warningMessageRepository.save(warningMessage);

        noticeService.saveNotice(saveRequest);
        return saveRequest;
    }
}

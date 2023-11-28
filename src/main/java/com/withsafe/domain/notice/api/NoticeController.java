package com.withsafe.domain.notice.api;

import com.withsafe.domain.department.dao.DepartmentRepository;
import com.withsafe.domain.department.domain.Department;
import com.withsafe.domain.notice.application.NoticeService;
import com.withsafe.domain.notice.domain.NoticeType;
import com.withsafe.domain.notice.dto.NoticeMainResponseDto;
import com.withsafe.domain.notice.dto.NoticeSaveRequestDto;
import com.withsafe.domain.notice.dto.NoticeEmergencyContactDto;
import com.withsafe.domain.notice.dto.NoticeWarningResponseDto;
import com.withsafe.domain.user.dao.UserRepository;
import com.withsafe.domain.user.domain.User;
import com.withsafe.domain.warning.dao.WarningMessageRepository;
import com.withsafe.domain.warning.domain.WarningMessage;
import com.withsafe.domain.warning.domain.WarningMessageType;
import com.withsafe.domain.watch.dao.WatchRepository;
import com.withsafe.domain.watch.domain.Watch;
import com.withsafe.global.util.SecurityUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

import static com.withsafe.domain.admin.constant.SessionConstants.*;
import static com.withsafe.domain.admin.dto.AdminDto.*;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/notice-api")
@RequiredArgsConstructor
public class NoticeController {

    private final NoticeService noticeService;
    private final UserRepository userRepository;
    private final WatchRepository watchRepository;
    private final WarningMessageRepository warningMessageRepository;
    private final DepartmentRepository departmentRepository;

    //메인 화면 경고알림 출력
    @GetMapping("/main")
    public Page<NoticeMainResponseDto> noticeList(@RequestParam(required = false) NoticeType noticeType,
                                                  @RequestParam String departmentName,
                                                  Pageable pageable){
        return noticeService.findAllMainNotice(noticeType, pageable, departmentName);
    }

    //경고 알림 창 경고 알림 출력
    @GetMapping("/warning")
    public Page<NoticeWarningResponseDto> noticeList(@RequestParam(required = false) String name,
                                                     @RequestParam(required = false) LocalDateTime startDate,
                                                     @RequestParam(required = false) LocalDateTime endDate,
                                                     @RequestParam int option,
                                                     @RequestParam String departmentName,
                                                     Pageable pageable){

        return noticeService.findAllWarningNotice(name, startDate, endDate, option, pageable, departmentName);
    }

    //긴급 연락 망 리스트 출력
    //일단 보류
    @GetMapping("/emergency-contact")
    public Page<NoticeEmergencyContactDto> emergencyContactList(@RequestParam(required = false) String name,
                                                                @RequestParam(required = false) String phoneNumber,
                                                                @RequestParam String departmentName,
                                                                Pageable pageable){
        return noticeService.findAllEmergencyContactNotice(name, phoneNumber, departmentName, pageable);
    }

    @PostMapping
    public ResponseEntity<NoticeSaveRequestDto> saveNotice(@RequestBody NoticeSaveRequestDto saveRequest,
                                                           @RequestParam String departmentName){
        noticeService.saveNotice(saveRequest, departmentName);
        return ResponseEntity.ok(saveRequest);
    }

    @PostMapping("/test")
    public void test(){
        //테스트용 입력
        Department department = departmentRepository
                .findByName("TESTCOMPANY").orElseThrow(() -> new RuntimeException("부서가 존재하지 않습니다."));
        User user = User.builder().name("gd").phoneNum("010-1234-1234").build();
        userRepository.save(user);
        Watch watch = Watch.builder().model("galaxy").user(user).department(department).build();
        watchRepository.save(watch);
        WarningMessage warningMessage1 = WarningMessage.builder().content("휴식").type(WarningMessageType.HEART).build();
        warningMessageRepository.save(warningMessage1);
        WarningMessage warningMessage2 = WarningMessage.builder().content("승인").type(WarningMessageType.NO_APPROVE).build();
        warningMessageRepository.save(warningMessage2);
        WarningMessage warningMessage3 = WarningMessage.builder().content("위험").type(WarningMessageType.DANGER_ZONE).build();
        warningMessageRepository.save(warningMessage3);
        WarningMessage warningMessage4 = WarningMessage.builder().content("성별").type(WarningMessageType.GENDER_SPECIFIC_AREA).build();
        warningMessageRepository.save(warningMessage4);
        WarningMessage warningMessage5 = WarningMessage.builder().content("턱끈").type(WarningMessageType.NO_EQUIPMENT).build();
        warningMessageRepository.save(warningMessage5);
    }
}
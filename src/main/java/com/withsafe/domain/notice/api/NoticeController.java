package com.withsafe.domain.notice.api;

import com.withsafe.domain.department.dao.DepartmentRepository;
import com.withsafe.domain.department.domain.Department;
import com.withsafe.domain.notice.application.NoticeService;
import com.withsafe.domain.notice.domain.NoticeType;
import com.withsafe.domain.notice.dto.*;
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

    @GetMapping("/warning/list")
    public ResponseEntity<NoticeWarningResponseListDto> notice(@RequestParam(required = false) String name,
                                                               @RequestParam(required = false) LocalDateTime startDate,
                                                               @RequestParam(required = false) LocalDateTime endDate,
                                                               @RequestParam int option,
                                                               @RequestParam String departmentName,
                                                               Pageable pageable){
        Page<NoticeWarningResponseDto> result =
                noticeService.findAllWarningNotice(name, startDate, endDate, option, pageable, departmentName);
        long entire = 0L, solve = 0;
        for (NoticeWarningResponseDto noticeWarningResponseDto : result) {
            entire++;
            if(noticeWarningResponseDto.getSolveContent() == null){
                solve += 1L;
            }
        }
        NoticeWarningResponseListDto build = NoticeWarningResponseListDto.builder()
                .list(result)
                .entire(entire)
                .solve(solve)
                .notSolve(entire-solve)
                .build();
        return ResponseEntity.ok(build);
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

    //경고 알림 메시지 저장
    @PostMapping
    public ResponseEntity<NoticeSaveRequestDto> saveNotice(@RequestBody NoticeSaveRequestDto saveRequest,
                                                           @RequestParam String departmentName){
        noticeService.saveNotice(saveRequest, departmentName);
        return ResponseEntity.ok(saveRequest);
    }
}
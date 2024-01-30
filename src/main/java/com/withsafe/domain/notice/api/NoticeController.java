package com.withsafe.domain.notice.api;

import com.github.pagehelper.PageInfo;
import com.withsafe.domain.department.dao.DepartmentRepository;
import com.withsafe.domain.notice.application.NoticeService;
import com.withsafe.domain.notice.domain.NoticeType;
import com.withsafe.domain.notice.dto.*;
import com.withsafe.domain.user.dao.UserRepository;
import com.withsafe.domain.warning.dao.WarningMessageRepository;
import com.withsafe.domain.watch.dao.WatchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/notice")
@RequiredArgsConstructor
public class NoticeController {

    private final NoticeService noticeService;


    //경고 알림 메시지 저장
    @PostMapping
    public ResponseEntity<NoticeSaveRequestDto> saveNotice(@RequestBody NoticeSaveRequestDto saveRequest,
                                                           @RequestParam String departmentName){
        noticeService.saveNotice(saveRequest, departmentName);
        return ResponseEntity.ok(saveRequest);
    }

    //메인 화면 경고알림 출력
    @GetMapping("/main")
    public ResponseEntity<PageInfo> noticeList(@RequestParam int page,
                                               @RequestParam int size,
                                               @RequestParam(required = false) NoticeType noticeType,
                                               @RequestParam String departmentName){
        return ResponseEntity.ok(noticeService.findAllMainNotice(page, size, noticeType, departmentName));
    }

    //경고 알림 창 경고 알림 출력
    @GetMapping("/warning")
    public ResponseEntity<PageInfo> noticeList(@RequestParam int page,
                                               @RequestParam int size,
                                               @RequestParam(required = false) String username,
                                               @RequestParam(required = false) LocalDateTime startDate,
                                               @RequestParam(required = false) LocalDateTime endDate,
                                               @RequestParam String departmentName){

        return ResponseEntity.ok(
                noticeService.findAllWarningNotice(page, size, username, startDate, endDate, departmentName)
        );
    }
}
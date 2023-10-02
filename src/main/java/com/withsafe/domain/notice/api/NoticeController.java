package com.withsafe.domain.notice.api;

import com.withsafe.domain.notice.application.NoticeService;
import com.withsafe.domain.notice.dto.NoticeDto;
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

    //경고알림 전부 출력
    @GetMapping("/mapping-get-api")
    public List<NoticeDto.NoticeResponse> test(){
        return noticeService.findAllNotice();
    }

    @PostMapping("/notice-post-api")
    public NoticeDto.SaveRequest saveNotice(@RequestBody NoticeDto.SaveRequest saveRequest){
        noticeService.saveNotice(saveRequest);
        return saveRequest;
    }
}

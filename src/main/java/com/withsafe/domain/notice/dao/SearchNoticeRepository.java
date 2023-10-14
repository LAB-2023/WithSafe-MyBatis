package com.withsafe.domain.notice.dao;

import com.withsafe.domain.notice.domain.NoticeType;
import com.withsafe.domain.notice.dto.NoticeMainResponseDto;
import com.withsafe.domain.notice.dto.NoticeEmergencyContactDto;
import com.withsafe.domain.notice.dto.NoticeWarningResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;

public interface SearchNoticeRepository {

    //메인 화면 경고 알림창
    Page<NoticeMainResponseDto> noticeMainResponseDtoPage(NoticeType noticeType, Pageable pageable);

    //경고 화면 경고 알림창
    Page<NoticeWarningResponseDto> noticeWarningResponseDtoPage(String name,
                                                                LocalDateTime startDate,
                                                                LocalDateTime endDate,
                                                                int option,
                                                                Pageable pageable);

    //긴급 연락망 출력
    Page<NoticeEmergencyContactDto> noticeEmergencyContactResponseDtoPage(String name, String phoneNumber, Pageable pageable);
}

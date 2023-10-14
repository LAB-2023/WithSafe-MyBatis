package com.withsafe.domain.notice.dao;

import com.withsafe.domain.notice.domain.NoticeType;
import com.withsafe.domain.notice.dto.NoticeMainResponseDto;
import com.withsafe.domain.notice.dto.NoticeWarningContactDto;
import com.withsafe.domain.notice.dto.NoticeWarningResponseDto;

import java.time.LocalDateTime;
import java.util.List;

public interface SearchNoticeRepository {

    //메인 화면 경고 알림창
    List<NoticeMainResponseDto> findNoticeMainResponseDto(NoticeType noticeType);

    //경고 화면 경고 알림창
    List<NoticeWarningResponseDto> findNoticeWarningResponseDto(String name,
                                                                LocalDateTime startDate,
                                                                LocalDateTime endDate,
                                                                int option);

    //긴급 연락망 출력
    List<NoticeWarningContactDto> findNoticeWarningContactResponseDto(String name, String phoneNumber);
}

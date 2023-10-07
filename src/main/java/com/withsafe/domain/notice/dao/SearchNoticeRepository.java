package com.withsafe.domain.notice.dao;

import com.withsafe.domain.notice.domain.NoticeType;
import com.withsafe.domain.notice.dto.NoticeMainResponseDto;
import com.withsafe.domain.notice.dto.NoticeWarningResponseDto;

import java.time.LocalDateTime;
import java.util.List;

public interface SearchNoticeRepository {
    List<NoticeMainResponseDto> findNoticeMainResponseDto(NoticeType noticeType);

    List<NoticeWarningResponseDto> findNoticeWarningResponseDto(String username,
                                                                LocalDateTime startDate,
                                                                LocalDateTime endDate,
                                                                int opiton);
}

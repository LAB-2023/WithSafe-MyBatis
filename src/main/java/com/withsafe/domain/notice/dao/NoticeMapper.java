package com.withsafe.domain.notice.dao;

import com.withsafe.domain.notice.domain.Notice;
import com.withsafe.domain.notice.domain.NoticeType;
import com.withsafe.domain.notice.dto.NoticeMainResponseDto;
import com.withsafe.domain.notice.dto.NoticeWarningResponseDto;
import org.apache.ibatis.annotations.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Mapper
public interface NoticeMapper {
    @Insert("INSERT INTO notice (created_date, modified_date, content, notice_type, warning_message_id, watch_id) " +
            "VALUES (#{createdDate}, #{modifiedDate}, #{content}, #{noticeType}, #{warning_message.id}, #{watch.id})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "notice_id")
    void save(Notice notice);

    @Select("SELECT * FROM notice WHERE notice_id = #{id}")
    @ResultMap("noticeResultMap")
    Optional<Notice> findById(Long id);

    List<NoticeMainResponseDto> noticeMainResponseDtoPage(NoticeType noticeType, String departmentName);

    List<NoticeWarningResponseDto> noticeWarningResponseDtoPage(String username, LocalDateTime startDate,
                                                                LocalDateTime endDate, String departmentName);
}

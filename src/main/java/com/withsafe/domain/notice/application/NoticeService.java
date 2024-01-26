package com.withsafe.domain.notice.application;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.withsafe.domain.notice.dao.NoticeMapper;
import com.withsafe.domain.notice.dao.NoticeRepository;
import com.withsafe.domain.notice.domain.Notice;
import com.withsafe.domain.notice.domain.NoticeType;
import com.withsafe.domain.notice.dto.NoticeMainResponseDto;
import com.withsafe.domain.notice.dto.NoticeSaveRequestDto;
import com.withsafe.domain.notice.dto.NoticeEmergencyContactDto;
import com.withsafe.domain.notice.dto.NoticeWarningResponseDto;
import com.withsafe.domain.notice.exception.WatchNotFoundException;
import com.withsafe.domain.user.dao.UserMapper;
import com.withsafe.domain.warning.dao.WarningMessageMapper;
import com.withsafe.domain.warning.domain.WarningMessage;
import com.withsafe.domain.watch.dao.WatchMapper;
import com.withsafe.domain.watch.domain.Watch;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/*
    필요기능
    1. 경고 알림 현황 및 조치 사항 출력
    2. 전체, 미조치, 조치 필터링
    3. 사용자 이름 검색 + 기간 별 검색
    4. 조치, 미조치 파악 필요
    5. 워치 이용자 정보 추출 -> watchId를 기준으로 사용자 + 현재 위치 파악 필요
 */
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class NoticeService {

    private final NoticeMapper noticeMapper;
    private final WatchMapper watchMapper;
    private final UserMapper userMapper;
    private final WarningMessageMapper warningMessageMapper;

    //경고 알림 저장
    @Transactional
    public Long saveNotice(NoticeSaveRequestDto saveRequest, String departmentName){
        Watch watch =
                watchMapper.findById(saveRequest.getWatchId()).orElseThrow(WatchNotFoundException::new);
        WarningMessage warningMessage =
                warningMessageMapper.findWarningMessageByTypeAndDepartmentName(saveRequest.getWarningMessageType(), departmentName)
                        .orElseThrow(() -> new RuntimeException("경고 메시지가 존재하지 않습니다."));

        Notice notice = saveRequest.toEntity(warningMessage, watch);
        noticeMapper.save(notice);
        return notice.getId();
    }

    //메인 경고 알림 전체 출력
    public PageInfo<NoticeMainResponseDto> findAllMainNotice(int page, int size, NoticeType noticeType, String departmentName){
        PageHelper.startPage(page, size);
        List<NoticeMainResponseDto> result = noticeMapper.noticeMainResponseDtoPage(noticeType, departmentName);
        return new PageInfo<>(result);
    }

    //경고 창 경고 알림 전체 출력
    public PageInfo<NoticeWarningResponseDto> findAllWarningNotice(int page, int size, String username,
                                                                   LocalDateTime startDate, LocalDateTime endDate,
                                                                   String departmentName){
        PageHelper.startPage(page, size);

        List<NoticeWarningResponseDto> result =
                noticeMapper.noticeWarningResponseDtoPage(username, startDate, endDate, departmentName);
        return new PageInfo<>(result);
    }
//
//    //긴급 연락망 클릭 시 연락망 리스트 출력
//    public Page<NoticeEmergencyContactDto> findAllEmergencyContactNotice(String name, String phoneNumber,
//                                                                         String departmentName, Pageable pageable){
//        return noticeRepository.noticeEmergencyContactResponseDtoPage(name, phoneNumber, departmentName, pageable);
//    }
//
//    //테스트 용
//    public Optional<NoticeJpa> findNoticeById(Long id){
//        return noticeRepository.findById(id);
//    }
}
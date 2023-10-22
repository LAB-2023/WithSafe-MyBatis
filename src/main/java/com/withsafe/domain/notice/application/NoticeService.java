package com.withsafe.domain.notice.application;

import com.withsafe.domain.notice.dao.NoticeRepository;
import com.withsafe.domain.notice.domain.Notice;
import com.withsafe.domain.notice.domain.NoticeType;
import com.withsafe.domain.notice.dto.NoticeMainResponseDto;
import com.withsafe.domain.notice.dto.NoticeSaveRequestDto;
import com.withsafe.domain.notice.dto.NoticeEmergencyContactDto;
import com.withsafe.domain.notice.dto.NoticeWarningResponseDto;
import com.withsafe.domain.notice.exception.WatchNotFoundException;
import com.withsafe.domain.solve.application.SolveService;
import com.withsafe.domain.solve.domain.Solve;
import com.withsafe.domain.solve.dto.SolveDto;
import com.withsafe.domain.user.dao.UserRepository;
import com.withsafe.domain.user.domain.User;
import com.withsafe.domain.warning.application.WarningMessageService;
import com.withsafe.domain.warning.dao.WarningMessageRepository;
import com.withsafe.domain.warning.domain.WarningMessage;
import com.withsafe.domain.watch.dao.WatchRepository;
import com.withsafe.domain.watch.domain.Watch;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
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

    private final NoticeRepository noticeRepository;
    private final WatchRepository watchRepository;
    private final UserRepository userRepository;
    private final WarningMessageRepository warningMessageRepository;
    private final SolveService solveService;

    //경고 알림 저장
    @Transactional
    public Long saveNotice(NoticeSaveRequestDto saveRequest){
        Watch watch =
                watchRepository.findById(saveRequest.getWatchId()).orElseThrow(WatchNotFoundException::new);
        WarningMessage warningMessage =
                warningMessageRepository.findById(saveRequest.getWarningMessageId()).orElseThrow(WatchNotFoundException::new);

        Notice notice = saveRequest.toEntity(warningMessage, watch);

        noticeRepository.save(notice);
        return notice.getId();
    }

    //메인 경고 알림 전체 출력
    public Page<NoticeMainResponseDto> findAllMainNotice(NoticeType noticeType, Pageable pageable){
        return noticeRepository.noticeMainResponseDtoPage(noticeType, pageable);
    }

    //경고 창 경고 알림 전체 출력
    public Page<NoticeWarningResponseDto> findAllWarningNotice(String name, LocalDateTime startDate, LocalDateTime endDate,
                                                               int option, Pageable pageable){
        return noticeRepository.noticeWarningResponseDtoPage(name, startDate, endDate, option, pageable);
    }

    //긴급 연락망 클릭 시 연락망 리스트 출력
    public Page<NoticeEmergencyContactDto> findAllEmergencyContactNotice(String name, String phoneNumber, Pageable pageable){
        return noticeRepository.noticeEmergencyContactResponseDtoPage(name, phoneNumber, pageable);
    }

    //테스트 용
    public Optional<Notice> findNoticeById(Long id){
        return noticeRepository.findById(id);
    }
}
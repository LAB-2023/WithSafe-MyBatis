package com.withsafe.domain.notice.application;

import com.withsafe.domain.notice.dao.NoticeRepository;
import com.withsafe.domain.notice.domain.Notice;
import com.withsafe.domain.notice.domain.NoticeType;
import com.withsafe.domain.notice.dto.NoticeMainResponseDto;
import com.withsafe.domain.notice.dto.NoticeSaveRequestDto;
import com.withsafe.domain.notice.dto.NoticeWarningContactDto;
import com.withsafe.domain.notice.dto.NoticeWarningResponseDto;
import com.withsafe.domain.notice.exception.WatchNotFoundException;
import com.withsafe.domain.solve.application.SolveService;
import com.withsafe.domain.warning.dao.WarningMessageRepository;
import com.withsafe.domain.warning.domain.WarningMessage;
import com.withsafe.domain.watch.dao.WatchRepository;
import com.withsafe.domain.watch.domain.Watch;
import com.withsafe.repository.UserRepository;
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

    private final NoticeRepository noticeRepository;
    private final WatchRepository watchRepository;
    private final UserRepository userRepository;
    private final WarningMessageRepository warningMessageRepository;
    private final SolveService solveService;

    //경고 알림 저장
    @Transactional
    public Long saveNotice(NoticeSaveRequestDto saveRequest){
        Watch watch =
                watchRepository.findById(saveRequest.getWatchId()).orElseThrow(() -> new WatchNotFoundException());
        WarningMessage warningMessage =
                warningMessageRepository.findById(saveRequest.getWarningMessageId()).orElseThrow(() -> new WatchNotFoundException());

        Notice notice = saveRequest.toEntity(warningMessage, watch);

        noticeRepository.save(notice);
        return notice.getId();
    }

    //메인 경고 알림 전체 출력
    public List<NoticeMainResponseDto> findAllMainNotice(NoticeType noticeType){
        return noticeRepository.findNoticeMainResponseDto(noticeType);
    }

    //경고 창 경고 알림 전체 출력
    public List<NoticeWarningResponseDto> findAllWarningNotice(String name, LocalDateTime startDate, LocalDateTime endDate, int option){
        return noticeRepository.findNoticeWarningResponseDto(name, startDate, endDate, option);
    }

    //긴급 연락망 클릭 시 연락망 리스트 출력
    public List<NoticeWarningContactDto> findAllWarningContactNotice(String name, String phoneNumber){
        return noticeRepository.findNoticeWarningContactResponseDto(name, phoneNumber);
    }

    //테스트 용
    public Optional<Notice> findNoticeById(Long id){
        return noticeRepository.findById(id);
    }
}

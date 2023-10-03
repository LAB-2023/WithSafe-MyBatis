package com.withsafe.domain.notice.application;

import com.withsafe.domain.notice.dao.NoticeRepository;
import com.withsafe.domain.notice.domain.Notice;
import com.withsafe.domain.notice.domain.NoticeType;
import com.withsafe.domain.notice.dto.NoticeDto;
import com.withsafe.domain.notice.exception.WatchNotFoundException;
import com.withsafe.domain.solve.application.SolveService;
import com.withsafe.domain.solve.domain.Solve;
import com.withsafe.domain.solve.dto.SolveDto;
import com.withsafe.domain.user.domain.User;
import com.withsafe.domain.warning.application.WarningMessageService;
import com.withsafe.domain.warning.dao.WarningMessageRepository;
import com.withsafe.domain.warning.domain.WarningMessage;
import com.withsafe.domain.warning.domain.WarningMessageType;
import com.withsafe.domain.watch.application.WatchService;
import com.withsafe.domain.watch.dao.WatchRepository;
import com.withsafe.domain.watch.domain.Watch;
import com.withsafe.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
    public Long saveNotice(NoticeDto.SaveRequest saveRequest){
        Watch watch =
                watchRepository.findById(saveRequest.getWatchId()).orElseThrow(() -> new WatchNotFoundException());
        WarningMessage warningMessage =
                warningMessageRepository.findById(saveRequest.getWarningMessageId()).orElseThrow(() -> new WatchNotFoundException());

        Notice notice = new Notice(saveRequest.getContent(), saveRequest.getType(), warningMessage, watch);
        noticeRepository.save(notice);
        return notice.getId();
    }

    public Optional<Notice> findNoticeById(Long id){
        return noticeRepository.findById(id);
    }

    //경고 알림 전체 출력
    public List<NoticeDto.NoticeResponse> findAllNotice(){
        List<Notice> all = noticeRepository.findAllNotice();
        List<NoticeDto.NoticeResponse> noticeResponseList = new ArrayList<>();
        for(Notice notice : all){
            noticeResponseList.add(createNoticeResponse(notice));
        }
        return noticeResponseList;
    }

    //Notice type 별 필터링


    //noticeDto.NoticeReponse 생성 함수
    public NoticeDto.NoticeResponse createNoticeResponse(Notice notice){
        Long id = notice.getId();
        String username = notice.getWatch().getUser().getName();
        //String departmentName = notice.getWatch().getUser().getDepartment().getName();
        WarningMessageType type = notice.getWarning_message().getType();
        LocalDateTime createdDate = notice.getCreatedDate();

        //조치 사항이 존재하는 지 확인 -> 1대1 매핑은 무조건 즉시 로딩이기 때문에 여기서 해결
        SolveDto.SolveResponse solveResponse= null;
        if(notice.getSolve() != null){
            solveResponse = new SolveDto.SolveResponse(notice.getSolve().getContent(), notice.getSolve().getCreatedDate());
        }
        return new NoticeDto.NoticeResponse(id, username, type, solveResponse, createdDate);
    }
}

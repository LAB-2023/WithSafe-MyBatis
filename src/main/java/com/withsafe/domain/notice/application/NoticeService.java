package com.withsafe.domain.notice.application;

import com.withsafe.domain.notice.dao.NoticeRepository;
import com.withsafe.domain.notice.domain.Notice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/*
    필요기능
    1. 경고 알림 현황 및 조치 사항 출력
    2. 전체, 미조치, 조치완료 필터링 필요 -> QueryDSL? 잘 모르겠음
    3. 사용자 이름 검색 + 기간 별 검색도 가능해야함 -> 이것도 QueryDSL?
    4. 조치, 미조치 파악 필요
    5. 워치 이용자 정보 추출 -> watchId를 기준으로 사용자 + 현재 위치 파악 필요
 */
@Service
@RequiredArgsConstructor
public class NoticeService {

    private final NoticeRepository noticeRepository;

    public List<Notice> findAllNotice(){
        return noticeRepository.findAll();
    }
}

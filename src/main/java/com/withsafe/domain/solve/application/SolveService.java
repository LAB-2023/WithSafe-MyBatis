package com.withsafe.domain.solve.application;

import com.withsafe.domain.notice.dao.NoticeMapper;
import com.withsafe.domain.notice.domain.Notice;
import com.withsafe.domain.notice.exception.NoticeNotFoundException;
import com.withsafe.domain.solve.dao.SolveMapper;
import com.withsafe.domain.solve.domain.Solve;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.withsafe.domain.solve.dto.SolveDto.*;

/*
    minimum ppt p.8
    필요 기능
    1. 조치 사항 저장
    2. 조치 여부 확인 -> solve에 notice id에 대한 매핑이 없으면 미조치 -> 아마 notice api에서 체크?
 */
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SolveService {

    private final SolveMapper solveMapper;
    private final NoticeMapper noticeMapper;

    //조치 저장
    @Transactional
    public Long saveSolve(SaveRequest saveRequest){
        Notice notice =
                noticeMapper.findById(saveRequest.getNoticeId()).orElseThrow(() -> new NoticeNotFoundException());
        Solve solve = saveRequest.toEntity(notice);
        solveMapper.save(solve);
        return solve.getId();
    }
}

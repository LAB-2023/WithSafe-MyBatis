package com.withsafe.domain.solve.application;

import com.withsafe.domain.notice.dao.NoticeRepository;
import com.withsafe.domain.notice.domain.Notice;
import com.withsafe.domain.notice.exception.NoticeNotFoundException;
import com.withsafe.domain.solve.dao.SolveRepository;
import com.withsafe.domain.solve.domain.Solve;
import com.withsafe.domain.solve.dto.SolveDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    private final SolveRepository solveRepository;
    private final NoticeRepository noticeRepository;

    //조치 저장
    @Transactional
    public Long saveSolve(SolveDto.SaveRequest saveRequest){
        Notice notice =
                noticeRepository.findById(saveRequest.getNoticeId()).orElseThrow(() -> new NoticeNotFoundException());
        Solve solve = saveRequest.toEntity(notice);
        solveRepository.save(solve);
        return solve.getId();
    }

    //테스트용 solve 아이디로 엔티티 찾기
    public Solve findById(Long id){
        return solveRepository.findById(id).get();
    }
}

package com.withsafe.domain.solve.application;

import com.withsafe.domain.notice.dao.NoticeRepository;
import com.withsafe.domain.notice.domain.Notice;
import com.withsafe.domain.notice.exception.NoticeNotFoundException;
import com.withsafe.domain.solve.dao.SolveRepository;
import com.withsafe.domain.solve.domain.Solve;
import com.withsafe.domain.solve.dto.SolveDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
public class SolveService {

    private final SolveRepository solveRepository;
    private final NoticeRepository noticeRepository;

    //조치 저장
    public Long saveSolve(SolveDto.SaveRequest saveRequest){
        Notice notice = noticeRepository.findById(saveRequest.getNoticeId()).orElseThrow(() -> new NoticeNotFoundException());
        Solve solve = new Solve(saveRequest.getContent(), notice);
        solveRepository.save(solve);
        return solve.getId();
    }

    //알림에 대한 조치 사항이 있는 지 확인 -> list size가 0 이면 조치 사항 x
    public SolveDto.SolveResponse findSolveFromNoticeId(Long noticeId){
        List<Solve> findSolveList = solveRepository.findByNoticeId(noticeId);
        if(findSolveList.isEmpty()){
            return null;
        }
        return new SolveDto.SolveResponse(findSolveList.get(0).getContent(), findSolveList.get(0).getCreatedDate());
    }

    //테스트용 solve 아이디로 엔티티 찾기
    public Solve findById(Long id){
        return solveRepository.findById(id).get();
    }
}

package com.withsafe.domain.watch.application;

import com.withsafe.domain.watch.dao.WatchRepository;
import com.withsafe.domain.watch.domain.Watch;
import com.withsafe.domain.watch.dto.WatchDTO.SaveRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

import static com.withsafe.domain.watch.dto.WatchDTO.*;

/**
 * 필요한 기능 CRUD
 * 1. 워치 등록
 * 2. 워치 삭제
 * 3. 워치 검색
 * 4. 워치(디바이스)와 유저 매핑
 */

@Service
@RequiredArgsConstructor
public class WatchService {
    private final WatchRepository watchRepository;
    //워치 등록
    @Transactional
    public Long saveWatch(@RequestBody SaveRequest request) {
        Watch savedWatch = watchRepository.save(request.toEntity());
        return savedWatch.getId();
    }
    //전체 워치 조회
    @Transactional
    public List<FindRequest> findAllWatch(FindRequest request) {
        List<Watch> watchList = watchRepository.findAll();

        List<FindRequest> findRequestList = watchList.stream()
                .map(FindRequest::toFindRequest)
                .collect(Collectors.toList());
        return findRequestList;
    }
}

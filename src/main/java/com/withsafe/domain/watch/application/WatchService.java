package com.withsafe.domain.watch.application;

import com.withsafe.domain.watch.dto.WatchDTO;
import com.withsafe.repository.UserRepository;
import com.withsafe.domain.watch.dao.WatchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 필요한 기능
 * 1. 워치 등록
 * 2. 워치 삭제
 * 3. 워치 검색
 * 4. 워치(디바이스)와 유저 매핑
 */

@Service
@RequiredArgsConstructor
public class WatchService {
    private final WatchRepository watchRepository;
    private final UserRepository userRepository;

//    @Transactional
//    public Long saveWatch(WatchDTO.SaveRequest request) {
//        return watchRepository.save(request.toEntity()).getId();
//    }
}

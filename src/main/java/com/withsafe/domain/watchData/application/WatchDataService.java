package com.withsafe.domain.watchData.application;

import com.withsafe.domain.watch.dao.WatchRepository;
import com.withsafe.domain.watch.domain.Watch;
import com.withsafe.domain.watchData.dao.WatchDataRepository;
import com.withsafe.domain.watchData.domain.WatchData;
import com.withsafe.domain.watchData.dto.WatchDataDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

import static com.withsafe.domain.watchData.dto.WatchDataDTO.*;

@Service
@RequiredArgsConstructor
public class WatchDataService {
    private final WatchRepository watchRepository;
    private final WatchDataRepository watchDataRepository;

    @Transactional
    public Long saveWatchData(@RequestBody SaveRequest request, @RequestParam Long watchId){
        Watch watch = watchRepository.findById(watchId).orElseThrow(() -> new IllegalArgumentException("해당 워치가 없습니다."));
        WatchData savedWatchData = watchDataRepository.save(request.toEntity(watch));
        return savedWatchData.getId();
    }

    @Transactional
    public Long updateWatchData(@RequestBody SaveRequest request, @RequestParam Long watchId){
        Watch watch = watchRepository.findById(watchId).orElseThrow(() -> new IllegalArgumentException("해당 워치가 없습니다."));
        WatchData watchData = (WatchData) watchDataRepository.findByWatch(watch).orElseThrow(() -> new IllegalArgumentException("해당 워치 데이터가 없습니다."));
        watchData.update(request);
        return watchData.getId();
    }

    public List<FindRequest> findAllWatchData(String departmentName) {
        List<WatchData> watchDataList = watchDataRepository.findAll();
        List<FindRequest> watchDataDTOList = new ArrayList<>();
        for (WatchData watchData : watchDataList) {
            if (watchData.getWatch().getDepartment().getName().equals(departmentName)) {
                watchDataDTOList.add(FindRequest.toFindRequest(watchData));
            }
        }
        return watchDataDTOList;
    }
}
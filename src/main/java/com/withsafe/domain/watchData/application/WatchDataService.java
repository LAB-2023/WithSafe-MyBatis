package com.withsafe.domain.watchData.application;

import com.withsafe.domain.watch.dao.WatchMapper;
import com.withsafe.domain.watch.domain.Watch;
import com.withsafe.domain.watchData.dao.WatchDataMapper;
import com.withsafe.domain.watchData.domain.WatchData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static com.withsafe.domain.watchData.dto.WatchDataDTO.*;

@Service
@RequiredArgsConstructor
public class WatchDataService {
    private final WatchMapper watchMapper;
    private final WatchDataMapper watchDataMapper;

    @Transactional
    public Long saveWatchData(SaveRequest request){
        Watch watch = watchMapper.findBySerialNum(request.getSerialNum())
                .orElseThrow(() -> new IllegalArgumentException("해당 워치가 없습니다."));
        WatchData savedWatchData = request.toEntity(watch);
        watchDataMapper.save(savedWatchData);
        return savedWatchData.getId();
    }

    @Transactional
    public Long updateWatchData(SaveRequest request){
        Watch watch = watchMapper.findBySerialNum(request.getSerialNum())
                .orElseThrow(() -> new IllegalArgumentException("해당 워치가 없습니다."));
        WatchData watchData = watchDataMapper.findByWatchId(watch.getId())
                .orElseThrow(() -> new IllegalArgumentException("해당 워치 데이터가 없습니다."));
        watchData.update(request);
        watchDataMapper.update(watchData);
        return watchData.getId();
    }

//    public List<FindRequest> findAllWatchData(String departmentName) {
//        List<WatchData> watchDataList = watchDataMapper.findAll();
//        List<FindRequest> watchDataDTOList = new ArrayList<>();
//        for (WatchData watchData : watchDataList) {
//            if (watchData.getWatch().getDepartmentJpa().getName().equals(departmentName)) {
//                watchDataDTOList.add(FindRequest.toFindRequest(watchData));
//            }
//        }
//        return watchDataDTOList;
//    }
}
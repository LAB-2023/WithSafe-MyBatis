package com.withsafe.domain.watch.application;

import com.withsafe.domain.department.dao.DepartmentRepository;
import com.withsafe.domain.department.domain.Department;
import com.withsafe.domain.user.dao.UserRepository;
import com.withsafe.domain.user.domain.User;
import com.withsafe.domain.watch.dao.WatchRepository;
import com.withsafe.domain.watch.domain.Watch;
import com.withsafe.domain.watch.dto.WatchDTO.SaveRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
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
    private final DepartmentRepository departmentRepository;
    private final UserRepository userRepository;
    //워치 등록
    @Transactional
    public Long saveWatch(@RequestBody SaveRequest request, @RequestParam String departmentName) {
        Department department = departmentRepository.findByName(departmentName).orElseThrow(() -> new IllegalArgumentException("해당 부서가 없습니다."));
        Watch savedWatch = watchRepository.save(request.toEntity(department));
        return savedWatch.getId();
    }
    //전체 워치 조회
    @Transactional
    public List<FindRequest> findAllWatch(@RequestParam String departmentName) {
        List<Object[]> watchList = watchRepository.findByDepartmentName(departmentName);

        return watchList.stream()
                .map(objects -> {
                    Watch watch = (Watch) objects[0];
                    String username = (String) objects[1];
                    return FindRequest.toFindRequest(watch, username);
                })
                .collect(Collectors.toList());
    }
    //워치에 유저 매핑
    @Transactional
    public Long saveUserToWatch(@RequestParam Long userId, @RequestParam Long watchId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("해당 유저가 없습니다."));
        Watch watch = watchRepository.findById(watchId).orElseThrow(() -> new IllegalArgumentException("해당 워치가 없습니다."));
        watch.setUser(user);
        watch.setIs_used(true);
        return watch.getId();
    }

    @Transactional
    public StartRequest initializeWatch(@RequestParam String SerialNum) {
        Watch watch = (Watch) watchRepository.findBySerialNum(SerialNum).orElseThrow(() -> new IllegalArgumentException("해당 시리얼넘버에 해당하는 기기가 없습니다."));
        String username = watch.getUser().getName();
        return StartRequest.toStartRequest(watch, username);
    }
}
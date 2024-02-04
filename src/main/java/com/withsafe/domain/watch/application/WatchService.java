package com.withsafe.domain.watch.application;

import com.withsafe.domain.department.dao.DepartmentMapper;
import com.withsafe.domain.department.domain.Department;
import com.withsafe.domain.helmet.dao.HelmetMapper;
import com.withsafe.domain.helmet.domain.Helmet;
import com.withsafe.domain.user.dao.UserMapper;
import com.withsafe.domain.user.domain.User;
import com.withsafe.domain.watch.dao.WatchMapper;
import com.withsafe.domain.watch.domain.Watch;
import com.withsafe.domain.watch.dto.StartRequestDto;
import com.withsafe.domain.watch.dto.WatchDTO.SaveRequest;
import com.withsafe.domain.watch.dto.WatchListDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;


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

    private final WatchMapper watchMapper;
    private final DepartmentMapper departmentMapper;
    private final UserMapper userMapper;
    private final HelmetMapper helmetMapper;

    //워치 등록
    @Transactional
    public Long saveWatch(SaveRequest request, String departmentName) {
        Department department = departmentMapper.findByName(departmentName).orElseThrow(() -> new IllegalArgumentException("해당 부서가 없습니다."));
        Watch savedWatch = request.toEntity(department);
        watchMapper.save(savedWatch);
        return savedWatch.getId();
    }
    //전체 워치 조회
    @Transactional
    public List<WatchListDto> findAllWatch(String departmentName) {
        return watchMapper.findByDepartmentName(departmentName);
    }

    //워치에 유저 매핑
    @Transactional
    public Long saveUserToWatch(Long userId, Long watchId) {
        User user = null;
        Watch watch = watchMapper.findById(watchId).orElseThrow(() -> new IllegalArgumentException("해당 워치가 없습니다."));
        if (userId == null) {
            watch.updateUser(null);
            watchMapper.updateUser(watch);
            return watch.getId();
        }
        user = userMapper.findById(userId).orElseThrow(() -> new IllegalArgumentException("해당 유저가 없습니다."));
        if(!watch.getIs_used()){
            watch.updateUser(user);
            watchMapper.updateUser(watch);
            return watch.getId();
        }
        else throw new IllegalArgumentException("이미 사용중인 워치입니다.");
    }

    public Long saveHelmetToWatch(Long helmetId, Long watchId) {
        Helmet helmet = helmetMapper.findById(helmetId).orElseThrow(() -> new IllegalArgumentException("해당 헬멧이 없습니다."));
        Watch watch = watchMapper.findById(watchId).orElseThrow(() -> new IllegalArgumentException("해당 워치가 없습니다."));
        watch.updateHelmet(helmet);
        watchMapper.updateWatch(watch);
        helmet.updateUsed();
        helmetMapper.update(helmet);
        return watch.getId();
    }
//
//    @Transactional
//    public StartRequestDto initializeWatch(@RequestParam String SerialNum) {
//        return watchRepository.findDtoBySerialNum(SerialNum).orElseThrow(() ->
//                new RuntimeException("해당 워치가 존재하지 않습니다."));
//
//    }
}
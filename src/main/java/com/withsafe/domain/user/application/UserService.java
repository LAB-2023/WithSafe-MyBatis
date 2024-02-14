package com.withsafe.domain.user.application;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.withsafe.domain.bioData.dao.BioDataMapper;
import com.withsafe.domain.bioData.dto.BioDataFindDto;
import com.withsafe.domain.department.dao.DepartmentMapper;
import com.withsafe.domain.department.domain.Department;
import com.withsafe.domain.user.dao.UserMapper;
import com.withsafe.domain.user.exception.PhoneNumberDuplicateException;
import com.withsafe.domain.user.domain.User;
import com.withsafe.domain.user.dto.UserDTO.SaveRequest;
import com.withsafe.domain.watch.dao.WatchMapper;
import com.withsafe.domain.watch.domain.Watch;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import static com.withsafe.domain.user.dto.UserDTO.*;

/**
 * 필요기능
 * 1. 유저 등록
 * 2. 유저 조회
 */
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {
    private final DepartmentMapper departmentMapper;
    private final UserMapper userMapper;
    private final BioDataMapper bioDataMapper;
    private final WatchMapper watchMapper;

    //유저 등록
    @Transactional
    public Long saveUser(SaveRequest saveRequest) {

        //전화번호 중복 예외처리
        if (userMapper.existsByPhoneNum(saveRequest.getPhoneNum()) > 0) {
            throw new PhoneNumberDuplicateException("해당 전화번호로 등록된 사용자가 존재합니다.");
        }
        Department department = departmentMapper.findByName(saveRequest.getDepartmentName()).orElseThrow(() ->
                new RuntimeException("부서가 존재하지 않습니다."));
        User user = saveRequest.toEntity(department);
        userMapper.save(user);
        return user.getId();
    }

    //유저 정보 수정
    @Transactional
    public Long updateUser(SaveRequest request, Long userId) {
        User user = userMapper.findById(userId).orElseThrow(()
                -> new NoSuchElementException("해당 이름의 사용자를 찾지 못했습니다."));
        user.update(request);
        userMapper.updateUser(user);
        return user.getId();
    }

    @Transactional
    public Long deleteUser(Long userId) {
        bioDataMapper.delete(userId);
        Watch watch = watchMapper.findByUserId(userId).orElseThrow(()
                -> new NoSuchElementException("해당 워치를 찾지 못했습니다."));
        watch.updateUser(null);
        watchMapper.updateUser(watch);
        userMapper.deleteUser(userId);
        return userId;
    }

    //이름으로 조회
    public PageInfo<FindRequest> findUser(int page, int size, String username, String departmentName) {
        PageHelper.startPage(page, size);
        List<User> byName = userMapper.findByName(username, departmentName);
        List<FindRequest> result = byName
                .stream()
                .map(User::toUserFindRequestDTO)
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            throw new NoSuchElementException("해당 이름의 사용자를 찾지 못했습니다.");
        }
        return new PageInfo<>(result);
    }

    public PageInfo<FindRequest> findAll(int page, int size, String departmentName){
        PageHelper.startPage(page, size);
        List<FindRequest> result = userMapper.findAll(departmentName)
                .stream()
                .map(user -> FindRequest.builder()
                        .id(user.getId())
                        .name(user.getName())
                        .age(user.getAge())
                        .phoneNum(user.getPhoneNum())
                        .emergency_contact(user.getEmergency_contact())
                        .emergency_relation(user.getEmergency_relation())
                        .heartRate_threshold(user.getHeartRate_threshold())
                        .oxygen_threshold(user.getOxygen_threshold())
                        .walk_threshold(user.getWalk_threshold())
                        .height(user.getHeight())
                        .weight(user.getWeight())
                        .sex(user.getSex())
                        .bloodPressure_high(user.getBloodPressure_high())
                        .bloodPressure_low(user.getBloodPressure_low())
                        .diabetes(user.getDiabetes())
                        .heartDisease(user.getHeartDisease())
                        .build())
                .collect(Collectors.toList());
        return new PageInfo<>(result);
    }
}

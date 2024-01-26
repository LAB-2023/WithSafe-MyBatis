package com.withsafe.domain.user.application;

import com.withsafe.domain.department.dao.DepartmentMapper;
import com.withsafe.domain.department.domain.Department;
import com.withsafe.domain.user.dao.UserMapper;
import com.withsafe.domain.user.exception.PhoneNumberDuplicateException;
import com.withsafe.domain.user.domain.User;
import com.withsafe.domain.user.dto.UserDTO.SaveRequest;
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

    //이름으로 조회
    public List<FindRequest> findUser(String username, String departmentName) {
        List<User> byName = userMapper.findByName(username, departmentName);
        List<FindRequest> result = byName
                .stream()
                .map(User::toUserFindRequestDTO)
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            throw new NoSuchElementException("해당 이름의 사용자를 찾지 못했습니다.");
        }
        return result;
    }

    public List<FindRequest> findAll(String departmentName){
        return userMapper.findAll(departmentName)
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
    }
}

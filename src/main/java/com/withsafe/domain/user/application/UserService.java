package com.withsafe.domain.user.application;

import com.withsafe.domain.department.dao.DepartmentRepository;
import com.withsafe.domain.department.domain.Department;
import com.withsafe.domain.user.dto.UserDTO;
import com.withsafe.domain.user.exception.PhoneNumberDuplicateException;
import com.withsafe.domain.user.dao.UserRepository;
import com.withsafe.domain.user.domain.User;
import com.withsafe.domain.user.dto.UserDTO.SaveRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
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
public class UserService {
    private final UserRepository userRepository;
    private final DepartmentRepository departmentRepository;

    //유저 등록
    @Transactional
    public Long saveUser(SaveRequest saveRequest) {

        //전화번호 중복 예외처리
        if (userRepository.existsByPhoneNum(saveRequest.getPhoneNum())) {
            throw new PhoneNumberDuplicateException("해당 전화번호로 등록된 사용자가 존재합니다.");
        }

        Department department = departmentRepository.findByName(saveRequest.getDepartmentName()).orElseThrow(() -> new RuntimeException("부서가 존재하지 않습니다."));
        User user = saveRequest.toEntity(department);
        userRepository.save(user);
        return user.getId();
    }

    //이름으로 조회
    @Transactional(readOnly = true)
    public List<User> findUser(String username) {
        List<User> foundUserList = userRepository.findByName(username);
        if (foundUserList.isEmpty()) {
            throw new NoSuchElementException("해당 이름의 사용자를 찾지 못했습니다.");
        }
        return foundUserList;
    }

    @Transactional(readOnly = true)
    public List<FindRequest> findAll(){
        List<FindRequest> result = userRepository.findAll()
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

        return result;
    }
}

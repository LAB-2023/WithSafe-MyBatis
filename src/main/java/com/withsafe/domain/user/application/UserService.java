package com.withsafe.domain.user.application;

import com.withsafe.domain.user.exception.PhoneNumberDuplicateException;
import com.withsafe.domain.user.dao.UserRepository;
import com.withsafe.domain.user.domain.User;
import com.withsafe.domain.user.dto.UserDTO.SaveRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * 필요기능
 * 1. 유저 등록
 * 2. 유저 조회
 */
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    //유저 등록
    @Transactional
    public Long saveUser(SaveRequest saveRequest) {

        //전화번호 중복 예외처리
        if (userRepository.existsByPhoneNumber(saveRequest.getPhone_num())) {
            throw new PhoneNumberDuplicateException("해당 전화번호로 등록된 사용자가 존재합니다.");
        }

        User user = saveRequest.toEntity();
        userRepository.save(user);
        return user.getId();
    }

    //이름으로 조회
    @Transactional
    public List<User> findUser(@RequestParam("username") String username) {
        List<User> foundUserList = userRepository.findByName(username);
        if (foundUserList.isEmpty()) {
            throw new NoSuchElementException("해당 이름의 사용자를 찾지 못했습니다.");
        }
        return foundUserList;
    }
}

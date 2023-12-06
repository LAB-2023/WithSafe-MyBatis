package com.withsafe.domain.user.api;

import com.withsafe.domain.user.application.UserService;
import com.withsafe.domain.user.domain.User;
import com.withsafe.domain.user.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:3000")
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /**
     * 유저 등록(생성)
     */
    @PostMapping
    public Long saveUser(@RequestBody UserDTO.SaveRequest request  ) {
        return userService.saveUser(request);
    }

    //유저 조회
    @GetMapping
    public List<User> findUser(@RequestBody UserDTO.FindRequest request) {
        return userService.findUser(request.getName());
    }

    @GetMapping("/all")
    public List<UserDTO.FindRequest> findAllUser(){
        return userService.findAll();
    }
}
package com.withsafe.domain.user.api;

import com.withsafe.domain.user.application.UserService;
import com.withsafe.domain.user.domain.User;
import com.withsafe.domain.user.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.withsafe.domain.user.dto.UserDTO.*;

@CrossOrigin("http://localhost:3000")
@RequestMapping("/user")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /**
     * 유저 등록(생성)
     */
    @PostMapping
    public Long saveUser(@RequestBody SaveRequest request  ) {
        return userService.saveUser(request);
    }

    //유저 조회
    @GetMapping
    public List<FindRequest> findUser(@RequestParam("username") String username) {
        return userService.findUser(username);
    }

    @GetMapping("/all")
    public List<FindRequest> findAllUser(){
        return userService.findAll();
    }
}
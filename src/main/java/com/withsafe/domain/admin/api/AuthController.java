package com.withsafe.domain.admin.api;

import com.withsafe.domain.admin.application.AuthService;
import com.withsafe.domain.admin.dto.TokenDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.withsafe.domain.admin.dto.AdminDto.*;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    //회원가임
    @PostMapping("/signup")
    public ResponseEntity<LoginResponseDto> signup(@RequestBody AdminSaveRequestDto requestDto){
        return ok(authService.signup(requestDto));
    }

    //로그인
    @PostMapping("/login")
    public ResponseEntity<TokenDto> login(@RequestBody LoginRequestDto loginRequestDto){
        return ok(authService.login(loginRequestDto));
    }

}

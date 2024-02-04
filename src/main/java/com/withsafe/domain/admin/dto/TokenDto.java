package com.withsafe.domain.admin.dto;

import com.withsafe.domain.admin.domain.Authority;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TokenDto {
    private String grantType;
    private String accessToken;
    private Long tokenExpiresIn;
//    private String refreshToken;
    private String name;
    private String departmentName;
    private Authority authority;
}

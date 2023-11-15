package com.withsafe.global.util;

import lombok.NoArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@NoArgsConstructor
public class SecurityUtil {

    public static Long getCurrentMemberId(){
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication == null || authentication.getName() == null){
            throw new RuntimeException("Security Context에 인증 정보가 없습니다.");
        }
        return Long.parseLong(authentication.getName());
    }

    public static String getCurrentMemberAuthorization(){
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication == null || authentication.getAuthorities() == null){
            throw new RuntimeException("Security Context에 인증 정보가 없습니다.");
        }
        return authentication.getAuthorities().toString();
    }
}

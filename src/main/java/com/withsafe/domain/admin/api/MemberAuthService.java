package com.withsafe.domain.admin.api;

import com.withsafe.domain.admin.dao.AdminRepository;
import com.withsafe.domain.admin.domain.Admin;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class MemberAuthService implements UserDetailsService {

    private final AdminRepository adminRepository;

    @Override
    public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {
        return adminRepository.findByLoginId(loginId)
                .map(this::createUserDetails)
                .orElseThrow(() -> new UsernameNotFoundException(loginId + "을 찾을 수 없습니다."));
    }

    private UserDetails createUserDetails(Admin admin){
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(admin.getAuthority().toString());
        return new User(
                String.valueOf(admin.getId()),
                admin.getLoginPassword(),
                Collections.singleton(grantedAuthority)
        );
    }
}

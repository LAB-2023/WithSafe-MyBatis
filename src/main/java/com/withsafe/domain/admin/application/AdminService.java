//package com.withsafe.domain.admin.application;
//
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
///**
// * 필요 기능
// * 1. 회원가입 -> 일단 만듬
// * 2. 로그인
// * 3. 로그아웃
// * 4. 비밀번호 찾기(변경) -> 일단 만듬
// */
//
//@Service
//@RequiredArgsConstructor
//@Transactional(readOnly = true)
//public class AdminService {
//
//    private final AdminRepository adminRepository;
//    private final PasswordEncoder passwordEncoder;
//    private final DepartmentRepository departmentRepository;
//
//
//    private boolean loginIdDuplicateCheck(String loginId){
//        return adminRepository.existsByLoginId(loginId);
//    }
//}

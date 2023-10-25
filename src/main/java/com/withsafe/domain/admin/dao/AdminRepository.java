package com.withsafe.domain.admin.dao;

import com.withsafe.domain.admin.domain.Admin;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

    boolean existsByLoginId(String loginId);

    Admin findByLoginId(String loginId);
}

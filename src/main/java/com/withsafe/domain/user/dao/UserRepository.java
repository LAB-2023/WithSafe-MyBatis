package com.withsafe.domain.user.dao;

import com.withsafe.domain.user.domain.User;
import com.withsafe.domain.user.domain.UserJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserJpa,Long> {
    List<UserJpa> findByName(@Param("name") String name);
    boolean existsByPhoneNum(String phoneNum);
}

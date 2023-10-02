package com.withsafe.repository;

import com.withsafe.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select u from User u where u.name = :name")
    List<User> findUser(@Param("name") String name);

    @Query("select u.name from User u")
    List<String> findUsernameList();

}

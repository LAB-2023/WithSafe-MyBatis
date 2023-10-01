package com.withsafe.repository;

import com.withsafe.domain.Department;
import com.withsafe.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(false)
class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

    @Autowired
    DepartmentRepository departmentRepository;

//    @Test
//    public void testUser(){
//        System.out.println("userRepository = " + userRepository);
//        User user = new User("userA");
//        User savedUser = userRepository.save(user);
//        User findUser = userRepository.findById(savedUser.getId()).get();
//
//        assertThat(findUser.getId()).isEqualTo(savedUser.getId());
//        assertThat(findUser.getName()).isEqualTo(savedUser.getName());
//        assertThat(findUser).isEqualTo(user);
//    }
//
//    @Test
//    public void basicCRUD(){
//        User user1 = new User("user1");
//        User user2 = new User("user2");
//        userRepository.save(user1);
//        userRepository.save(user2);
//
//        User findUser1 = userRepository.findById(user1.getId()).get();
//        User findUser2 = userRepository.findById(user2.getId()).get();
//        assertThat(findUser1).isEqualTo(user1);
//        assertThat(findUser2).isEqualTo(user2);
//
//        List<User> all = userRepository.findAll();
//        assertThat(all.size()).isEqualTo(2);
//    }
//
//    @Test
//    public void testQuery(){
//        User u1 = new User("user1");
//        userRepository.save(u1);
//
//        List<User> findUsers = userRepository.findUser("user1");
//        assertThat(findUsers.get(0)).isEqualTo(u1);
//    }
//    @Test
//    public void findUsernameList(){
//        User u1 = new User("user1");
//        User u2 = new User("user2");
//        userRepository.save(u1);
//        userRepository.save(u2);
//
//        List<String> userNameList = userRepository.findUsernameList();
//        for (String s : userNameList) {
//            System.out.println("s = " + s);
//        }
//    }
}
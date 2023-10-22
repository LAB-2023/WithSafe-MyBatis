package com.withsafe.domain.user.application;

import com.withsafe.domain.department.domain.Department;
import com.withsafe.domain.user.dao.UserRepository;
import com.withsafe.domain.user.domain.Sex;
import com.withsafe.domain.user.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
@Rollback(value = false)
public class UserServiceTest {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;

    @Test
    public void 유저생성() {
        Department testDepartment = new Department("A");
        User user  = new User("이윤서",24, "010-0000-00000","010-0000-00000","none",50,60, 100, 176.00, 68.00, Sex.Male,testDepartment);
        userService.saveUser(user.toUserSaveRequestDTO());
    }

    @Test
    public void 유저조회() {
        Department testDepartment1 = new Department("A");
        Department testDepartment2 = new Department("B");
        User user1  = new User("이윤서",24, "010-0000-00000","010-0000-00000","none",50,60, 100, 176.00, 68.00, Sex.Male,testDepartment1);
        userService.saveUser(user1.toUserSaveRequestDTO());

        User user2  = new User("이윤서",24, "010-1111-2222","010-0000-00000","none",50,60, 100, 176.00, 68.00, Sex.Male,testDepartment2);
        userService.saveUser(user2.toUserSaveRequestDTO());

        User user3  = new User("삼윤서",24, "010-3333-3333","010-0000-00000","none",50,60, 100, 176.00, 68.00, Sex.Male,testDepartment2);
        userService.saveUser(user3.toUserSaveRequestDTO());

        List<User> userFoundList = userService.findUser("이윤서");
        for (User user : userFoundList) {
            System.out.println("============전화 번호: "+ user.getPhone_num());
        }
    }
}
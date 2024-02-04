package com.withsafe.domain.user.api;

import com.withsafe.domain.user.application.UserService;
import com.withsafe.domain.user.domain.User;
import com.withsafe.domain.user.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.withsafe.domain.user.dto.UserDTO.*;

@CrossOrigin("http://localhost:3000")
@RequestMapping("/user")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /**
     * 유저 등록(생성)
     */
    @PostMapping
    public Long saveUser(@RequestBody SaveRequest request) {
        return userService.saveUser(request);
    }

    //유저 조회
    @GetMapping
    public List<FindRequest> findUser(@RequestParam("username") String username,
                                      @RequestParam("departmentName") String departmentName) {
        return userService.findUser(username, departmentName);
    }

    @GetMapping("/all")
    public List<FindRequest> findAllUser(@RequestParam("departmentName") String departmentName){
        return userService.findAll(departmentName);
    }

    @PutMapping
    public Long updateUser(@RequestBody SaveRequest request, @RequestParam("userId") Long userId) {
        return userService.updateUser(request, userId);
    }

    @DeleteMapping
    public Long deleteUser(@RequestParam("userId") Long userId) {
        return userService.deleteUser(userId);
    }

    //
//    //긴급 연락 망 리스트 출력
//    //일단 보류
//    @GetMapping("/emergency-contact")
//    public Page<NoticeEmergencyContactDto> emergencyContactList(@RequestParam(required = false) String name,
//                                                                @RequestParam(required = false) String phoneNumber,
//                                                                @RequestParam String departmentName,
//                                                                Pageable pageable){
//        return noticeService.findAllEmergencyContactNotice(name, phoneNumber, departmentName, pageable);
//    }
}
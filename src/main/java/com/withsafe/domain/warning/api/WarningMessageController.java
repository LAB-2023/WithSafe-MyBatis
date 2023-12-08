package com.withsafe.domain.warning.api;

import com.withsafe.domain.warning.application.WarningMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.withsafe.domain.warning.dto.WarningMessageDto.*;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/warning-api")
@RequiredArgsConstructor
public class WarningMessageController {

    private final WarningMessageService warningMessageService;

    //경고 메시지 조회
    @GetMapping
    public List<WarningMessageResponse> messageList(@RequestParam String departmentName){
        return warningMessageService.warningMessageList(departmentName);
    }

    //경고 메시지 저장
    @PutMapping
    public UpdateRequestList update(@RequestBody UpdateRequestList updateRequestList, String departmentName){
        for(UpdateRequest updateRequest: updateRequestList.getProducts()){
            warningMessageService.updateWarningMessage(updateRequest, departmentName);
        }
        return updateRequestList;
    }


    //경고 추가 -> 원래는 ppt에 없는데 postman 테스트 용
    @PostMapping
    public SaveRequest saveMessage(@RequestBody SaveRequest saveRequest, @RequestParam String departmentName){
        warningMessageService.saveMessage(saveRequest, departmentName);
        return saveRequest;
    }
}

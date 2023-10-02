package com.withsafe.domain.warning.api;

import com.withsafe.domain.warning.application.WarningMessageService;
import com.withsafe.domain.warning.dto.WarningMessageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class WarningMessageController {

    private final WarningMessageService warningMessageService;

    //경고 메시지 조회
    @GetMapping
    public List<WarningMessageDto.WarningMessageResponse> messageList(){
        return warningMessageService.messageResponseList();
    }

    //경고 메시지 수정
    @PostMapping("/warning-api/test")
    public WarningMessageDto.UpdateRequestList update(@RequestBody WarningMessageDto.UpdateRequestList updateRequestList){
        for(WarningMessageDto.UpdateRequest updateRequest: updateRequestList.getProducts()){
            warningMessageService.updateWarningMessage(updateRequest);
            System.out.println("updateRequest = " + updateRequest.getContent());
        }
        return updateRequestList;
    }

    //경고 추가 -> 원래는 ppt에 없는데 postman 테스트 용
    @PostMapping("warning-api/insert")
    public WarningMessageDto.SaveRequest saveMessage(@RequestBody WarningMessageDto.SaveRequest saveRequest){
        warningMessageService.saveMessage(saveRequest);
        return saveRequest;
    }
}

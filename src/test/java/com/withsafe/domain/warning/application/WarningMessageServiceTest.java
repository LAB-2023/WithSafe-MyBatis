package com.withsafe.domain.warning.application;

import com.withsafe.domain.warning.dao.WarningMessageRepository;
import com.withsafe.domain.warning.domain.WarningMessage;
import com.withsafe.domain.warning.domain.WarningMessageType;
import com.withsafe.domain.warning.dto.WarningMessageDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
@Rollback(value = false)
class WarningMessageServiceTest {

    @Autowired
    WarningMessageService warningMessageService;
    @Autowired
    WarningMessageRepository warningMessageRepository;

    @Test
    public void 경고메시지저장(){
        WarningMessageDto.SaveRequest saveRequest = new WarningMessageDto.SaveRequest("HEART", WarningMessageType.HEART);
        Long saveId = warningMessageService.saveMessage(saveRequest);

        WarningMessage findMessage = warningMessageRepository.findById(saveId).get();

        assertThat(findMessage.getContent()).isEqualTo(saveRequest.getContent());
    }

    @Test
    public void 경고메시지수정(){
        WarningMessageDto.SaveRequest saveRequest = new WarningMessageDto.SaveRequest("HEART", WarningMessageType.HEART);
        Long saveId = warningMessageService.saveMessage(saveRequest);

        WarningMessageDto.UpdateRequest updateRequest = new WarningMessageDto.UpdateRequest("Change", WarningMessageType.HEART);
        warningMessageService.updateWarningMessage(updateRequest);

        WarningMessage findMessage = warningMessageRepository.findById(saveId).get();

        assertThat(findMessage.getContent()).isEqualTo("Change");
    }

    @Test
    public void 경고메시지조회(){
        WarningMessageDto.SaveRequest saveRequest = new WarningMessageDto.SaveRequest("집가고 싶다", WarningMessageType.HEART);
        Long saveId = warningMessageService.saveMessage(saveRequest);

        WarningMessageDto.SaveRequest saveRequest2 = new WarningMessageDto.SaveRequest("응애", WarningMessageType.HEART);
        Long saveId2 = warningMessageService.saveMessage(saveRequest);

        //List<WarningMessageDto.WarningMessageResponse> warningMessageResponseList = warningMessageService.messageResponseList();

        //assertThat(warningMessageResponseList.size()).isEqualTo(2);
    }
}
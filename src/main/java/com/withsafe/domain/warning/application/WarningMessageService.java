package com.withsafe.domain.warning.application;

import com.withsafe.domain.warning.dao.WarningMessageRepository;
import com.withsafe.domain.warning.domain.WarningMessage;
import com.withsafe.domain.warning.exception.WarningNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static com.withsafe.domain.warning.dto.WarningMessageDto.*;

/*
    minimum ppt p.16
    필요 기능
    1. 경고 알림 메시지 저장
    2. 경고 알림 메시지 수정
    3. 경고 알림 메시지 조회
 */
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class WarningMessageService {

    private final WarningMessageRepository warningMessageRepository;

    //경고 알림 메시지 저장
    @Transactional
    public Long saveMessage(SaveRequest saveRequest){
        WarningMessage warningMessage = saveRequest.toEntity();
        warningMessageRepository.save(warningMessage);
        return warningMessage.getId();
    }
    //경고 알림 메시지 수정
    @Transactional
    public WarningMessage updateWarningMessage(UpdateRequest updateRequest){
        WarningMessage warningMessage = warningMessageRepository.findWarningMessageByType(updateRequest.getType())
                .orElseThrow(() -> new WarningNotFoundException());
        warningMessage.update(updateRequest);
        return warningMessage;
    }

    //경고 알림 메시지 조회
    public List<WarningMessageResponse> warningMessageList(){
        List<WarningMessage> all = warningMessageRepository.findAll();
        return all.stream().map(WarningMessageResponse::toWarningMessageResponse).collect(Collectors.toList());
    }
}

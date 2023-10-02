package com.withsafe.domain.warning.application;

import com.withsafe.domain.notice.exception.NoticeNotFoundException;
import com.withsafe.domain.warning.dao.WarningMessageRepository;
import com.withsafe.domain.warning.domain.WarningMessage;
import com.withsafe.domain.warning.dto.WarningMessageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public Long saveMessage(WarningMessageDto.SaveRequest saveRequest){
        WarningMessage warningMessage = new WarningMessage(saveRequest.getContent(), saveRequest.getType());
        warningMessageRepository.save(warningMessage);
        return warningMessage.getId();
    }

    //경고 알림 메시지 수정
    @Transactional
    public WarningMessage updateWarningMessage(WarningMessageDto.UpdateRequest updateRequest){
        Optional<WarningMessage> findMessage = warningMessageRepository.findById(updateRequest.getId());
        if(findMessage.isPresent()){
            findMessage.get().update(updateRequest);
            return findMessage.get();
        }
        else return null;
    }

    //경고 알림 메시지 조회
    public List<WarningMessageDto.WarningMessageResponse> messageResponseList(){
        List<WarningMessage> all = warningMessageRepository.findAll();
        List<WarningMessageDto.WarningMessageResponse> warningMessageResponseList = new ArrayList<>();
        for (WarningMessage warningMessage : all) {
            warningMessageResponseList.add(warningMessage.toWarningMessageResponseDto());
        }
        return warningMessageResponseList;
    }
}

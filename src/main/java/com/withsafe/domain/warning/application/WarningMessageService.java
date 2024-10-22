package com.withsafe.domain.warning.application;

import com.withsafe.domain.department.dao.DepartmentMapper;
import com.withsafe.domain.department.domain.Department;
import com.withsafe.domain.warning.dao.WarningMessageMapper;
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

    private final WarningMessageMapper warningMessageMapper;
    private final DepartmentMapper departmentMapper;

    //경고 알림 메시지 저장
    @Transactional
    public Long saveMessage(SaveRequest saveRequest, String departmentName){
        Department department = departmentMapper
                .findByName(departmentName).orElseThrow(() -> new RuntimeException("부서가 존재하지 않습니다."));
        WarningMessage warningMessage = saveRequest.toEntity(department);
        warningMessageMapper.save(warningMessage);
        return warningMessage.getId();
    }
    //경고 알림 메시지 수정
    @Transactional
    public WarningMessage updateWarningMessage(UpdateRequest updateRequest, String departmentName){
        WarningMessage warningMessage =
                warningMessageMapper.findWarningMessageByTypeAndDepartmentName(updateRequest.getType(), departmentName)
                .orElseThrow(() -> new WarningNotFoundException("해당 경고 메시지가 존재하지 않습니다."));
        warningMessage.update(updateRequest);
        warningMessageMapper.update(warningMessage);
        return warningMessage;
    }

    //경고 알림 메시지 조회
    public List<WarningMessageResponse> warningMessageList(String departmentName){
        List<WarningMessage> all = warningMessageMapper.findWarningMessageByDepartmentName(departmentName);
        return all.stream().map(WarningMessageResponse::toWarningMessageResponse).collect(Collectors.toList());
    }
}

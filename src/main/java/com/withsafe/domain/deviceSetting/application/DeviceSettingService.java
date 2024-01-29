package com.withsafe.domain.deviceSetting.application;

import com.withsafe.domain.department.dao.DepartmentMapper;
import com.withsafe.domain.department.domain.Department;
import com.withsafe.domain.deviceSetting.dao.DeviceSettingMapper;
import com.withsafe.domain.deviceSetting.domain.DeviceSetting;
import com.withsafe.domain.deviceSetting.dto.DeviceSettingDTO.FindDeviceSettingRequestDTO;
import com.withsafe.domain.deviceSetting.dto.DeviceSettingDTO.SaveDeviceSettingRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 필요기능
 * 1. 디바이스 세팅 저장
 * 2. 기존 디바이스 세팅 조회(기존에 세팅값을 화면에 띄워줘야함)
 *
 * 데이터를 쌓을 것인지 하나의 데이터를 수정만 할 것인지..
 */
@Service
@RequiredArgsConstructor
public class DeviceSettingService {
    private final DeviceSettingMapper deviceSettingMapper;
    private final DepartmentMapper departmentMapper;


    /**
     * 기존 디바이스 세팅 조회
     */
    @Transactional
    public FindDeviceSettingRequestDTO findDeviceSetting(String departmentName) {
        Department department = departmentMapper.findByName(departmentName)
                .orElseThrow(() -> new IllegalArgumentException("해당 부서가 없습니다."));
        DeviceSetting deviceSetting = deviceSettingMapper.findByDepartment(department.getId())
                .orElseThrow(() -> new IllegalArgumentException("해당 세팅이 존재하지 않습니다."));
        return deviceSetting.toFindDeviceSettingDTO();
    }

    /**
     * 디바이스 세팅 저장
     */
    @Transactional
    public Long saveDeviceSetting(SaveDeviceSettingRequestDTO saveRequest, String departmentName) {
        Department department = departmentMapper.findByName(departmentName)
                .orElseThrow(() -> new IllegalArgumentException("해당 부서가 없습니다."));
        DeviceSetting deviceSetting = saveRequest.toEntity(department);
        deviceSettingMapper.save(deviceSetting);
        return deviceSetting.getId();
    }

    //디바이스 세팅 수정 (업데이트)
    @Transactional
    public Long updateDeviceSetting(String departmentName, SaveDeviceSettingRequestDTO updateRequest) {
        Department department = departmentMapper.findByName(departmentName)
                .orElseThrow(() -> new IllegalArgumentException("해당 부서가 없습니다."));
        DeviceSetting deviceSetting = deviceSettingMapper.findByDepartment(department.getId())
                .orElseThrow(() -> new IllegalArgumentException("해당 세팅이 존재하지 않습니다."));
        deviceSetting.update(updateRequest);
        deviceSettingMapper.update(deviceSetting);
        return deviceSetting.getId();
    }

}

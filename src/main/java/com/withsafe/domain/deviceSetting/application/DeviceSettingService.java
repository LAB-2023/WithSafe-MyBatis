package com.withsafe.domain.deviceSetting.application;

import com.withsafe.domain.department.dao.DepartmentRepository;
import com.withsafe.domain.department.domain.Department;
import com.withsafe.domain.deviceSetting.dao.DeviceSettingRepository;
import com.withsafe.domain.deviceSetting.domain.DeviceSetting;
import com.withsafe.domain.deviceSetting.dto.DeviceSettingDTO;
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
    private final DeviceSettingRepository deviceSettingRepository;
    private final DepartmentRepository departmentRepository;


    /**
     * 기존 디바이스 세팅 조회
     */
    @Transactional
    public FindDeviceSettingRequestDTO findDeviceSetting(String departmentName) {
        Department department = departmentRepository.findByName(departmentName).orElseThrow(() -> new IllegalArgumentException("해당 부서가 없습니다."));
        DeviceSetting deviceSetting = deviceSettingRepository.findByDepartment(department);
        return deviceSetting.toFindDeviceSettingDTO();
    }

    /**
     * 디바이스 세팅 저장
     */
    @Transactional
    public Long saveDeviceSetting(SaveDeviceSettingRequestDTO saveRequest) {
        DeviceSetting deviceSetting = saveRequest.toEntity();
        deviceSettingRepository.save(deviceSetting);
        return deviceSetting.getId();
    }

    //디바이스 세팅 수정 (업데이트)
    @Transactional
    public Long updateDeviceSetting(String departmentName, SaveDeviceSettingRequestDTO updateRequest) {
        Department department = departmentRepository.findByName(departmentName).orElseThrow(() -> new IllegalArgumentException("해당 부서가 없습니다."));
        DeviceSetting deviceSetting = deviceSettingRepository.findByDepartment(department);
        deviceSetting.update(updateRequest);
        return deviceSetting.getId();
    }

}

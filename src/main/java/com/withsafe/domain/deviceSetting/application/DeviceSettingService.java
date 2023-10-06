package com.withsafe.domain.deviceSetting.application;

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


    /**
     * 기존 디바이스 세팅 조회
     */
    @Transactional
    public FindDeviceSettingRequestDTO findDeviceSetting() {
        DeviceSetting settingData = deviceSettingRepository.findTopByOrderByIdDesc();
        return settingData.toFindDeviceSettingDTO();
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

}

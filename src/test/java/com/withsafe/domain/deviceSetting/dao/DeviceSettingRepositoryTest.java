package com.withsafe.domain.deviceSetting.dao;

import com.withsafe.domain.deviceSetting.application.DeviceSettingService;
import com.withsafe.domain.deviceSetting.domain.DeviceSetting;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@SpringBootTest
@Transactional
@Rollback(value = false)
class DeviceSettingRepositoryTest {
    @Autowired
    DeviceSettingService deviceSettingService;
    @Autowired
    DeviceSettingRepository deviceSettingRepository;

    @Test
    public void 디바이스세팅저장() {
        DeviceSetting deviceSetting = new DeviceSetting(1L, 10, 20, 2, 2, 2, 2, 2, "ble", "bleVal", "scan", 10, 2, 2,2, 2);
        deviceSettingService.saveDeviceSetting(deviceSetting.toSaveDeviceSettingDTO());

    }

    @Test
    public void 디바이스세팅조회() {
        DeviceSetting deviceSetting = new DeviceSetting(1L, 1234, 20, 2, 2, 2, 2, 2, "ble", "bleVal", "scan", 10, 2, 2,2, 2);
        deviceSettingService.saveDeviceSetting(deviceSetting.toSaveDeviceSettingDTO());
        System.out.println("#################findDeviceSettingId = "+ deviceSettingService.findDeviceSetting().getHeart_rate_min());

    }
}
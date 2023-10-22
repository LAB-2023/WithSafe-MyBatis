package com.withsafe.domain.deviceSetting.dao;

import com.withsafe.domain.deviceSetting.domain.DeviceSetting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceSettingRepository extends JpaRepository<DeviceSetting, Long> {
    DeviceSetting findTopByOrderByIdDesc();
}

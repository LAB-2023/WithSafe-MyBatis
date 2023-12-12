package com.withsafe.domain.deviceSetting.dao;

import com.querydsl.core.alias.DefaultPathFactory;
import com.withsafe.domain.department.domain.Department;
import com.withsafe.domain.deviceSetting.domain.DeviceSetting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceSettingRepository extends JpaRepository<DeviceSetting, Long> {
    DeviceSetting findTopByOrderByIdDesc();

    DeviceSetting findByDepartment(Department department);
}

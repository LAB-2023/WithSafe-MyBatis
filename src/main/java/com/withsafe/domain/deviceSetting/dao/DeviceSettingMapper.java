package com.withsafe.domain.deviceSetting.dao;

import com.withsafe.domain.deviceSetting.domain.DeviceSetting;
import org.apache.ibatis.annotations.*;

import java.util.Optional;

@Mapper
public interface DeviceSettingMapper {

    @Insert("INSERT INTO device_setting (created_date, modified_date, battery_upload, bio_store, ble_filter_type, ble_filter_value, " +
            "ble_scan_type, ble_scan_value, ble_upload, charge_upload, gps_store, gps_upload, heart_rate_max, heart_rate_min, " +
            "safe_upload, sensor_upload, warning_upload, department_id) " +
            "VALUES (#{createdDate}, #{modifiedDate}, #{battery_upload}, #{bio_store}, #{ble_filter_type}, #{ble_filter_value}, " +
            "#{ble_scan_type}, #{ble_scan_value}, #{ble_upload}, #{charge_upload}, #{gps_store}, #{gps_upload}, #{heart_rate_max}, " +
            "#{heart_rate_min}, #{safe_upload}, #{sensor_upload}, #{warning_upload}, #{department.id})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "device_setting_id")
    void save(DeviceSetting deviceSetting);

    @Select("SELECT * FROM device_setting WHERE department_id = #{departmentId}")
    @ResultMap("deviceSettingResultMap")
    Optional<DeviceSetting> findByDepartment(Long departmentId);

    @Update("UPDATE device_setting ds " +
            "SET modified_date = #{modifiedDate}, battery_upload = #{battery_upload}, bio_store = #{bio_store}, " +
            "ble_filter_type = #{ble_filter_type}, ble_filter_value = #{ble_filter_value}, ble_scan_type = #{ble_scan_type}, " +
            "ble_scan_value = #{ble_scan_value}, ble_upload = #{ble_upload}, charge_upload = #{charge_upload}, " +
            "gps_store = #{gps_store}, gps_upload = #{gps_upload}, heart_rate_max = #{heart_rate_max}, " +
            "heart_rate_min = #{heart_rate_min}, safe_upload = #{safe_upload}, sensor_upload = #{sensor_upload}, warning_upload = #{warning_upload} " +
            "WHERE ds.device_setting_id = #{id}")
    void update(DeviceSetting deviceSetting);
}

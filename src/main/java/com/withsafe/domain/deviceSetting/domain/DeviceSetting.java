package com.withsafe.domain.deviceSetting.domain;

import com.withsafe.domain.BaseTimeEntity;
import com.withsafe.domain.deviceSetting.dto.DeviceSettingDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static com.withsafe.domain.deviceSetting.dto.DeviceSettingDTO.*;

@Entity
@Getter
@NoArgsConstructor
public class DeviceSetting extends BaseTimeEntity {    //워치 데이터 세팅(임계치, 데이터 업로드 주기 등)
    @Id @GeneratedValue
    @Column(name = "device_setting_id")
    private Long id;
    private Integer heart_rate_min; //최소 심박수
    private Integer heart_rate_max; //최대 심박수
    private Integer bio_store;  //생체데이터 저장 기간
    private Integer sensor_upload;  //센서 업로드 주기
    private Integer gps_upload; //gps 데이터 업로드 주기
    private Integer gps_store;  //gps 데이터 저장 기간
    private Integer ble_upload; // BLE 업로드 주기
    private String ble_filter_type;  //BLE 필터 구분
    private String ble_filter_value;   //BLE 필터 값
    private String ble_scan_type;   //BLE 스캔 타입
    private Integer ble_scan_value;  //BLE 스캔 값
    private Integer battery_upload; //배터리 잔량 업로드 주기
    private Integer charge_upload;  //충전상태 업로드 주기
    private Integer warning_upload; //경고알림 등록 주기
    private Integer safe_upload;    //구역별 안전수칙 전송 주기

    @Builder
    public DeviceSetting(Long id, Integer heart_rate_min, Integer heart_rate_max, Integer bio_store, Integer sensor_upload, Integer gps_upload, Integer gps_store, Integer ble_upload, String ble_filter_type, String ble_filter_value, String ble_scan_type, Integer ble_scan_value, Integer battery_upload, Integer charge_upload, Integer warning_upload, Integer safe_upload) {
//        this.id = id;
        this.heart_rate_min = heart_rate_min;
        this.heart_rate_max = heart_rate_max;
        this.bio_store = bio_store;
        this.sensor_upload = sensor_upload;
        this.gps_upload = gps_upload;
        this.gps_store = gps_store;
        this.ble_upload = ble_upload;
        this.ble_filter_type = ble_filter_type;
        this.ble_filter_value = ble_filter_value;
        this.ble_scan_type = ble_scan_type;
        this.ble_scan_value = ble_scan_value;
        this.battery_upload = battery_upload;
        this.charge_upload = charge_upload;
        this.warning_upload = warning_upload;
        this.safe_upload = safe_upload;
    }

    public FindDeviceSettingRequestDTO toFindDeviceSettingDTO(){
        return new FindDeviceSettingRequestDTO(this.heart_rate_min,this.heart_rate_max,this.bio_store,this.sensor_upload,this.gps_upload,this.gps_store,this.ble_upload, this.ble_filter_type,this.ble_filter_value,this.ble_scan_type,this.ble_scan_value,this.battery_upload,this.charge_upload,this.warning_upload,this.safe_upload);
    }

    public SaveDeviceSettingRequestDTO toSaveDeviceSettingDTO(){
        return new SaveDeviceSettingRequestDTO(this.heart_rate_min,this.heart_rate_max,this.bio_store,this.sensor_upload,this.gps_upload,this.gps_store,this.ble_upload, this.ble_filter_type,this.ble_filter_value,this.ble_scan_type,this.ble_scan_value,this.battery_upload,this.charge_upload,this.warning_upload,this.safe_upload);
    }
}

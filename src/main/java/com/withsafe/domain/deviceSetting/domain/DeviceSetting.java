package com.withsafe.domain.deviceSetting.domain;

import com.withsafe.domain.department.domain.Department;
import com.withsafe.global.BaseTimeDomain;
import lombok.*;

import javax.persistence.*;

import static com.withsafe.domain.deviceSetting.dto.DeviceSettingDTO.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DeviceSetting extends BaseTimeDomain {    //워치 데이터 세팅(임계치, 데이터 업로드 주기 등)

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
    private Department department;

    public void update(SaveDeviceSettingRequestDTO updateRequest){
        this.heart_rate_max= updateRequest.getHeart_rate_min();
        this.heart_rate_min = updateRequest.getHeart_rate_max();
        this.bio_store = updateRequest.getBio_store();
        this.sensor_upload = updateRequest.getSensor_upload();
        this.gps_store = updateRequest.getGps_store();
        this.gps_upload = updateRequest.getGps_upload();
        this.ble_filter_type = updateRequest.getBle_filter_type();
        this.ble_filter_value = updateRequest.getBle_filter_value();
        this.ble_scan_type = updateRequest.getBle_scan_type();
        this.ble_scan_value = updateRequest.getBle_scan_value();
        this.battery_upload = updateRequest.getBattery_upload();
        this.charge_upload = updateRequest.getCharge_upload();
        this.safe_upload = updateRequest.getSafe_upload();
        this.warning_upload = updateRequest.getWarning_upload();
    }

    public FindDeviceSettingRequestDTO toFindDeviceSettingDTO(){
        return new FindDeviceSettingRequestDTO(this.heart_rate_min,this.heart_rate_max,this.bio_store,this.sensor_upload,this.gps_upload,this.gps_store,this.ble_upload, this.ble_filter_type,this.ble_filter_value,this.ble_scan_type,this.ble_scan_value,this.battery_upload,this.charge_upload,this.warning_upload,this.safe_upload);
    }

    public SaveDeviceSettingRequestDTO toSaveDeviceSettingDTO(){
        return new SaveDeviceSettingRequestDTO(this.heart_rate_min,this.heart_rate_max,this.bio_store,this.sensor_upload,this.gps_upload,this.gps_store,this.ble_upload, this.ble_filter_type,this.ble_filter_value,this.ble_scan_type,this.ble_scan_value,this.battery_upload,this.charge_upload,this.warning_upload,this.safe_upload);
    }
}

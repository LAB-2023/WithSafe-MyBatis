package com.withsafe.domain.deviceSetting.dto;

import com.withsafe.domain.deviceSetting.domain.DeviceSetting;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
public class DeviceSettingDTO {

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SaveDeviceSettingRequestDTO {
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
        public DeviceSetting toEntity() {
            return DeviceSetting.builder()
                    .heart_rate_min(this.heart_rate_min)
                    .heart_rate_max(this.heart_rate_max)
                    .bio_store(this.bio_store)
                    .sensor_upload(this.sensor_upload)
                    .gps_store(this.gps_store)
                    .gps_upload(this.gps_upload)
                    .ble_filter_type(this.ble_filter_type)
                    .ble_filter_value(this.ble_filter_value)
                    .ble_upload(this.ble_upload)
                    .ble_scan_type(this.ble_scan_type)
                    .ble_scan_value(this.ble_scan_value)
                    .battery_upload(this.battery_upload)
                    .charge_upload(this.charge_upload)
                    .warning_upload(this.warning_upload)
                    .safe_upload(this.safe_upload)
                    .build();
        }
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class FindDeviceSettingRequestDTO {
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
        public DeviceSetting toEntity() {
            return DeviceSetting.builder()
                    .heart_rate_min(this.heart_rate_min)
                    .heart_rate_max(this.heart_rate_max)
                    .bio_store(this.bio_store)
                    .sensor_upload(this.sensor_upload)
                    .gps_store(this.gps_store)
                    .gps_upload(this.gps_upload)
                    .ble_filter_type(this.ble_filter_type)
                    .ble_filter_value(this.ble_filter_value)
                    .ble_upload(this.ble_upload)
                    .ble_scan_type(this.ble_scan_type)
                    .ble_scan_value(this.ble_scan_value)
                    .battery_upload(this.battery_upload)
                    .charge_upload(this.charge_upload)
                    .warning_upload(this.warning_upload)
                    .safe_upload(this.safe_upload)
                    .build();
        }
    }
}

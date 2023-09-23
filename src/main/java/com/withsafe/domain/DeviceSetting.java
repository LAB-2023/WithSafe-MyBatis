package com.withsafe.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class DeviceSetting {    //워치 데이터 세팅(임계치, 데이터 업로드 주기 등)
    @Id @GeneratedValue
    @Column(name = "device_setting_id")
    private Long id;
    private int heart_rate_min; //최소 심박수
    private int heart_rate_max; //최대 심박수
    private int bio_store;  //생체데이터 저장 기간
    private int sensor_upload;  //센서 업로드 주기
    private int gps_upload; //gps 데이터 업로드 주기
    private int gps_store;  //gps 데이터 저장 기간
    private int ble_upload; // BLE 업로드 주기
    private String ble_filter_type;  //BLE 필터 구분
    private String ble_filter_value;   //BLE 필터 값
    private String ble_scan_type;   //BLE 스캔 타입
    private String ble_scan_value;  //BLE 스캔 값
    private int battery_upload; //배터리 잔량 업로드 주기
    private int charge_upload;  //충전상태 업로드 주기
    private int warning_upload; //경고알림 등록 주기
    private int safe_upload;    //구역별 안전수칙 전송 주기
}

package com.withsafe.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class DeviceSetting {
    @Id @GeneratedValue
    private Long id;
    private int heart_rate_min;
    private int heart_rate_max;
    private int bio_store;
    private int sensor_upload;
    private int gps_upload;
    private int gps_store;
    private int ble_upload;
    private String ble_filter_type;
    private String ble_filter_value;
    private String ble_scan_type;
    private String ble_scan_value;
    private int battery_upload;
    private int charge_upload;
    private int warning_upload;
    private int safe_upload;
}

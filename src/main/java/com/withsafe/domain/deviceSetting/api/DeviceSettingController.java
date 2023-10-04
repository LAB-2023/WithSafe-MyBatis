package com.withsafe.domain.deviceSetting.api;

import com.withsafe.domain.deviceSetting.application.DeviceSettingService;
import com.withsafe.domain.deviceSetting.domain.DeviceSetting;
import com.withsafe.domain.deviceSetting.dto.DeviceSettingDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * 필요기능
 * 1. 디바이스 세팅 저장
 * 2. 기존 디바이스 세팅 조회(기존에 세팅값을 화면에 띄워줘야함)
 */
@RestController
@RequestMapping("/deviceSetting")
@RequiredArgsConstructor
public class DeviceSettingController {

    private final DeviceSettingService deviceSettingService;

    /**
     * 디바이스 세팅 조회
     * @return
     */
    @GetMapping
    public DeviceSettingDTO findDeviceSetting(){
        return deviceSettingService.viewDeviceSetting();
    }

    /**
     * 디바이스 세팅 저장
     * @param request
     * @return
     */
    @PostMapping("/save")
    public DeviceSettingDTO saveDeviceSetting(@RequestBody DeviceSettingDTO request) {
        deviceSettingService.saveDeviceSetting(request);
        return request;
    }

}

package com.withsafe.domain.deviceSetting.api;

import com.withsafe.domain.deviceSetting.application.DeviceSettingService;
import com.withsafe.domain.deviceSetting.dto.DeviceSettingDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static com.withsafe.domain.deviceSetting.dto.DeviceSettingDTO.*;

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
     *
     * @return
     */
    @GetMapping
    public FindDeviceSettingRequestDTO findDeviceSetting(){
        return deviceSettingService.findDeviceSetting();
    }

    /**
     * 디바이스 세팅 저장
     * @param request
     * @return
     */
    @PostMapping("/save")
    public SaveDeviceSettingRequestDTO saveDeviceSetting(@RequestBody SaveDeviceSettingRequestDTO request) {
        deviceSettingService.saveDeviceSetting(request);
        return request;
    }

}

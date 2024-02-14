package com.withsafe.domain.beacon.api;

import com.github.pagehelper.PageInfo;
import com.withsafe.domain.beacon.application.BeaconService;
import com.withsafe.domain.beacon.dto.BeaconDto;
import com.withsafe.domain.beacon.dto.BeaconResponseDto;
import com.withsafe.domain.beacon.dto.SearchCondition;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.withsafe.domain.beacon.dto.BeaconDto.*;

@CrossOrigin("http://localhost:3000")
@RequestMapping("/beacon")
@RestController
@RequiredArgsConstructor
public class BeaconController {

    private final BeaconService beaconService;

    @PostMapping
    public Long requestSave(@RequestBody RequestSave requestSave){
        return beaconService.saveBeaconInfo(requestSave);
    }

    @GetMapping
    public ResponseEntity<PageInfo> findBeacon(@RequestParam("page") int page,
                                               @RequestParam("size") int size, @RequestParam String departmentName,
                                               @RequestParam(value = "macAddress", required = false) String macAddress,
                                               @RequestParam(value = "indoorMapName", required = false) String indoorMapName) {
        SearchCondition searchCondition = SearchCondition.toSearchCondition(departmentName, macAddress, indoorMapName);
        return ResponseEntity.ok(beaconService.findBeacon(page, size, searchCondition));
    }

    @DeleteMapping
    public Long deleteBeacon(@RequestParam("beaconId") Long beaconId) {
        return beaconService.deleteBeacon(beaconId);
    }
}

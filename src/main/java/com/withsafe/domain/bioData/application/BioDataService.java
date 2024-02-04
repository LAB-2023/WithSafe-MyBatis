package com.withsafe.domain.bioData.application;

import com.withsafe.domain.bioData.dao.BioDataMapper;
import com.withsafe.domain.bioData.domain.BioData;
import com.withsafe.domain.bioData.dto.BioDataFindDto;
import com.withsafe.domain.bioData.dto.BioDataFindResultDto;
import com.withsafe.domain.bioData.dto.BioDataSaveDto;
import com.withsafe.domain.user.dao.UserMapper;
import com.withsafe.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 필요한 기능
 * 1. 1주일간의 심박수, 산소포화도 유지 및 평균/최대/최저 유지
 * 2. 1주일간의 걸음수와 이동거리 유지 및 Total 구하기
 */
@Service
@RequiredArgsConstructor
public class BioDataService {
    private final UserMapper userMapper;
    private final BioDataMapper bioDataMapper;
    @Transactional
    public Long saveBioData(BioDataSaveDto request, Long userId) {
        User user = userMapper.findById(userId).orElseThrow(() -> new RuntimeException("유저를 찾을 수 없습니다."));
        BioData bioData = request.toEntity(user);
        bioDataMapper.save(bioData);
        return bioData.getId();
    }

    @Transactional(readOnly = true)
    public BioDataFindResultDto findRequest(Long userId){
        List<BioDataFindDto> result = bioDataMapper.findUserBioData(userId);
        BioDataFindResultDto ge = result.stream().reduce(new BioDataFindResultDto(),
                (accumulator, bioDataFindDto) -> {
                    accumulator.getHeartRate().add(bioDataFindDto.getHeartRate());
                    accumulator.getCalorie().add(bioDataFindDto.getCalorie());
                    accumulator.getOxygen().add(bioDataFindDto.getOxygen());
                    accumulator.getIsFall().add(bioDataFindDto.getIsFall());
                    accumulator.getTemperature().add(bioDataFindDto.getTemperature());
                    accumulator.getWalkCount().add(bioDataFindDto.getWalkCount());
                    accumulator.getCreatedDate().add(bioDataFindDto.getCreatedDate());
                    return accumulator;
                },
                (accumulator1, accumulator2) -> {
                    // 이 부분은 병렬 스트림을 사용할 때만 필요합니다.
                    // accumulator1과 accumulator2를 병합하는 로직을 구현합니다.
                    // 예: accumulator1.getHeartRate().addAll(accumulator2.getHeartRate());
                    // ...
                    return accumulator1;
                }
        );
        return ge;
    }
//
//    @Transactional
//    public List<FindRequest> findWeekBioData(Long userId,FindRequest request) {
//        List<FindRequest> findRequestList = bioDataRepository.findByUserId(userId);
//        return findRequestList;
//    }

}

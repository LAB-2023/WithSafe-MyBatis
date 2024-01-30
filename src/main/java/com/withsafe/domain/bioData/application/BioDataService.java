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
    public BioDataFindResultDto findRequest(Long userId, String option){
        List<BioDataFindDto> result =  bioDataMapper.findUserBioData(userId, option);
        BioDataFindResultDto ge = new BioDataFindResultDto();
        result.forEach(bioDataSaveDto -> ge.getCalorie().add(bioDataSaveDto.getCalorie()));
        return ge;
    }
//
//    @Transactional
//    public List<FindRequest> findWeekBioData(Long userId,FindRequest request) {
//        List<FindRequest> findRequestList = bioDataRepository.findByUserId(userId);
//        return findRequestList;
//    }

}

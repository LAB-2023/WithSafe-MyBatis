package com.withsafe.domain.bioData.application;

import com.withsafe.domain.bioData.dao.BioDataRepository;
import com.withsafe.domain.bioData.dto.BioDataDto;
import com.withsafe.domain.bioData.dto.BioDataDto.FindRequest;
import com.withsafe.domain.bioData.dto.BioDataDto.SaveRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * 필요한 기능
 * 1. 1주일간의 심박수, 산소포화도 유지 및 평균/최대/최저 유지
 * 2. 1주일간의 걸음수와 이동거리 유지 및 Total 구하기
 */
@Service
@RequiredArgsConstructor
public class BioDataService {
    private final BioDataRepository bioDataRepository;

    @Transactional
    public Long saveBioData(SaveRequest request) {
        return bioDataRepository.save(request.toEntity()).getId();
    }

//    @Transactional
//    public List<FindRequest> findWeekBioData(Long userId,FindRequest request) {
//        List<FindRequest> findRequestList = bioDataRepository.findByUserId(userId);
//        return findRequestList;
//    }
}

package com.withsafe.domain.bioData.dao;

import com.withsafe.domain.bioData.domain.BioData;
import com.withsafe.domain.bioData.dto.BioDataDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BioDataRepository extends JpaRepository<BioData, Long>, FindUserBioDataRepository {
    public List<BioData> findByUserId(Long userId);
}

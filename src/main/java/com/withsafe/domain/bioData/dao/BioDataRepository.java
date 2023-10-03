package com.withsafe.domain.bioData.dao;

import com.withsafe.domain.bioData.domain.BioData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BioDataRepository extends JpaRepository<BioData, Long>{
}

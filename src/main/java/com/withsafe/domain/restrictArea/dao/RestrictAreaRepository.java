package com.withsafe.domain.restrictArea.dao;

import com.withsafe.domain.indoorMap.domain.IndoorMap;
import com.withsafe.domain.restrictArea.domain.RestrictArea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestrictAreaRepository extends JpaRepository<RestrictArea, Long> {



}

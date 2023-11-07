package com.withsafe.domain.indoorMap.dao;

import com.withsafe.domain.indoorMap.dto.IndoorMapDto.UserLocationInfo;

import java.util.List;

import static com.withsafe.domain.indoorMap.dto.IndoorMapDto.*;

public interface IndoorMapLocationRepository {
    List<UserLocationInfo> findAllBySearchCondition(SearchCondition searchCondition);

}


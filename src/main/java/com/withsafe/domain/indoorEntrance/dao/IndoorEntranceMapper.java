package com.withsafe.domain.indoorEntrance.dao;

import com.withsafe.domain.indoorEntrance.domain.IndoorEntrance;
import com.withsafe.domain.indoorEntrance.dto.SearchResultDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

import java.util.List;

import static com.withsafe.domain.indoorEntrance.dto.IndoorEntranceDto.*;

@Mapper
public interface IndoorEntranceMapper {

    @Insert("INSERT INTO indoor_entrance (created_date, modified_date, beacon_id, watch_id) " +
            "VALUES (#{createdDate}, #{modifiedDate}, #{beacon.id}, #{watch.id})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "indoor_entrance_id")
    void save(IndoorEntrance indoorEntrance);


    List<SearchResultDto> findEntranceInfo(SearchCondition searchCondition);
}

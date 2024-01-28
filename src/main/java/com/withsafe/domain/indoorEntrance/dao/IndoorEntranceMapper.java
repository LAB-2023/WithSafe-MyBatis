package com.withsafe.domain.indoorEntrance.dao;

import com.withsafe.domain.indoorEntrance.domain.IndoorEntrance;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

@Mapper
public interface IndoorEntranceMapper {

    @Insert("INSERT INTO indoor_entrance (created_date, modified_date, beacon_id, watch_id) " +
            "VALUES (#{createdDate}, #{modifiedDate}, #{beacon.id}, #{watch.id})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "indoor_entrance_id")
    void save(IndoorEntrance indoorEntrance);
}

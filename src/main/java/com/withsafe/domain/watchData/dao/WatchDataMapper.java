package com.withsafe.domain.watchData.dao;

import com.withsafe.domain.watchData.domain.WatchData;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;

@Mapper
public interface WatchDataMapper {

    @Insert("INSERT INTO watch_data (created_date, modified_date, battery, charge, watch_id) " +
            "VALUES (#{createdDate}, #{modifiedDate}, #{battery}, #{charge}, #{watch.id})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "watch_data_id")
    void save(WatchData watchData);

    @Select("SELECT * FROM watch_data wd WHERE wd.watch_id = #{watchId}")
    @ResultMap("watchDataResultMap")
    Optional<WatchData> findByWatchId(Long watchId);

    @Select("SELECT * FROM watch_data")
    @ResultMap("watchDataResultMap")
    List<WatchData> findAll();

    @Update("UPDATE watch_data wd SET modified_date = #{modifiedDate}, battery = #{battery}, charge = #{charge} " +
            "WHERE wd.watch_data_id = #{id}")
    void update(WatchData watchData);
}

package com.withsafe.domain.restrictArea.dao;

import com.withsafe.domain.restrictArea.domain.RestrictArea;
import com.withsafe.domain.user.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

@Mapper
public interface RestrictAreaMapper {

    @Insert("INSERT INTO restrict_area (coordinate_left, coordinate_right, name, safety_rule, indoor_map_id, outdoor_map_id) " +
            "VALUES (ST_SetSRID(#{coordinate_left}::geometry, 4326), ST_SetSRID(#{coordinate_right}::geometry, 4326), " +
            "#{name}, #{safetyRule}, #{indoorMap.id}, #{outdoorMap.id})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "restrict_area_id")
    void save(RestrictArea restrictArea);
}

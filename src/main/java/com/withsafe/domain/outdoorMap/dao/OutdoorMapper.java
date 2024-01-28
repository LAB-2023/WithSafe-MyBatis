package com.withsafe.domain.outdoorMap.dao;

import com.withsafe.domain.outdoorMap.domain.OutdoorMap;
import com.withsafe.domain.outdoorMap.dto.OutdoorMapFindRequestDto;
import org.apache.ibatis.annotations.*;

import java.util.Optional;

@Mapper
public interface OutdoorMapper {

    @Insert("INSERT INTO outdoor_map (coordinate, name, department_id) " +
            "VALUES (ST_SetSRID(#{coordinate}::geometry, 4326), #{name}, #{department.id})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "outdoor_map_id")
    void save(OutdoorMap outdoorMap);

//    @Select("SELECT om.outdoor_map_id AS id, " +
//            "ST_X(om.coordinate) AS coordinate_x, ST_Y(om.coordinate) AS coordinate_y, " +
//            "om.name AS name, d.department_id AS department_id " +
//            "FROM outdoor_map om " +
//            "JOIN department d ON om.department_id = d.department_id " +
//            "WHERE d.name = #{departmentName} AND om.name = #{mapName}")
//    @ResultMap("outdoorMapFindResultMap")
//    Optional<OutdoorMapFindRequestDto> findByOutdoorMapNameAndDepartmentName(String departmentName, String mapName);

    @Select("SELECT om.outdoor_map_id AS outdoor_map_id, om.name AS name " +
            "FROM outdoor_map om " +
            "JOIN department d ON om.department_id = d.department_id " +
            "WHERE d.name = #{departmentName} AND om.name = #{mapName}")
    @ResultMap("outdoorMapResultMap")
    Optional<OutdoorMap> findByOutdoorMapNameAndDepartmentName(String departmentName, String mapName);
}

package com.withsafe.domain.indoorMap.dao;

import com.withsafe.domain.department.domain.Department;
import com.withsafe.domain.indoorMap.domain.IndoorMap;
import com.withsafe.domain.indoorMap.dto.IndoorMapDto;
import com.withsafe.domain.indoorMap.dto.IndoorMapLocationInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;

import static com.withsafe.domain.indoorMap.dto.IndoorMapDto.*;

@Mapper
public interface IndoorMapMapper {

    @Insert("INSERT INTO indoor_map (image_url, name, department_id) VALUES (#{imageUrl}, #{name}, #{department.id})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "indoor_map_id")
    void save(IndoorMap indoorMap);

    @Select("SELECT * FROM indoor_map AS im JOIN department AS d ON im.department_id = d.department_id " +
            "WHERE d.name = #{departmentName}")
    @ResultMap("indoorMapResultMap")
    List<IndoorMap> findByDepartmentName(String departmentName);

    @Select("SELECT * FROM indoor_map AS im JOIN department AS d ON im.department_id = d.department_id " +
            "WHERE d.name = #{departmentName} AND im.name=#{indoorMapName}")
    @ResultMap("indoorMapResultMap")
    IndoorMap findByDepartmentNameAndIndoorMapName(String departmentName, String indoorMapName);


    List<IndoorMapLocationInfo> findAllBySearchCondition(SearchCondition searchCondition);

    @Select("SELECT * FROM indoor_map WHERE name = #{mapName}")
    @ResultMap("indoorMapResultMap")
    Optional<IndoorMap> findByName(String mapName);
}

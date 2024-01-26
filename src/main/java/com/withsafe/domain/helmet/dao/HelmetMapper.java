package com.withsafe.domain.helmet.dao;

import com.withsafe.domain.helmet.domain.Helmet;
import org.apache.ibatis.annotations.*;

import java.util.Optional;

@Mapper
public interface HelmetMapper {

    @Insert("INSERT INTO helmet (created_date, modified_date, device_num, is_used, model, serial_num, department_id) " +
            "VALUES (#{createdDate}, #{modifiedDate}, #{deviceNum}, #{is_used}, #{model}, #{serialNum}, #{department.id})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "helmet_id")
    void save(Helmet helmet);

    @Select("SELECT * FROM helmet WHERE helmet_id = #{id}")
    @ResultMap("helmetResultMap")
    Optional<Helmet> findById(Long id);

    @Update("UPDATE helmet set is_used = #{is_used}, modified_date = #{modifiedDate} " +
            "WHERE helmet_id = #{id}")
    void update(Helmet helmet);
}

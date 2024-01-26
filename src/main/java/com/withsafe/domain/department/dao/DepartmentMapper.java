package com.withsafe.domain.department.dao;

import com.withsafe.domain.department.domain.Department;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;

@Mapper
public interface DepartmentMapper {

    @Insert("INSERT INTO department (name) VALUES (#{name})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "department_id")
    void save(Department department);

    @Select("SELECT COUNT(*) FROM department WHERE name = #{name}")
    @ResultMap("departmentResultMap")
    int existsByName(String name);

    @Select("SELECT * FROM department WHERE name = #{name}")
    @ResultMap("departmentResultMap")
    Optional<Department> findByName(String name);

    List<Department> findAllExceptDepartments(@Param("excepts") List<String> excepts);
}

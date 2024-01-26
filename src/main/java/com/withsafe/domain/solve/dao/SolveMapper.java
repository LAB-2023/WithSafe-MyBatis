package com.withsafe.domain.solve.dao;

import com.withsafe.domain.solve.domain.Solve;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

@Mapper
public interface SolveMapper {

    @Insert("INSERT INTO solve (content, created_date, modified_date, notice_id) " +
            "VALUES (#{content}, #{createdDate}, #{modifiedDate}, #{notice.id})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "solve_id")
    void save(Solve solve);
}

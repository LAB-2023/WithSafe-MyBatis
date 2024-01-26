package com.withsafe.domain.warning.dao;

import com.withsafe.domain.warning.domain.WarningMessage;
import com.withsafe.domain.warning.domain.WarningMessageType;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;

@Mapper
public interface WarningMessageMapper {

    @Insert("INSERT INTO warning_message (created_date, modified_date, content, type, department_id) " +
            "VALUES (#{createdDate}, #{modifiedDate}, #{content}, #{type}, #{department.id})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "warning_message_id")
    void save(WarningMessage warningMessage);

    @Select("SELECT * FROM warning_message AS wm JOIN department AS d ON wm.department_id = d.department_id " +
            "WHERE wm.type = #{type} AND d.name = #{departmentName}")
    @ResultMap("warningMessageResultMap")
    Optional<WarningMessage> findWarningMessageByTypeAndDepartmentName(WarningMessageType type, String departmentName);

    @Select("SELECT * FROM warning_message AS wm JOIN department AS d ON wm.department_id = d.department_id " +
            "WHERE d.name = #{departmentName}")
    @ResultMap("warningMessageResultMap")
    List<WarningMessage> findWarningMessageByDepartmentName(String departmentName);

    @Update("UPDATE warning_message SET content = #{content}, modified_date = #{modifiedDate} " +
            "WHERE warning_message.warning_message_id = #{id}")
    int update(WarningMessage warningMessage);
}

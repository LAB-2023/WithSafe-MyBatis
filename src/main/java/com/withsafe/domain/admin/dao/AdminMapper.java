package com.withsafe.domain.admin.dao;

import com.withsafe.domain.admin.domain.Admin;
import org.apache.ibatis.annotations.*;

import java.util.Optional;

@Mapper
public interface AdminMapper {

    @Insert("INSERT INTO admin (authority, login_id, login_password, name, department_id) VALUES " +
            "(#{authority}, #{loginId}, #{loginPassword}, #{name}, #{department.id})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "admin_id")
    int save(Admin admin);

    @Select("SELECT COUNT(*) FROM admin WHERE login_id = #{loginId}")
    int existsByLoginId(String loginId);

    //@Select("SELECT * FROM admin WHERE admin_id = #{id}")
    Optional<Admin> findById(Long id);

    //@Select("SELECT * FROM admin WHERE login_id = #{loginId}")
    Optional<Admin> findByLoginId(String loginId);
}
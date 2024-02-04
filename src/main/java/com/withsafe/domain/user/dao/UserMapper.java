package com.withsafe.domain.user.dao;

import com.withsafe.domain.department.domain.Department;
import com.withsafe.domain.user.domain.Sex;
import com.withsafe.domain.user.domain.User;
import com.withsafe.domain.watch.domain.Watch;
import com.withsafe.domain.watch.domain.WatchJpa;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Mapper
public interface UserMapper {

    @Insert("INSERT INTO member (" +
            "age, created_date, modified_date, blood_pressure_high, blood_pressure_low, diabetes, emergency_contact, " +
            "heart_disease, heart_rate_threshold, height, name, oxygen_threshold, " +
            "phone_num, sex, walk_threshold, weight, department_id" +
            ") " +
            "VALUES " +
            "(#{age}, #{createdDate}, #{modifiedDate}, #{bloodPressure_high}, #{bloodPressure_low}, #{diabetes}, #{emergency_contact}, " +
            "#{heartDisease}, #{heartRate_threshold}, #{height}, #{name}, #{oxygen_threshold}, #{phoneNum}, " +
            "#{sex}, #{walk_threshold}, #{weight}, #{department.id})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "user_id")
    void save(User user);

    @Select("SELECT COUNT(*) FROM member JOIN department ON member.department_id = department.department_id " +
            "WHERE phone_num = #{phoneNum}")
    int existsByPhoneNum(String phoneNum);

    @Select("SELECT * FROM member WHERE member.user_id = #{userId}")
    @ResultMap("userResultMap")
    Optional<User> findById(Long userId);

    @Select("SELECT *, m.name AS mm, d.name AS dn FROM member AS m JOIN department AS d ON m.department_id = d.department_id " +
            "WHERE m.name = #{username} AND d.name = #{departmentName}")
    @ResultMap("userResultMap")
    List<User> findByName(@Param("username") String username, @Param("departmentName") String departmentName);

    @Select("SELECT *, m.name AS mm FROM member m JOIN department d ON m.department_id = d.department_id " +
            "WHERE d.name = #{departmentName}")
    @ResultMap("userResultMap")
    List<User> findAll(String departmentName);

    @Select("SELECT COUNT(*) FROM member JOIN department ON member.department_id = department.department_id " +
            "WHERE department.name = #{department}")
    int size(String department);

    @Update("UPDATE member set modified_date = #{modifiedDate}, age = #{age}, blood_pressure_high = #{bloodPressure_high}, " +
            "blood_pressure_low = #{bloodPressure_low}, diabetes = #{diabetes}, emergency_contact = #{emergency_contact}, " +
            "emergency_relation = #{emergency_relation}, heart_rate_threshold = #{heartRate_threshold}, " +
            "height = #{height}, name = #{name}, oxygen_threshold = #{oxygen_threshold}, phone_num = #{phoneNum}, " +
            "sex = #{sex}, walk_threshold = #{walk_threshold}, weight = #{weight} " +
            "WHERE member.user_id = #{id}")
    void updateUser(User user);

    @Delete("DELETE FROM member WHERE user_id = #{userId}")
    void deleteUser(Long userId);
}

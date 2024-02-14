package com.withsafe.domain.watch.dao;

import com.withsafe.domain.watch.domain.Watch;
import com.withsafe.domain.watch.dto.SearchCondition;
import com.withsafe.domain.watch.dto.WatchFindDto;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;

@Mapper
public interface WatchMapper {

    @Insert("INSERT INTO watch " +
            "(created_date, modified_date, device_num, is_used, model, serial_num, department_id, helmet_id, user_id) " +
            "VALUES (#{createdDate}, #{modifiedDate}, #{deviceNum}, #{is_used}, " +
            "#{model}, #{serialNum}, #{department.id}, #{helmet.id}, #{user.id})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "watch_id")
    void save(Watch watch);

//    @Select("SELECT w.watch_id AS watchId, w.*, m.name AS userName " +
//            "FROM watch AS w " +
//            "JOIN department AS d ON w.department_id = d.department_id " +
//            "LEFT JOIN member AS m ON w.user_id = m.user_id " +
//            "WHERE d.name = #{departmentName}")
//    @ResultMap("watchListDtoMap")
//    List<WatchFindDto> findByDepartmentName(String departmentName);

    List<WatchFindDto> findAllBySearchCondition(SearchCondition searchCondition);

    @Select("SELECT * FROM watch WHERE watch.watch_id = #{id}")
    @ResultMap("watchResultMap")
    Optional<Watch> findById(Long id);

    @Select("SELECT * FROM watch WHERE watch.serial_num = #{watchSerialNum}")
    @ResultMap("watchResultMap")
    Optional<Watch> findBySerialNum(String watchSerialNum);

    @Select("SELECT * FROM watch WHERE watch.user_id = #{userId}")
    @ResultMap("watchResultMap")
    Optional<Watch> findByUserId(Long userId);


    @Update("UPDATE watch set is_used = #{is_used}, user_id = #{user.id}, modified_date = #{modifiedDate} " +
            "WHERE watch.watch_id = #{id}")
    void updateUser(Watch watch);

    @Update("UPDATE watch set helmet_id = #{helmet.id}, modified_date = #{modifiedDate} " +
            "WHERE watch.watch_id = #{id}")
    void updateWatch(Watch watch);
}

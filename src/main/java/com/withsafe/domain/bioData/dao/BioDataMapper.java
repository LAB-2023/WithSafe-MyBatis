package com.withsafe.domain.bioData.dao;

import com.withsafe.domain.bioData.domain.BioData;
import com.withsafe.domain.bioData.dto.BioDataFindDto;
import com.withsafe.domain.bioData.dto.BioDataSaveDto;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

import java.util.List;

@Mapper
public interface BioDataMapper {

    @Insert("INSERT INTO bio_data (" +
            "calorie, created_date, modified_date, heart_rate, is_fall, oxygen, temperature, walk_count, user_id" +
            ") " +
            "VALUES " +
            "(#{calorie}, #{createdDate}, #{modifiedDate}, #{heartRate}, #{isFall}, #{oxygen}, " +
            "#{temperature}, #{walkCount}, #{user.id})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "bio_data_id")
    int save(BioData bioData);

    List<BioDataFindDto> findUserBioData(Long userId);

    @Delete("DELETE FROM bio_data WHERE user_id = #{userId}")
    void delete(Long userId);
}

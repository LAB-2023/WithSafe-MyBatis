package com.withsafe.domain.beacon.dao;

import com.withsafe.domain.beacon.domain.Beacon;
import com.withsafe.domain.beacon.dto.BeaconResponseDto;
import com.withsafe.domain.restrictArea.domain.RestrictArea;
import org.apache.ibatis.annotations.*;

import java.util.Optional;

@Mapper
public interface BeaconMapper {

    @Insert("INSERT INTO beacon (created_date, modified_date, beacon_type, coordinate, mac_address, status, indoor_map_id) " +
            "VALUES (#{createdDate}, #{modifiedDate}, #{beaconType}, (ST_SetSRID(#{coordinate}::geometry, 4326)), " +
            "#{macAddress}, #{status}, #{indoorMap.id})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "beacon_id")
    void save(Beacon beacon);

//    @Select("SELECT *, ST_X(b.coordinate) AS coordinate_x, ST_X(b.coordinate) AS coordinate_y" +
//            " FROM beacon b WHERE mac_address = #{macAddress}")
//    @ResultMap("beaconDtoResultMap")
//    Optional<BeaconResponseDto> findByMacAddress(String macAddress);

    @Select("SELECT b.beacon_id AS beacon_id " +
            "FROM beacon b WHERE mac_address = #{macAddress}")
    @ResultMap("beaconResultMap")
    Optional<Beacon> findByMacAddress(String macAddress);
}

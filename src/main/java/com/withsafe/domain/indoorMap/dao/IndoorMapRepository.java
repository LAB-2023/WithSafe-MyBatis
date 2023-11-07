package com.withsafe.domain.indoorMap.dao;

import com.withsafe.domain.indoorMap.domain.IndoorMap;
import com.withsafe.domain.indoorMap.dto.IndoorMapDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.withsafe.domain.indoorMap.dto.IndoorMapDto.*;

@Repository
public interface IndoorMapRepository extends JpaRepository<IndoorMap,Long> {


    IndoorMap findByDepartmentNameAndName(String departmentName, String Name);

//    @Query("select i from IndoorUserLocation i where i.mapId = :mapId")
//    List<IndoorUserLocation> findLocationByMapId(String mapId);

}

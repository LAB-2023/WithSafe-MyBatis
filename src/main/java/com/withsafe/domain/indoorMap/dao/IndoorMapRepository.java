package com.withsafe.domain.indoorMap.dao;

import com.withsafe.domain.indoorMap.domain.IndoorMapJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IndoorMapRepository extends JpaRepository<IndoorMapJpa,Long> {


    List<IndoorMapJpa> findByDepartmentJpaName(String departmentName);

    Optional<IndoorMapJpa> findByName(String mapName);

//    @Query("select i from IndoorUserLocation i where i.mapId = :mapId")
//    List<IndoorUserLocation> findLocationByMapId(String mapId);

}

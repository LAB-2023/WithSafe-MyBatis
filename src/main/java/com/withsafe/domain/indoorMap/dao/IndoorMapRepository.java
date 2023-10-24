package com.withsafe.domain.indoorMap.dao;

import com.withsafe.domain.indoorMap.domain.IndoorMap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IndoorMapRepository extends JpaRepository<IndoorMap,Long> {

    IndoorMap findByName(String mapName);

//    @Query("select i from IndoorUserLocation i where i.mapId = :mapId")
//    List<IndoorUserLocation> findLocationByMapId(String mapId);

}

package com.withsafe.domain.indoorEntrance.dao;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.withsafe.domain.indoorEntrance.domain.IndoorEntrance;
import com.withsafe.domain.indoorEntrance.dto.IndoorEntranceDto;
import com.withsafe.domain.indoorEntrance.dto.SearchResultDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

import static com.withsafe.domain.indoorEntrance.dto.IndoorEntranceDto.*;
@Repository
public interface IndoorEntranceRepository{

    Page<SearchResultDto> findAllBySearchCondition(SearchCondition searchCondition, Pageable pageable);
}

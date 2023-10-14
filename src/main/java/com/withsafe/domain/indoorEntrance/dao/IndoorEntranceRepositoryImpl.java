package com.withsafe.domain.indoorEntrance.dao;

import com.querydsl.core.QueryResults;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.withsafe.domain.indoorEntrance.domain.IndoorEntrance;
import com.withsafe.domain.indoorEntrance.dto.IndoorEntranceDto;
import com.withsafe.domain.indoorEntrance.dto.SearchResultDto;
import com.withsafe.domain.watch.domain.Watch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.withsafe.domain.beacon.domain.QBeacon.beacon;
import static com.withsafe.domain.indoorEntrance.domain.QIndoorEntrance.indoorEntrance;
import static com.withsafe.domain.indoorEntrance.dto.IndoorEntranceDto.*;
import static com.withsafe.domain.indoorMap.domain.QIndoorMap.indoorMap;
import static com.withsafe.domain.user.domain.QUser.user;
import static com.withsafe.domain.watch.domain.QWatch.watch;

@Repository
public class IndoorEntranceRepositoryImpl extends QuerydslRepositorySupport implements IndoorEntranceRepository {

    private JPAQueryFactory jpaQueryFactory;

    public IndoorEntranceRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        super(IndoorEntrance.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }

    //검색 조건으로 찾기
    @Override
    public Page<SearchResultDto> findAllBySearchCondition (SearchCondition searchCondition, Pageable pageable){
        List<SearchResultDto> result = jpaQueryFactory
                .select(
                        Projections.fields(SearchResultDto.class,
                        indoorEntrance.watch.deviceNum.as("deviceNum"),
                        indoorEntrance.watch.user.name.as("userName"),
                        indoorEntrance.beacon.indoorMap.name.as("mapName"),
                        indoorEntrance.createdDate.as("enterTime"),
                        indoorEntrance.modifiedDate.as("exitTime")
                ))
                .from(indoorEntrance)
                .leftJoin(indoorEntrance.watch, watch)
                .leftJoin(watch.user, user)
                .leftJoin(indoorEntrance.beacon.indoorMap,indoorMap)
                //.where(indoorEntrance.watch.user.name.eq(searchCondition.getUserName()))
                //.leftJoin(indoorEntrance.beacon,beacon)
                //.leftJoin(beacon.indoorMap, indoorMap)
                .where(eqUserName(searchCondition.getUserName()),
                        btwEnterDate(searchCondition.getStartDate(), searchCondition.getEndDate()),
                        btwExitDate(searchCondition.getStartDate(), searchCondition.getEndDate()))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
        long total = result.size();

        return new PageImpl<>(result, pageable, total);
        //return new PageImpl<>(result, pageable, total);

    }

    //이름 비교
    private BooleanExpression eqUserName(String userName){
        if(userName == null || userName.equals("null")){
            return null;
        }
        return indoorEntrance.watch.user.name.eq(userName);
    }

    //출입 시간 비교
    private BooleanExpression btwEnterDate(LocalDateTime startDate, LocalDateTime endDate) {
        if (startDate == null || endDate == null) {
            return null;
        } else {
            return indoorEntrance.createdDate.between(startDate, endDate);
        }
    }

    //퇴장 시간 비교
    private BooleanExpression btwExitDate(LocalDateTime startDate, LocalDateTime endDate) {
        if (startDate == null || endDate == null) {
            return null;
        } else {
            return indoorEntrance.modifiedDate.between(startDate, endDate);
        }
    }

}

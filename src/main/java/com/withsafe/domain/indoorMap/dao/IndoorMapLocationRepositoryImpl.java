package com.withsafe.domain.indoorMap.dao;

import com.querydsl.core.Tuple;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.withsafe.domain.indoorMap.domain.IndoorMap;
import com.withsafe.domain.indoorMap.dto.IndoorMapDto;
import com.withsafe.domain.indoorMap.dto.IndoorMapDto.IndoorMapLocationInfo;
import com.withsafe.domain.indoorMap.dto.IndoorMapDto.SearchCondition;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

import static com.withsafe.domain.beacon.domain.QBeacon.beacon;
import static com.withsafe.domain.department.domain.QDepartment.department;
import static com.withsafe.domain.indoorEntrance.domain.QIndoorEntrance.indoorEntrance;
import static com.withsafe.domain.indoorMap.domain.QIndoorMap.indoorMap;
import static com.withsafe.domain.restrictArea.domain.QRestrictArea.restrictArea;
import static com.withsafe.domain.user.domain.QUser.user;
import static com.withsafe.domain.watch.domain.QWatch.watch;

@Repository
public class IndoorMapLocationRepositoryImpl extends QuerydslRepositorySupport implements IndoorMapLocationRepository {

    private final JPAQueryFactory jpaQueryFactory;

    public IndoorMapLocationRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        super(IndoorMap.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public List<IndoorMapLocationInfo> findAllBySearchCondition(SearchCondition searchCondition) {

        List<Tuple> indoorMapLocationList = jpaQueryFactory.select(
                        department.name, indoorMap.id,
                        restrictArea.id, restrictArea.coordinate_left, restrictArea.coordinate_right,
                        beacon.id, beacon.coordinate, indoorEntrance.id,watch.id,
                        user.id,user.name, user.phoneNum)
                .from(indoorMap)
                .innerJoin(indoorMap.department, department)
                .leftJoin(indoorMap.restrictAreaList, restrictArea)
                .leftJoin(indoorMap.beaconList, beacon)
                .leftJoin(beacon.indoorEntranceList,indoorEntrance)
                .leftJoin(indoorEntrance.watch, watch)
                .leftJoin(watch.user,user)
//                .where(eqUserName(searchCondition.getUserName())
//                        .or(eqDeviceNum(searchCondition.getDeviceNum())))
                .where(eqDepartmentName(searchCondition.getDepartmentName())
                        ,eqUserName(searchCondition.getUserName())
                        ,eqDeviceNum(searchCondition.getDeviceNum()))
                .fetch();

        List<IndoorMapLocationInfo> indoorMapLocationInfoList = indoorMapLocationList.stream()
                .map(tuple -> IndoorMapLocationInfo.builder()
                        .departmentName(tuple.get(department.name))
                        .indoorMapId(tuple.get(indoorMap.id))
                        .restrictAreaId(tuple.get(restrictArea.id))
                        //.restrictAreaCoordinateLeft(tuple.get(restrictArea.coordinate_left))
                        //.restrictAreaCoordinateRight(tuple.get(restrictArea.coordinate_right))
                        .beaconId(tuple.get(beacon.id))
                        .beaconCoordinate(tuple.get(beacon.coordinate))
                        .indoorEntranceId(tuple.get(indoorEntrance.id))
                        .watchId(tuple.get(watch.id))
                        .userId(tuple.get(user.id))
                        .userName(tuple.get(user.name))
                        .phoneNum(tuple.get(user.phoneNum))
                        .build())
                .collect(Collectors.toList());

//        for (Tuple tuple : mapDetail) {
//            System.out.println("tuple = " + tuple.get(restrictArea.id));
//            System.out.println("tuple = " + tuple.get(beacon.id) +", "+ tuple.get(indoorEntrance.id)
//            +", "+ tuple.get(watch.id)+", "+tuple.get(user.id));
//            System.out.println("======");
//        }

        return indoorMapLocationInfoList;
    }

    //부서 이름 비교
    private BooleanExpression eqDepartmentName(String departmentName){
        if(departmentName == null || departmentName.equals("")){
            return null;
        }
        else
            return department.name.eq(departmentName);
    }

    //사용자 이름 비교
    private BooleanExpression eqUserName(String userName){
        if(userName == null || userName.equals("")){
            return null;
        }
        else
            return user.name.eq(userName);
    }

    //디바이스 번호 비교
    private BooleanExpression eqDeviceNum(Integer deviceNum){
        if(deviceNum == null || deviceNum.equals(0)){
            return null;
        }
        else
            return watch.deviceNum.eq(deviceNum);
    }

}

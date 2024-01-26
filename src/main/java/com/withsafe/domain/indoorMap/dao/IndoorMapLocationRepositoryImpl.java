//package com.withsafe.domain.indoorMap.dao;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.querydsl.core.Tuple;
//import com.querydsl.core.types.Projections;
//import com.querydsl.core.types.dsl.BooleanExpression;
//import com.querydsl.jpa.impl.JPAQueryFactory;
//import com.withsafe.domain.department.domain.QDepartmentJpa;
//import com.withsafe.domain.indoorMap.domain.IndoorMap;
//import com.withsafe.domain.indoorMap.dto.IndoorMapDto;
//import com.withsafe.domain.indoorMap.dto.IndoorMapDto.IndoorMapLocationInfo;
//import com.withsafe.domain.indoorMap.dto.IndoorMapDto.SearchCondition;
//import org.n52.jackson.datatype.jts.JtsModule;
//import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//import static com.withsafe.domain.beacon.domain.QBeacon.beacon;
//import static com.withsafe.domain.department.domain.QDepartmentJpa.departmentJpa;
//import static com.withsafe.domain.indoorEntrance.domain.QIndoorEntrance.indoorEntrance;
//import static com.withsafe.domain.indoorMap.domain.QIndoorMap.indoorMap;
//import static com.withsafe.domain.restrictArea.domain.QRestrictArea.restrictArea;
//import static com.withsafe.domain.user.domain.QUser.user;
//import static com.withsafe.domain.watch.domain.QWatch.watch;
//
//@Repository
//public class IndoorMapLocationRepositoryImpl extends QuerydslRepositorySupport implements IndoorMapLocationRepository {
//
//    private final JPAQueryFactory jpaQueryFactory;
//
//    public IndoorMapLocationRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
//        super(IndoorMap.class);
//        this.jpaQueryFactory = jpaQueryFactory;
//    }
//
//    @Override
//    public List<IndoorMapLocationInfo> findAllBySearchCondition(SearchCondition searchCondition) {
//
//        var objectMapper = new ObjectMapper();
//        objectMapper.registerModule(new JtsModule());
//
//        List<Tuple> indoorMapLocationList = jpaQueryFactory.select(
//                        departmentJpa.name, indoorMap.id,
//                        restrictArea.id, restrictArea.coordinate_left, restrictArea.coordinate_right,
//                        beacon.id, beacon.coordinate, indoorEntrance.id,watch.id,
//                        user.id,user.name, user.phoneNum)
//                .from(indoorMap)
//                .innerJoin(indoorMap.departmentJpa, departmentJpa)
//                .leftJoin(indoorMap.restrictAreaList, restrictArea)
//                .leftJoin(indoorMap.beaconList, beacon)
//                .leftJoin(beacon.indoorEntranceList,indoorEntrance)
//                .leftJoin(indoorEntrance.watch, watch)
//                .leftJoin(watch.user,user)
////                .where(eqUserName(searchCondition.getUserName())
////                        .or(eqDeviceNum(searchCondition.getDeviceNum())))
//                .where(eqDepartmentName(searchCondition.getDepartmentName())
//                        ,eqUserName(searchCondition.getUserName())
//                        ,eqDeviceNum(searchCondition.getDeviceNum())
//                        ,eqMapId(searchCondition.getIndoorMapId())
//                )
//                .fetch();
//
//
//        List<IndoorMapLocationInfo> indoorMapLocationInfoList = indoorMapLocationList.stream()
//                .map(tuple -> {
//                    try {
//                        return IndoorMapLocationInfo.toIndoorMapLocationInfo(
//                                tuple.get(departmentJpa.name),
//                                tuple.get(indoorMap.id),
//                                tuple.get(restrictArea.id),
//                                objectMapper.writeValueAsString(tuple.get(restrictArea.coordinate_left)),
//                                objectMapper.writeValueAsString(tuple.get(restrictArea.coordinate_right)),
//                                tuple.get(beacon.id),
//                                objectMapper.writeValueAsString(tuple.get(beacon.coordinate)),
//                                tuple.get(indoorEntrance.id),
//                                tuple.get(watch.id),
//                                tuple.get(user.id),
//                                tuple.get(user.name),
//                                tuple.get(user.phoneNum)
//                        );
//                    } catch (JsonProcessingException e) {
//                        throw new RuntimeException(e);
//                    }
//                })
//                .collect(Collectors.toList());
//
//
//        return indoorMapLocationInfoList;
//    }
//
//    //부서 이름 비교
//    private BooleanExpression eqDepartmentName(String departmentName){
//        if(departmentName == null || departmentName.equals("")){
//            return null;
//        }
//        else
//            return departmentJpa.name.eq(departmentName);
//    }
//
//    //사용자 이름 비교
//    private BooleanExpression eqUserName(String userName){
//        if(userName == null || userName.equals("")){
//            return null;
//        }
//        else
//            return user.name.eq(userName);
//    }
//
//    //디바이스 번호 비교
//    private BooleanExpression eqDeviceNum(Integer deviceNum){
//        if(deviceNum == null || deviceNum.equals(0)){
//            return null;
//        }
//        else
//            return watch.deviceNum.eq(deviceNum);
//    }
//
//    //맵 아이디 비교
//    private BooleanExpression eqMapId(Long indoorMapId){
//        System.out.println(indoorMapId);
//        if(indoorMapId == null)
//            return null;
//        else return indoorMap.id.eq(indoorMapId);
//    }
//}

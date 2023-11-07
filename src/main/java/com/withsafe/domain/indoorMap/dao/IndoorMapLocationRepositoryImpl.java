//package com.withsafe.domain.indoorMap.dao;
//
//import com.querydsl.core.types.dsl.BooleanExpression;
//import com.querydsl.jpa.impl.JPAQueryFactory;
//import com.withsafe.domain.indoorMap.dto.IndoorMapDto.SearchCondition;
//import com.withsafe.domain.indoorMap.dto.IndoorMapDto.UserLocationInfo;
//
//import java.util.List;
//
//import static com.withsafe.domain.beacon.domain.QBeacon.beacon;
//import static com.withsafe.domain.indoorEntrance.domain.QIndoorEntrance.indoorEntrance;
//import static com.withsafe.domain.indoorMap.domain.QIndoorMap.indoorMap;
//import static com.withsafe.domain.user.domain.QUser.user;
//import static com.withsafe.domain.watch.domain.QWatch.watch;
//
//public class IndoorMapLocationRepositoryImpl implements IndoorMapLocationRepository {
//
//    private JPAQueryFactory jpaQueryFactory;
//
//    @Override
//    public List<UserLocationInfo> findAllBySearchCondition(SearchCondition searchCondition) {
//        List<UserLocationInfo> userLocationInfoList = jpaQueryFactory
//                .select()
//                .from(indoorMap)
//                .leftJoin(indoorMap.beaconList,beacon)
//                .leftJoin(beacon.indoorEntranceList, indoorEntrance)
//                .leftJoin(indoorEntrance.watch, watch)
//                .leftJoin(watch.user, user)
//                .where(eqUserName(searchCondition.getUserName()),
//                        eqDeviceNum(searchCondition.getDeviceNum()))
//                .stream()
//                .collect();
//
//        return null;
//    }
//
//    //이름 비교
//    private BooleanExpression eqUserName(String userName){
//        if(userName == null || userName.equals("null")){
//            return null;
//        }
//        return user.name.eq(userName);
//    }
//
//    //디바이스 번호 비교
//    private BooleanExpression eqDeviceNum(Integer deviceNum){
//        if(deviceNum == null){
//            return null;
//        }
//        return watch.deviceNum.eq(deviceNum);
//    }
//}

//package com.withsafe.domain.bioData.dao;
//
//
//import com.querydsl.core.types.Projections;
//import com.querydsl.core.types.dsl.BooleanExpression;
//import com.querydsl.jpa.impl.JPAQueryFactory;
//import com.withsafe.domain.bioData.domain.BioDataJpa;
//import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
//
//import java.util.List;
//
//import static com.withsafe.domain.bioData.dto.BioDataDto.*;
//
//public class FindUserBioDataRepositoryImpl extends QuerydslRepositorySupport implements FindUserBioDataRepository {
//
//    private final JPAQueryFactory jpaQueryFactory;
//
//    public FindUserBioDataRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
//        super(BioDataJpa.class);
//        this.jpaQueryFactory = jpaQueryFactory;
//    }
//
//    @Override
//    public List<FindRequest> findUserBioData(Long userId) {
//        List<FindRequest> result = jpaQueryFactory
//                .select(
//                        Projections.fields(
//                                FindRequest.class,
//                                bioData.calorie.as("calorie"),
//                                bioData.heartRate.as("heartRate"),
//                                bioData.oxygen.as("oxygen"),
//                                bioData.temperature.as("temperature"),
//                                bioData.walkCount.as("walkCount"),
//                                bioData.isFall.as("isFall"),
//                                bioData.createdDate.as("createdDate")
//                        )
//                )
//                .from(bioData)
//                .where(eqUserId(userId))
//                .orderBy(bioData.createdDate.desc())
//                .limit(10)
//                .fetch();
//        return result;
//    }
//
//    private BooleanExpression eqUserId(Long userId){
//        if(userId == null)
//            return null;
//        return bioData.user.id.eq(userId);
//    }
//}

package com.withsafe.domain.bioData.dao;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.withsafe.domain.bioData.domain.BioData;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BioDataRepositoryImpl extends QuerydslRepositorySupport implements BioDataRepository{
    private final JPAQueryFactory  jpaQueryFactory;

    public BioDataRepositoryImpl(JPAQueryFactory jpaQueryFactory){
        super(BioData.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public List<BioData> findAllById(Iterable<Long> longs) {
        return null;
    }


}

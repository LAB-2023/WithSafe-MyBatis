package com.withsafe.domain.notice.dao;


import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.withsafe.domain.notice.domain.Notice;
import com.withsafe.domain.notice.domain.NoticeType;
import com.withsafe.domain.notice.dto.NoticeMainResponseDto;
import com.withsafe.domain.notice.dto.NoticeWarningContactDto;
import com.withsafe.domain.notice.dto.NoticeWarningResponseDto;
import com.withsafe.domain.user.domain.QUser;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

import static com.withsafe.domain.notice.domain.QNotice.*;
import static com.withsafe.domain.solve.domain.QSolve.*;
import static com.withsafe.domain.user.domain.QUser.*;
import static com.withsafe.domain.warning.domain.QWarningMessage.*;

@Repository
public class SearchNoticeRepositoryImpl extends QuerydslRepositorySupport implements SearchNoticeRepository {

    private final JPAQueryFactory jpaQueryFactory;

    public SearchNoticeRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        super(Notice.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public List<NoticeMainResponseDto> findNoticeMainResponseDto(NoticeType noticeType) {
        return jpaQueryFactory.select(
                        Projections.fields(
                                NoticeMainResponseDto.class,
                                notice.id.as("id"),
                                notice.watch.user.name.as("name"),
                                notice.noticeType.as("noticeType"),
                                notice.solve.content.as("solveContent"),
                                notice.solve.createdDate.as("solveDate"),
                                notice.createdDate.as("createdDate")
                        )
                )
                .from(notice)
                .leftJoin(notice.solve, solve)
                .join(notice.watch.user, user)
                .where(eqNoticeType(noticeType))
                .fetch();
    }

    @Override
    public List<NoticeWarningResponseDto> findNoticeWarningResponseDto(String name,
                                                                       LocalDateTime startDate,
                                                                       LocalDateTime endDate,
                                                                       int option) {
        return jpaQueryFactory.select(
                        Projections.fields(
                                NoticeWarningResponseDto.class,
                                notice.id.as("id"),
                                notice.watch.user.name.as("name"),
                                notice.warning_message.type.as("warningMessageType"),
                                notice.solve.content.as("solveContent"),
                                notice.solve.createdDate.as("solveDate"),
                                notice.createdDate.as("createdDate")
                        )
                )
                .from(notice)
                .leftJoin(notice.solve, solve)
                .join(notice.warning_message, warningMessage)
                .join(notice.watch.user, user)
                .where(eqUsername(name), btwDate(startDate, endDate), checkSolve(option))
                .fetch();
    }

    @Override
    public List<NoticeWarningContactDto> findNoticeWarningContactResponseDto(String name, String phoneNumber){
        return jpaQueryFactory.select(
                    Projections.fields(
                            NoticeWarningContactDto.class,
                            user.department.as("department"),
                            user.name.as("name"),
                            user.phone_num.as("phoneNumber")
                    )
                )
                .from(user)
                .where(eqWarningUserName(name), eqWarningPhoneNumber(phoneNumber))
                .fetch();
    }

    //알림 타입 검색
    private BooleanExpression eqNoticeType(NoticeType noticeType) {
        if (noticeType == null)
            return null;
        return notice.noticeType.eq(noticeType);
    }

    //유저 이름 검색
    private BooleanExpression eqUsername(String username) {
        if (username == null || username.equals("null"))
            return null;
        else
            return notice.watch.user.name.eq(username);
    }

    //날짜 검색
    private BooleanExpression btwDate(LocalDateTime startDate, LocalDateTime endDate) {
        if (startDate == null && endDate == null) {
            return null;
        } else if (startDate == null) {
            return notice.createdDate.loe(endDate);
        } else if (endDate == null) {
            return notice.createdDate.goe(startDate);
        } else {
            return notice.createdDate.between(startDate, endDate);
        }
    }

    //조치 미조치 전체 분별 => 0이면 전체 1이면 조치 -1이면 미조치
    private BooleanExpression checkSolve(int option) {
        if(option == 0) {
            return null;
        }
        else if (option == 1) {
            return notice.solve.content.isNotNull();
        } else {
            return notice.solve.content.isNull();
        }
    }

    //긴급 연락망 이름 검색
    private BooleanExpression eqWarningUserName(String name){
        if(name == null || name.equals("null")){
            return null;
        }
        else{
            return user.name.eq(name);
        }
    }

    //긴급 연락망 전화번호 검색
    private BooleanExpression eqWarningPhoneNumber(String phoneNumber){
        if(phoneNumber == null)
            return null;
        else
            return user.phone_num.eq(phoneNumber);
    }
}

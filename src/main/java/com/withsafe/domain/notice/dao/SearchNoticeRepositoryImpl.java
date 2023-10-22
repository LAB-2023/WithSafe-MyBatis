package com.withsafe.domain.notice.dao;


import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.withsafe.domain.notice.domain.Notice;
import com.withsafe.domain.notice.domain.NoticeType;
import com.withsafe.domain.notice.dto.NoticeMainResponseDto;
import com.withsafe.domain.notice.dto.NoticeEmergencyContactDto;
import com.withsafe.domain.notice.dto.NoticeWarningResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;


import static com.withsafe.domain.department.domain.QDepartment.department;
import static com.withsafe.domain.notice.domain.QNotice.notice;
import static com.withsafe.domain.solve.domain.QSolve.solve;
import static com.withsafe.domain.user.domain.QUser.user;
import static com.withsafe.domain.warning.domain.QWarningMessage.warningMessage;
import static com.withsafe.domain.watch.domain.QWatch.watch;

@Repository
public class SearchNoticeRepositoryImpl extends QuerydslRepositorySupport implements SearchNoticeRepository {

    private final JPAQueryFactory jpaQueryFactory;

    public SearchNoticeRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        super(Notice.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public Page<NoticeMainResponseDto> noticeMainResponseDtoPage(NoticeType noticeType, Pageable pageable){
        List<NoticeMainResponseDto> content = jpaQueryFactory
                .select(
                        Projections.fields(
                        NoticeMainResponseDto.class,
                        notice.id.as("id"),
                        //notice.watch.department.name.as("department"),
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
                .join(notice.watch.department, department)
                .where(eqNoticeType(noticeType))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
        long count = (long) content.size();

        return new PageImpl<>(content, pageable, count);
    }

    @Override
    public Page<NoticeWarningResponseDto> noticeWarningResponseDtoPage(String name,
                                                                       LocalDateTime startDate,
                                                                       LocalDateTime endDate,
                                                                       int option,
                                                                       Pageable pageable) {
        List<NoticeWarningResponseDto> content = jpaQueryFactory
                .select(
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
        long count = (long) content.size();

        return new PageImpl<>(content, pageable, count);
    }

    //긴급 연락망 리스트
    @Override
    public Page<NoticeEmergencyContactDto> noticeEmergencyContactResponseDtoPage(String name, String phoneNumber, Pageable pageable){
        List<NoticeEmergencyContactDto> content = jpaQueryFactory
                .select(
                        Projections.fields(
                                NoticeEmergencyContactDto.class,
                                //watch.department.as("department"),
                                watch.user.name.as("name"),
                                watch.user.phoneNum.as("phoneNumber")
                        )
                )
                .from(watch)
                .join(watch.user, user)
                .join(watch.department, department)
                .where(eqWarningUserName(name), eqWarningPhoneNumber(phoneNumber))
                .fetch();
        long count = (long) content.size();

        return new PageImpl<>(content, pageable, count);
    }



    //알림 타입 검색
    private BooleanExpression eqNoticeType(NoticeType noticeType) {
        if (noticeType == null)
            return null;
        return notice.noticeType.eq(noticeType);
    }

    //유저 이름 검색
    private BooleanExpression eqUsername(String username) {
        if (username == null || username.equals(""))
            return null;
        else
            return notice.watch.user.name.eq(username);
    }

    //날짜 검색
    private BooleanExpression btwDate(LocalDateTime startDate, LocalDateTime endDate) {
        if (startDate == null || endDate == null) {
            return null;
        }
       else {
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
            return user.phoneNum.eq(phoneNumber);
    }
}

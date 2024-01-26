//package com.withsafe.domain.notice.dao;
//
//import com.querydsl.core.types.Projections;
//import com.querydsl.core.types.dsl.BooleanExpression;
//import com.querydsl.jpa.impl.JPAQueryFactory;
//import com.withsafe.domain.notice.domain.NoticeJpa;
//import com.withsafe.domain.notice.domain.NoticeType;
//import com.withsafe.domain.notice.dto.NoticeEmergencyContactDto;
//import com.withsafe.domain.notice.dto.NoticeMainResponseDto;
//import com.withsafe.domain.notice.dto.NoticeWarningResponseDto;
//import com.withsafe.domain.warning.domain.QWarningMessageJpa;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageImpl;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
//import org.springframework.stereotype.Repository;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//import static com.withsafe.domain.department.domain.QDepartmentJpa.departmentJpa;
//import static com.withsafe.domain.notice.domain.QNotice.notice;
//import static com.withsafe.domain.solve.domain.QSolve.solve;
//import static com.withsafe.domain.user.domain.QUserJpa.*;
//import static com.withsafe.domain.watch.domain.QWatchJpa.*;
//
//@Repository
//public class SearchNoticeRepositoryImpl extends QuerydslRepositorySupport implements SearchNoticeRepository {
//
//    private final JPAQueryFactory jpaQueryFactory;
//
//    public SearchNoticeRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
//        super(NoticeJpa.class);
//        this.jpaQueryFactory = jpaQueryFactory;
//    }
//
//    @Override
//    public Page<NoticeMainResponseDto> noticeMainResponseDtoPage(NoticeType noticeType,
//                                                                 Pageable pageable,
//                                                                 String departmentName){
//        List<NoticeMainResponseDto> content = jpaQueryFactory
//                .selectDistinct(
//                        Projections.fields(
//                        NoticeMainResponseDto.class,
//                        notice.id.as("id"),
//                        notice.watch.departmentJpa.name.as("departmentName"),
//                        notice.watch.user.name.as("name"),
//                        notice.noticeType.as("noticeType"),
//                        notice.solve.content.as("solveContent"),
//                        notice.solve.createdDate.as("solveDate"),
//                        notice.createdDate.as("createdDate")
//                    )
//                )
//                .from(notice)
//                .leftJoin(notice.solve, solve)
//                .join(notice.watch.user, userJpa)
//                .join(notice.watch.departmentJpa, departmentJpa)
//                .where(eqNoticeType(noticeType), eqDepartmentName(departmentName))
//                .offset(pageable.getOffset())
//                .limit(pageable.getPageSize())
//                .fetch();
//        long count = (long) content.size();
//
//        return new PageImpl<>(content, pageable, count);
//    }
//
//    @Override
//    public Page<NoticeWarningResponseDto> noticeWarningResponseDtoPage(String name,
//                                                                       LocalDateTime startDate,
//                                                                       LocalDateTime endDate,
//                                                                       int option,
//                                                                       Pageable pageable,
//                                                                       String departmentName) {
//        List<NoticeWarningResponseDto> content = jpaQueryFactory
//                .selectDistinct(
//                        Projections.fields(
//                                NoticeWarningResponseDto.class,
//                                notice.id.as("id"),
//                                notice.watch.user.name.as("name"),
//                                notice.warning_message.type.as("warningMessageType"),
//                                notice.solve.content.as("solveContent"),
//                                notice.solve.createdDate.as("solveDate"),
//                                notice.createdDate.as("createdDate")
//                        )
//                )
//                .from(notice)
//                .leftJoin(notice.solve, solve)
//                .join(notice.warning_message, QWarningMessageJpa.warningMessageJpa)
//                .join(notice.watch.user, userJpa)
//                .where(eqUsername(name), btwDate(startDate, endDate), checkSolve(option), eqDepartmentName(departmentName))
//                .fetch();
//        long count = (long) content.size();
//
//        return new PageImpl<>(content, pageable, count);
//    }
//
//    //긴급 연락망 리스트
//    @Override
//    public Page<NoticeEmergencyContactDto> noticeEmergencyContactResponseDtoPage(String name, String phoneNumber,
//                                                                                 String departmentName, Pageable pageable){
//        List<NoticeEmergencyContactDto> content = jpaQueryFactory
//                .select(
//                        Projections.fields(
//                                NoticeEmergencyContactDto.class,
//                                watchJpa.departmentJpa.name.as("departmentName"),
//                                watchJpa.user.name.as("name"),
//                                watchJpa.user.emergency_contact.as("phoneNumber")
//                        )
//                )
//                .from(watchJpa)
//                .join(watchJpa.user, userJpa)
//                .join(watchJpa.departmentJpa, departmentJpa)
//                .where(eqWarningUserName(name), eqWarningPhoneNumber(phoneNumber), eqDepartmentNameWatch(departmentName))
//                .fetch();
//        long count = (long) content.size();
//
//        return new PageImpl<>(content, pageable, count);
//    }
//
//
//
//    //알림 타입 검색
//    private BooleanExpression eqNoticeType(NoticeType noticeType) {
//        if (noticeType == null)
//            return null;
//        return notice.noticeType.eq(noticeType);
//    }
//
//    //유저 이름 검색
//    private BooleanExpression eqUsername(String username) {
//        if (username == null || username.isEmpty())
//            return null;
//        else
//            return notice.watch.user.name.eq(username);
//    }
//
//    //날짜 검색
//    private BooleanExpression btwDate(LocalDateTime startDate, LocalDateTime endDate) {
//        if (startDate == null || endDate == null) {
//            return null;
//        }
//       else {
//            return notice.createdDate.between(startDate, endDate);
//        }
//    }
//
//    //조치 미조치 전체 분별 => option이 0이면 전체 1이면 조치 -1이면 미조치
//    private BooleanExpression checkSolve(int option) {
//        if(option == 0) {
//            return null;
//        }
//        else if (option == 1) {
//            return notice.solve.content.isNotNull();
//        } else {
//            return notice.solve.content.isNull();
//        }
//    }
//
//    //긴급 연락망 이름 검색
//    private BooleanExpression eqWarningUserName(String name){
//        if(name == null || name.equals("null")){
//            return null;
//        }
//        else{
//            return userJpa.name.eq(name);
//        }
//    }
//
//    //긴급 연락망 전화번호 검색
//    private BooleanExpression eqWarningPhoneNumber(String phoneNumber){
//        if(phoneNumber == null)
//            return null;
//        else
//            return watchJpa.user.emergency_contact.eq(phoneNumber);
//    }
//
//    //로그인한 유저 department 데이터만 출력
//    private BooleanExpression eqDepartmentName(String departmentName){
//        if(departmentName == null)
//            return null;
//        else return notice.watch.departmentJpa.name.eq(departmentName);
//    }
//
//    //watch 기준 찾기 로그인한 유저 department 데이터만 출력
//    private BooleanExpression eqDepartmentNameWatch(String departmentName){
//        if(departmentName == null)
//            return null;
//        else return departmentJpa.name.eq(departmentName);
//    }
//}

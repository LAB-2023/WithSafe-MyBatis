//package com.withsafe.domain.watch.application;
//
//import com.withsafe.domain.user.domain.User;
//import com.withsafe.domain.watch.dao.WatchRepository;
//import com.withsafe.domain.watch.domain.Watch;
//import com.withsafe.domain.watch.dto.WatchDTO.SaveRequest;
//import com.withsafe.repository.UserRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import com.withsafe.domain.watch.exception.WatchNotFoundException;
//import org.w3c.dom.stylesheets.LinkStyle;
//
//import java.util.List;
//
//import static com.withsafe.domain.watch.dto.WatchDTO.*;
//
///**
// * 필요한 기능 CRUD
// * 1. 워치 등록
// * 2. 워치 삭제
// * 3. 워치 검색
// * 4. 워치(디바이스)와 유저 매핑
// */
//
//@Service
//@RequiredArgsConstructor
//public class WatchService {
//    private final WatchRepository watchRepository;
//    private final UserRepository userRepository;
//
//    //워치 등록
//    @Transactional
//    public Long saveWatchDTO(SaveRequest request) {
//        User user = userRepository.findById(request.getUserId()).orElseThrow(RuntimeException::new);
//        Watch savedWatch = watchRepository.save(request.toEntity(user));
//        return savedWatch.getId();
//    }
//    //워치 검색
//    @Transactional
//    public Watch findWatch(FindRequest request){
//        Watch watch = watchRepository.findById(request.getWatchId()).orElseThrow(() -> new WatchNotFoundException());
//        User user = watch.getUser();
////        User user = userRepository.findById(1L).orElseThrow();
//        return request.toEntity(watch);
//    }
//
//    //워치 삭제
//    @Transactional
//    public Long deleteWatchDTO(DeleteRequest request){
//        Watch watch = watchRepository.findById(request.getWatchId()).orElseThrow(() -> new WatchNotFoundException());
//        watchRepository.delete(watch);
//        return watch.getId();
//    }
//
//}

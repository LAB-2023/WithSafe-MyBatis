package com.withsafe.repository;

import com.withsafe.domain.watch.dao.WatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
@Rollback(false)
class WatchRepositoryTest {
    @Autowired
    WatchRepository watchRepository;
//
//    @Test
//    public void saveWatch(){
//        System.out.println("watchRepository = " + watchRepository);
//        User user = new User(0L);
//        Watch watch = new Watch(user,1);
//        Watch savedWatch = watchRepository.save(watch);
//        Watch findWatch = watchRepository.findByUser(user);
//        assertThat(findWatch.getUser()).isEqualTo(savedWatch.getUser());
//        assertThat(findWatch).isEqualTo(watch);
//
//    }
//    @Test
//    public void findByUserIdAndDeviceNum(){
//        System.out.println("watchRepository = " + watchRepository);
//        User user1 = new User(0L);
//        Watch w1 = new Watch(user1,1);
//
//        watchRepository.save(w1);
//
//        Watch findWatchByUserIdAndDeviceNum = watchRepository.findByUserIdAndDeviceNum(0L,1).get(0);
//
//        assertThat(findWatchByUserIdAndDeviceNum).isEqualTo(w1);
//
//    }
}

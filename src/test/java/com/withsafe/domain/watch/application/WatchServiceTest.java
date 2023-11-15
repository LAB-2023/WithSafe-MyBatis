package com.withsafe.domain.watch.application;

import com.withsafe.domain.watch.dao.WatchRepository;
import com.withsafe.domain.watch.domain.Watch;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Transactional
public class WatchServiceTest {
    @Autowired
    WatchService watchService;
    @Autowired
    WatchRepository watchRepository;
    @Test
    public void 워치생성() {

    }
}
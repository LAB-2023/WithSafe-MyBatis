//package com.withsafe.domain.watch.api;
//
//import com.withsafe.domain.watch.application.WatchService;
//import com.withsafe.domain.watch.dto.WatchDTO;
//import com.withsafe.domain.watch.dto.WatchDTO.SaveRequest;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MockMvcBuilder;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import java.time.LocalDateTime;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//
//@AutoConfigureMockMvc
//@SpringBootTest
//public class WatchControllerTest {
//
//    @Mock
//    private WatchService watchService;
//
//    @InjectMocks
//    private WatchController watchController;
//    private MockMvc mockMvc;
//
//    @BeforeEach
//    public void setUp(){
//        MockitoAnnotations.initMocks(this);
//    }
//    @Test
//    @DisplayName("워치 저장 성공")
//    public void save_watch() throws Exception {
//        //given
//        SaveRequest saveRequest = SaveRequest.builder()
//                .serialNum("SerialNum0")
//                .model("갤럭시워치")
//                .is_used(true)
//                .deviceNum(1)
//                .regDate(LocalDateTime.now())
//                .build();
//        //when
//
//        //then
//    }
//}
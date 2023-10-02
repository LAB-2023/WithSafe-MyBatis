package com.withsafe.domain.indoorEntrance.dto;

import com.withsafe.domain.beacon.domain.Beacon;
import com.withsafe.domain.watch.domain.Watch;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class IndoorEntranceDto {

    private static class IndoorEntrance{
        private Long id;
        private LocalDateTime createdDate;

        private LocalDateTime modifiedDate;

        private Beacon beacon;  //실내 구역 출입을 인지한 비콘의 id

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "watch_id")
        private Watch watch;

    }


    //사용자에게 받은 검색 조건 저장
    @Getter
    public static class SearchCondition{
        private String userName;
        private LocalDateTime startDate;
        private LocalDateTime endDate;

        public SearchCondition(String userName){
            this.userName = userName;
        }

        public SearchCondition(LocalDateTime startDate, LocalDateTime endDate){
            this.startDate = startDate;
            this.endDate = endDate;
        }

        public SearchCondition(String userName, LocalDateTime startDate, LocalDateTime endDate){
            this.userName = userName;
            this.startDate = startDate;
            this.endDate = endDate;
        }
    }
}

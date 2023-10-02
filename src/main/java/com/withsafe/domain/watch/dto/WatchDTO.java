package com.withsafe.domain.watch.dto;

import com.withsafe.domain.user.domain.User;
import com.withsafe.domain.watch.domain.Watch;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class WatchDTO {

    @Getter
    @NoArgsConstructor
    public static class SaveRequest{
        private User user;
        private Watch watch;

        @Builder
        public SaveRequest(User user, Watch watch) {
            this.user = user;
            this.watch = watch;
        }
    }



}

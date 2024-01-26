package com.withsafe.global;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class BaseTimeDomain {
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    // MyBatis에서 insert를 호출하기 전에 실행됩니다.
    public void preInsert() {
        if (this.createdDate == null) {
            this.createdDate = LocalDateTime.now();
        }
    }

    // MyBatis에서 update를 호출하기 전에 실행됩니다.
    public void preUpdate() {
        this.modifiedDate = LocalDateTime.now();
    }
}

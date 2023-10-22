package com.withsafe.domain.notice.exception;

public class WatchNotFoundException extends IllegalArgumentException{
    public WatchNotFoundException() {}

    public WatchNotFoundException(String s) {
        super(s);
    }
}

package com.withsafe.domain.watch.exception;

public class WatchNotFoundException extends IllegalArgumentException {

    public WatchNotFoundException() {
    }
    public WatchNotFoundException(String message) {
        super(message);
    }
}
package com.withsafe.domain.user.exception;

public class PhoneNumberDuplicateException extends RuntimeException{
    public PhoneNumberDuplicateException() {
        super();
    }

    public PhoneNumberDuplicateException(String message) {
        super(message);
    }

    public PhoneNumberDuplicateException(String message, Throwable cause) {
        super(message, cause);
    }
}

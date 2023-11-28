package com.withsafe.domain.admin.exception;

public class DuplicateEmailException extends IllegalArgumentException {

    public DuplicateEmailException(String message) {
        super(message);
    }

    public DuplicateEmailException() {
    }
}

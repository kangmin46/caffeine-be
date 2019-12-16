package com.woowacourse.caffeine.application.exception;

public class InvalidPasswordException extends RuntimeException {
    private static final String INVALID_PASSWORD_MESSAGE = "올바르지 않은 패스워드 입니다.";

    public InvalidPasswordException() {
        super(INVALID_PASSWORD_MESSAGE);
    }
}

package com.woowacourse.caffeine.domain.exception;

public class InvalidEmailException extends RuntimeException {
    private static final String INVALID_EMAIL_MESSAGE = "올바르지 않은 이메일입니다.";

    public InvalidEmailException() {
        super(INVALID_EMAIL_MESSAGE);
    }
}

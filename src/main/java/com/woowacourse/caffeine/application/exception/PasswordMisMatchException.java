package com.woowacourse.caffeine.application.exception;

public class PasswordMisMatchException extends RuntimeException {
    private static final String PASSWORD_MISMATCH_MESSAGE = "패스워드가 올바르지 않습니다.";

    public PasswordMisMatchException() {
        super(PASSWORD_MISMATCH_MESSAGE);
    }
}

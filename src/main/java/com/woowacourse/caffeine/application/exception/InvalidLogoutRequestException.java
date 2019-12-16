package com.woowacourse.caffeine.application.exception;

public class InvalidLogoutRequestException extends RuntimeException {
    private static final String INVALID_LOGOUT_REQUEST_MESSAGE = "로그인 한 유저가 아닙니다.";

    public InvalidLogoutRequestException() {
        super(INVALID_LOGOUT_REQUEST_MESSAGE);
    }
}

package com.woowacourse.caffeine.domain.exception;

public class InvalidIdException extends RuntimeException {

    private static final String INVALID_ID_MESSAGE = "올바른 아이디가 아닙니다.";

    public InvalidIdException() {
        super(INVALID_ID_MESSAGE);
    }
}

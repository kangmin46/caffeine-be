package com.woowacourse.caffeine.domain.exception;

public class InvalidOwnerIdException extends RuntimeException {
    private static final String INVALID_OWNER_ID_MESSAGE = "올바르지 않은 아이디 입니다.";

    public InvalidOwnerIdException() {
        super(INVALID_OWNER_ID_MESSAGE);
    }
}

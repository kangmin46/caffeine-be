package com.woowacourse.caffeine.application.exception;

public class InvalidNickNameException extends RuntimeException {
    private static final String INVALID_NICK_NAME_MESSAGE = "올바른 닉네임 형식을 입력해 주세요.";

    public InvalidNickNameException() {
        super(INVALID_NICK_NAME_MESSAGE);
    }
}

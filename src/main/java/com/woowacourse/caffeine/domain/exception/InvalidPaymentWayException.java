package com.woowacourse.caffeine.domain.exception;

public class InvalidPaymentWayException extends RuntimeException {
    private static final String INVALID_PAYMENT_WAY_MESSAGE = "올바르지 않은 결제 방식입니다.";

    public InvalidPaymentWayException() {
        super(INVALID_PAYMENT_WAY_MESSAGE);
    }
}

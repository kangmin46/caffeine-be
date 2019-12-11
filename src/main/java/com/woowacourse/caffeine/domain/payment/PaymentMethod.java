package com.woowacourse.caffeine.domain.payment;

import com.woowacourse.caffeine.domain.exception.InvalidPaymentWayException;

import java.util.Arrays;

public enum PaymentMethod {

    CREDIT_CARD("신용카드"),
    MEET("만나서 결제");

    private final String method;

    PaymentMethod(final String method) {
        this.method = method;
    }

    public static PaymentMethod match(final String paymentWay) {
        return Arrays.stream(PaymentMethod.values()).filter(paymentMethod -> paymentMethod.isMatches(paymentWay))
            .findAny()
            .orElseThrow(InvalidPaymentWayException::new);
    }

    public boolean isMatches(final String paymentWay) {
        return this.method.equals(paymentWay);
    }

    public String getMethod() {
        return method;
    }
}

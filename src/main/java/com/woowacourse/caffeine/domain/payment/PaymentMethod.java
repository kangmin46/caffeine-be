package com.woowacourse.caffeine.domain.payment;

import com.woowacourse.caffeine.domain.exception.InvalidPaymentWayException;

public enum PaymentMethod {

    CREDIT_CARD("신용카드"),
    MEET_CASH("만나서 현금결제"),
    MEET_CREDIT_CARD("만나서 카드결제");

    private final String method;

    PaymentMethod(final String method) {
        this.method = method;
    }

    public static PaymentMethod match(final String paymentWay) {
        for (PaymentMethod value : PaymentMethod.values()) {
            if (value.method.equals(paymentWay)) {
                return value;
            }
        }
        throw new InvalidPaymentWayException();
    }

    public String getMethod() {
        return method;
    }
}

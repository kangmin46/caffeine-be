package com.woowacourse.caffeine.domain.payment;

import com.woowacourse.caffeine.domain.exception.InvalidPaymentWayException;

public enum PaymentWay {
    CREDIT_CARD("신용카드"),
    MEET_CASH("만나서 현금결제"),
    MEET_CREDIT_CARD("만나서 카드결제");

    private final String way;

    PaymentWay(final String way) {
        this.way = way;
    }

    public static PaymentWay match(final String paymentWay) {
        for (PaymentWay value : PaymentWay.values()) {
            if (value.way.equals(paymentWay)) {
                return value;
            }
        }
        throw new InvalidPaymentWayException();
    }

    public String getWay() {
        return way;
    }
}

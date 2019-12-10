package com.woowacourse.caffeine.application.dto;

public class PaymentResponse {

    private final Long id;
    private final Long customerId;
    private final String way;

    public PaymentResponse(final Long id, final Long customerId, final String way) {
        this.id = id;
        this.customerId = customerId;
        this.way = way;
    }

    public Long getId() {
        return id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public String getWay() {
        return way;
    }
}

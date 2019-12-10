package com.woowacourse.caffeine.application.dto;

public class PaymentRequest {
    private long id;
    private long customerId;
    private String way;

    public PaymentRequest(long id, long customerId, String way) {
        this.id = id;
        this.customerId = customerId;
        this.way = way;
    }

    public PaymentRequest() {
    }

    public long getId() {
        return id;
    }

    public long getCustomerId() {
        return customerId;
    }

    public String getWay() {
        return way;
    }
}

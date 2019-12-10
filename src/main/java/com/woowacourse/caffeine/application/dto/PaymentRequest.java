package com.woowacourse.caffeine.application.dto;

public class PaymentRequest {

    private long id;
    private long customerId;
    private String method;

    public PaymentRequest(final long id, final long customerId, final String method) {
        this.id = id;
        this.customerId = customerId;
        this.method = method;
    }

    public PaymentRequest() {
    }

    public long getId() {
        return id;
    }

    public long getCustomerId() {
        return customerId;
    }

    public String getMethod() {
        return method;
    }
}

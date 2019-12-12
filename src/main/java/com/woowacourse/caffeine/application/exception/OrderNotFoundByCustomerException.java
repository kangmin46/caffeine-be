package com.woowacourse.caffeine.application.exception;

public class OrderNotFoundByCustomerException extends RuntimeException {
    private static final String ORDER_NOT_FOUND_BY_CUSTOMER_MESSAGE = "해당 사용자에 대한 주문이 없습니다.";

    public OrderNotFoundByCustomerException() {
        super(ORDER_NOT_FOUND_BY_CUSTOMER_MESSAGE);
    }
}

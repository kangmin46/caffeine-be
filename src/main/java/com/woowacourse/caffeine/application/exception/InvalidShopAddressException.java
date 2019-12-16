package com.woowacourse.caffeine.application.exception;

public class InvalidShopAddressException extends RuntimeException {
    private static final String INVALID_SHOP_ADDRESS_MESSAGE = "올바른 주소를 입력해 주세요.";

    public InvalidShopAddressException() {
        super(INVALID_SHOP_ADDRESS_MESSAGE);
    }
}

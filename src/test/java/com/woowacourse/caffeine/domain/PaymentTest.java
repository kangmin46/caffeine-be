package com.woowacourse.caffeine.domain;

import com.woowacourse.caffeine.domain.exception.InvalidIdException;
import com.woowacourse.caffeine.domain.payment.Payment;
import com.woowacourse.caffeine.domain.payment.PaymentMethod;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PaymentTest {

    @Test
    void invalid_field() {
        assertThrows(InvalidIdException.class, () -> new Payment(-1L, -20L, PaymentMethod.CREDIT_CARD));
    }

    @Test
    void null_field() {
        assertThrows(NullPointerException.class, () -> new Payment(null, null, PaymentMethod.CREDIT_CARD));
    }
}

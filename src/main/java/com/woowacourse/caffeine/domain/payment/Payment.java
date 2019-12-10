package com.woowacourse.caffeine.domain.payment;

import com.woowacourse.caffeine.domain.exception.InvalidIdException;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Payment {
    private static final Long INVALID_ID_OFFSET = 0L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long paymentId;

    private long customerId;

    private PaymentWay paymentWay;

    public Payment(long paymentId, long customerId, final PaymentWay paymentWay) {
        if (paymentId <= INVALID_ID_OFFSET && customerId <= INVALID_ID_OFFSET) {
            throw new InvalidIdException();
        }

        this.paymentId = paymentId;
        this.customerId = customerId;
        this.paymentWay = paymentWay;
    }

    protected Payment() {
    }

    public long getCustomerId() {
        return customerId;
    }

    public PaymentWay getPaymentWay() {
        return paymentWay;
    }

    public long getPaymentId() {
        return paymentId;
    }
}

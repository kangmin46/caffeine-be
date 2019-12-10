package com.woowacourse.caffeine.domain.payment;

import com.woowacourse.caffeine.domain.exception.InvalidIdException;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Payment {

    private static final Long INVALID_ID_OFFSET = 0L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long paymentId;

    private Long customerId;

    @Enumerated(value = EnumType.STRING)
    private PaymentWay paymentWay;

    public Payment(final Long paymentId, final Long customerId, final PaymentWay paymentWay) {
        this.paymentId = Objects.requireNonNull(paymentId);
        this.customerId = Objects.requireNonNull(customerId);

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

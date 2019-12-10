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
    private PaymentMethod paymentMethod;

    public Payment(final Long paymentId, final Long customerId, final PaymentMethod paymentMethod) {
        this.paymentId = Objects.requireNonNull(paymentId);
        this.customerId = Objects.requireNonNull(customerId);

        if (paymentId <= INVALID_ID_OFFSET && customerId <= INVALID_ID_OFFSET) {
            throw new InvalidIdException();
        }

        this.paymentId = paymentId;
        this.customerId = customerId;
        this.paymentMethod = paymentMethod;
    }

    protected Payment() {
    }

    public long getCustomerId() {
        return customerId;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public long getPaymentId() {
        return paymentId;
    }
}

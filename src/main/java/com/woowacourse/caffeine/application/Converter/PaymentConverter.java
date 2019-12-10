package com.woowacourse.caffeine.application.Converter;

import com.woowacourse.caffeine.application.dto.PaymentRequest;
import com.woowacourse.caffeine.application.dto.PaymentResponse;
import com.woowacourse.caffeine.domain.payment.Payment;
import com.woowacourse.caffeine.domain.payment.PaymentMethod;

public class PaymentConverter {

    public static Payment convertToEntity(final PaymentRequest paymentRequest) {
        PaymentMethod paymentMethod = PaymentMethod.match(paymentRequest.getMethod());
        return new Payment(paymentRequest.getId(), paymentRequest.getCustomerId(), paymentMethod);
    }

    public static PaymentResponse convertToResponse(final Payment payment) {
        return new PaymentResponse(payment.getPaymentId(), payment.getCustomerId(), payment.getPaymentMethod().getMethod());
    }
}

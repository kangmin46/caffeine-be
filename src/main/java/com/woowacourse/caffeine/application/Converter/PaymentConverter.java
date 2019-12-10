package com.woowacourse.caffeine.application.Converter;

import com.woowacourse.caffeine.application.dto.PaymentRequest;
import com.woowacourse.caffeine.application.dto.PaymentResponse;
import com.woowacourse.caffeine.domain.payment.Payment;
import com.woowacourse.caffeine.domain.payment.PaymentWay;

public class PaymentConverter {

    public static Payment convertToEntity(final PaymentRequest paymentRequest) {
        PaymentWay paymentWay = PaymentWay.match(paymentRequest.getWay());
        return new Payment(paymentRequest.getId(), paymentRequest.getCustomerId(), paymentWay);
    }

    public static PaymentResponse convertToResponse(final Payment payment) {
        return new PaymentResponse(payment.getPaymentId(), payment.getCustomerId(), payment.getPaymentWay().getWay());
    }
}

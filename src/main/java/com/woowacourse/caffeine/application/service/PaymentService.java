package com.woowacourse.caffeine.application.service;

import com.woowacourse.caffeine.application.dto.PaymentRequest;
import com.woowacourse.caffeine.application.dto.PaymentResponse;
import com.woowacourse.caffeine.domain.payment.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PaymentService {

    @Autowired
    private PaymentInternalService paymentInternalService;

    public long save(final PaymentRequest paymentRequest) {
        Payment payment = paymentInternalService.save(paymentRequest);
        return payment.getCustomerId();
    }

    public PaymentResponse retrieve(final long customerId) {
        return paymentInternalService.retrieve(customerId);
    }
}

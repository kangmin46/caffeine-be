package com.woowacourse.caffeine.application.service;

import com.woowacourse.caffeine.application.Converter.PaymentConverter;
import com.woowacourse.caffeine.application.dto.PaymentRequest;
import com.woowacourse.caffeine.application.dto.PaymentResponse;
import com.woowacourse.caffeine.domain.payment.Payment;
import com.woowacourse.caffeine.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PaymentInternalService {

    private final PaymentRepository paymentRepository;

    public PaymentInternalService(final PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public Payment save(final PaymentRequest paymentRequest) {
        Payment payment = PaymentConverter.convertToEntity(paymentRequest);
        return paymentRepository.save(payment);
    }

    @Transactional(readOnly = true)
    public PaymentResponse retrieve(final long customerId) {
        Payment payment = paymentRepository.findByCustomerId(customerId);
        return PaymentConverter.convertToResponse(payment);
    }
}

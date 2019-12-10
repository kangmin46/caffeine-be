package com.woowacourse.caffeine.application.service;

import com.woowacourse.caffeine.application.dto.PaymentRequest;
import com.woowacourse.caffeine.application.dto.PaymentResponse;
import com.woowacourse.caffeine.domain.payment.Payment;
import com.woowacourse.caffeine.domain.payment.PaymentWay;
import com.woowacourse.caffeine.repository.PaymentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PaymentInternalServiceTest {

    @Mock
    private PaymentRepository paymentRepository;

    @InjectMocks
    private PaymentInternalService paymentInternalService;

    @Test
    void create() {
        PaymentRequest paymentRequest = new PaymentRequest(1L, 1L, "신용카드");
        Payment payment = new Payment(1L, 1L, PaymentWay.CREDIT_CARD);

        when(paymentRepository.save(any())).thenReturn(payment);

        Payment savedPayment = paymentInternalService.save(paymentRequest);
        assertThat(savedPayment.getCustomerId()).isEqualTo(paymentRequest.getCustomerId());
    }

    @Test
    void retrieve() {
        Payment willFound = new Payment(1L, 1L, PaymentWay.CREDIT_CARD);
        when(paymentRepository.findByCustomerId(1L)).thenReturn(willFound);
        PaymentResponse paymentResponse = paymentInternalService.retrieve(1L);

        assertThat(paymentResponse.getCustomerId()).isEqualTo(1L);
        assertThat(paymentResponse.getWay()).isEqualTo("신용카드");
    }
}

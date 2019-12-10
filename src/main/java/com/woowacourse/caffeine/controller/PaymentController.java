package com.woowacourse.caffeine.controller;

import com.woowacourse.caffeine.application.dto.PaymentRequest;
import com.woowacourse.caffeine.application.dto.PaymentResponse;
import com.woowacourse.caffeine.application.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.URI;

import static com.woowacourse.caffeine.controller.PaymentController.V1_PAYMENT;

@Controller
@RequestMapping(V1_PAYMENT)
public class PaymentController {

    public static final String V1_PAYMENT = "/v1/payments";

    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public ResponseEntity create(@RequestBody final PaymentRequest paymentRequest) {
        long customerId = paymentService.save(paymentRequest);
        return ResponseEntity.created(URI.create(V1_PAYMENT + "/" + customerId))
            .build();
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<PaymentResponse> retrieve(@PathVariable final long customerId) {
        PaymentResponse paymentResponse = paymentService.retrieve(customerId);
        return ResponseEntity.ok(paymentResponse);
    }
}

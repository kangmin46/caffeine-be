package com.woowacourse.caffeine.controller;

import com.woowacourse.caffeine.application.dto.PaymentRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.EntityExchangeResult;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import static com.woowacourse.caffeine.controller.PaymentController.V1_PAYMENT;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
public class PaymentControllerTest {
    
    private static final Logger logger = LoggerFactory.getLogger(PaymentControllerTest.class);

    @Autowired
    private WebTestClient webTestClient;

    @Test
    @DisplayName("결제 생성 이후 생성된 결제 조회")
    void create() {
        PaymentRequest paymentRequest = new PaymentRequest(1L, 1L, "신용카드");

        EntityExchangeResult<byte[]> response = webTestClient.post()
            .uri(V1_PAYMENT)
            .contentType(MediaType.APPLICATION_JSON)
            .body(Mono.just(paymentRequest), PaymentRequest.class)
            .exchange()
            .expectStatus()
            .isCreated()
            .expectHeader()
            .valueMatches("Location", V1_PAYMENT + "/\\d*")
            .expectBody()
            .returnResult();

        logger.debug(" >> location : {}", response.getResponseHeaders().getLocation().toASCIIString());

        webTestClient.get()
            .uri(response.getResponseHeaders().getLocation().toASCIIString())
            .exchange()
            .expectStatus()
            .isOk()
            .expectBody()
            .jsonPath("$.customerId").isNotEmpty()
            .jsonPath("$.way").isEqualTo("신용카드");
    }
}

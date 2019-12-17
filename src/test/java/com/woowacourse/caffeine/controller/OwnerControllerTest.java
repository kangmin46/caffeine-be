package com.woowacourse.caffeine.controller;

import com.woowacourse.caffeine.application.dto.LoginRequest;
import com.woowacourse.caffeine.application.dto.SignUpRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
public class OwnerControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    @DirtiesContext
    @DisplayName("사장님 회원가입 테스트")
    void signup() {
        signUp();
    }

    @Test
    @DirtiesContext
    @DisplayName("사장님 로그인 테스트")
    void login() {
        signUp();
        LoginRequest loginRequest = new LoginRequest("kangmin789@naver.com", "P@ssWord!@");

        webTestClient.post()
            .uri("v1/owners/login")
            .body(Mono.just(loginRequest), LoginRequest.class)
            .exchange()
            .expectStatus().isOk();
    }

    private void signUp() {

        SignUpRequest signUpRequest = new SignUpRequest("kangmin789@naver.com", "P@ssWord!@", "어디야 커피 잠실점", "서울특별시 송파구 석촌호수로 262 (송파동)");

        webTestClient.post()
            .uri("/v1/owners/signup")
            .body(Mono.just(signUpRequest), SignUpRequest.class)
            .exchange()
            .expectStatus().isOk();
    }
}

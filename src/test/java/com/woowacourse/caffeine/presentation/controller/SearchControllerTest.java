package com.woowacourse.caffeine.presentation.controller;

import com.woowacourse.caffeine.application.dto.ShopResponses;
import com.woowacourse.caffeine.dbunit.WebTestClientWithDbUnitTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

import static com.woowacourse.caffeine.presentation.controller.SearchController.V1_SEARCH;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@WebTestClientWithDbUnitTest
public class SearchControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    @DisplayName("주소로 검색을 했을 때 잘 찾는지")
    void search_by_address() {
        ShopResponses shopResponses = webTestClient.get()
            .uri(V1_SEARCH + "/?query=keyWord%3Daddress,contents%3D오금로")
            .exchange()
            .expectStatus()
            .isOk()
            .expectBody(ShopResponses.class)
            .returnResult().getResponseBody();

        assertThat(shopResponses.getShopResponses().size()).isEqualTo(2);
    }

    @Test
    @DisplayName("제목으로 검색 했을 때 잘 찾는 지")
    void search_by_name() {
        ShopResponses shopResponses = webTestClient.get()
            .uri(V1_SEARCH + "/?query=keyWord%3Dname,contents%3D송")
            .exchange()
            .expectStatus()
            .isOk()
            .expectBody(ShopResponses.class)
            .returnResult().getResponseBody();

        assertThat(shopResponses.getShopResponses().size()).isEqualTo(2);
    }

    @Test
    @DisplayName("올바르지 않은 검색 요청")
    void invalid_search_request() {
        webTestClient.get()
            .uri(V1_SEARCH + "/?query=keyWord%3Dadd,contents%3D송파")
            .exchange()
            .expectStatus()
            .isBadRequest();
    }

    @Test
    @DisplayName("올바르지 않은 키워드 요청")
    void invalid_keyword_search_request() {
        webTestClient.get()
            .uri(V1_SEARCH + "/?query=key%3Dname,contents%3D송파")
            .exchange()
            .expectStatus()
            .isBadRequest();
    }

    @Test
    @DisplayName("검색 결과를 찾을 수 없을 때")
    void search_result_not_found() {
        webTestClient.get()
            .uri(V1_SEARCH + "/?query=keyWord%3Dname,contents%3D로비의 집밥")
            .exchange()
            .expectStatus()
            .isNotFound();
    }
}

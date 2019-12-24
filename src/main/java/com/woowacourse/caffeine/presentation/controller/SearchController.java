package com.woowacourse.caffeine.presentation.controller;

import com.woowacourse.caffeine.application.dto.ShopResponses;
import com.woowacourse.caffeine.application.service.SearchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.woowacourse.caffeine.presentation.controller.SearchController.V1_SEARCH;

@RestController
@RequestMapping(V1_SEARCH)
public class SearchController {
    public static final String V1_SEARCH = "/v1/search";
    public final SearchService searchService;

    public SearchController(final SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping
    public ResponseEntity search(@RequestParam final String query) {
        ShopResponses shopResponses = searchService.search(query);
        return ResponseEntity.ok(shopResponses);
    }
}

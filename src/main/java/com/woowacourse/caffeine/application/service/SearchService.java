package com.woowacourse.caffeine.application.service;

import com.woowacourse.caffeine.application.dto.ShopResponses;
import com.woowacourse.caffeine.application.dto.ShopSearchDto;
import com.woowacourse.caffeine.domain.SearchKeyWord;
import com.woowacourse.caffeine.support.SearchParser;
import org.springframework.stereotype.Service;

@Service
public class SearchService {
    private final SearchInternalService searchInternalService;

    public SearchService(SearchInternalService searchInternalService) {
        this.searchInternalService = searchInternalService;
    }

    public ShopResponses search(final String query) {
        ShopSearchDto shopSearchDto = SearchParser.parse(query);
        return searchInternalService.search(shopSearchDto, SearchKeyWord.of(shopSearchDto.getKeyWord()).getSearchFunction());
    }
}

package com.woowacourse.caffeine.domain;

import com.woowacourse.caffeine.domain.exception.SearchKeyWordNotFoundException;

import java.util.stream.Stream;

public enum SearchKeyWord {
    NAME("name", (name, pageRequest, shopRepository) ->
        shopRepository.findByNameContaining(name, pageRequest)),
    ADDRESS("address", (address, pageRequest, shopRepository) ->
        shopRepository.findByAddressContaining(address, pageRequest));

    private final String keyWord;
    private final ShopSearchFunction shopSearchFunction;

    SearchKeyWord(String keyWord, ShopSearchFunction shopSearchFunction) {
        this.keyWord = keyWord;
        this.shopSearchFunction = shopSearchFunction;
    }

    public static SearchKeyWord of(final String key) {
        return Stream.of(SearchKeyWord.values())
            .filter(searchKeyWord -> searchKeyWord.keyWord.equals(key))
            .findAny()
            .orElseThrow(SearchKeyWordNotFoundException::new);
    }

    public ShopSearchFunction getShopSearchFunction() {
        return shopSearchFunction;
    }
}

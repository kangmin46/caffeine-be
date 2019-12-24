package com.woowacourse.caffeine.domain;

import com.woowacourse.caffeine.domain.exception.SearchKeyWordNotFoundException;
import com.woowacourse.caffeine.domain.exception.SearchResultNotFoundException;
import com.woowacourse.caffeine.repository.ShopRepository;

import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Stream;

public enum SearchKeyWord {
    NAME("name", (name, shopRepository) ->
        shopRepository.findByNameContaining(name).orElseThrow(SearchResultNotFoundException::new)),
    ADDRESS("address",(address, shopRepository) ->
        shopRepository.findByAddressContaining(address).orElseThrow(SearchResultNotFoundException::new));

    private final String keyWord;
    private final BiFunction<String, ShopRepository, List<Shop>> searchFunction;

    SearchKeyWord(String keyWord, BiFunction<String, ShopRepository, List<Shop>> searchFunction) {
        this.keyWord = keyWord;
        this.searchFunction = searchFunction;
    }

    public static SearchKeyWord of(final String key) {
        return Stream.of(SearchKeyWord.values())
            .filter(searchKeyWord -> searchKeyWord.keyWord.equals(key))
            .findAny()
            .orElseThrow(SearchKeyWordNotFoundException::new);
    }

    public String getKeyWord() {
        return keyWord;
    }

    public BiFunction<String, ShopRepository, List<Shop>> getSearchFunction() {
        return searchFunction;
    }
}

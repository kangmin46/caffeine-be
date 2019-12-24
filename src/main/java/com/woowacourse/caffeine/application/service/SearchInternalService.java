package com.woowacourse.caffeine.application.service;

import com.woowacourse.caffeine.application.converter.ShopConverter;
import com.woowacourse.caffeine.application.dto.ShopResponse;
import com.woowacourse.caffeine.application.dto.ShopResponses;
import com.woowacourse.caffeine.application.dto.ShopSearchDto;
import com.woowacourse.caffeine.domain.Shop;
import com.woowacourse.caffeine.repository.ShopRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

@Service
public class SearchInternalService {

    private final ShopRepository shopRepository;

    public SearchInternalService(final ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    public ShopResponses search(final ShopSearchDto shopSearchDto, final BiFunction<String, ShopRepository, List<Shop>> searchFunction) {
        List<Shop> shops = searchFunction.apply(shopSearchDto.getContents(), shopRepository);
        List<ShopResponse> shopResponses = shops.stream()
            .map(ShopConverter::convertToDto)
            .collect(Collectors.toList());
        return new ShopResponses(shopResponses);
    }
}

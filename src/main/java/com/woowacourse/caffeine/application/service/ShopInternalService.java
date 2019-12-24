package com.woowacourse.caffeine.application.service;

import com.woowacourse.caffeine.application.converter.ShopConverter;
import com.woowacourse.caffeine.application.dto.ShopCreateRequest;
import com.woowacourse.caffeine.application.dto.ShopResponse;
import com.woowacourse.caffeine.application.dto.ShopResponses;
import com.woowacourse.caffeine.application.dto.ShopSearchDto;
import com.woowacourse.caffeine.application.exception.ShopNotFoundException;
import com.woowacourse.caffeine.domain.SearchKeyWord;
import com.woowacourse.caffeine.domain.Shop;
import com.woowacourse.caffeine.repository.ShopRepository;
import com.woowacourse.caffeine.support.SearchParser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

@Service
@Transactional
class ShopInternalService {

    private final ShopRepository shopRepository;

    public ShopInternalService(final ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    public Shop createShop(final ShopCreateRequest shopCreateRequest) {
        return shopRepository.save(Shop.create(shopCreateRequest));
    }

    @Transactional(readOnly = true)
    public Shop findById(final Long id) {
        return shopRepository.findById(id)
            .orElseThrow(() -> new ShopNotFoundException(id));
    }

    @Transactional(readOnly = true)
    public List<Shop> findAll() {
        return shopRepository.findAll();
    }

    @Transactional(readOnly = true)
    public ShopResponses search(final ShopSearchDto shopSearchDto, final BiFunction<String, ShopRepository, List<Shop>> searchFunction) {
        List<Shop> shops = searchFunction.apply(shopSearchDto.getContents(), shopRepository);
        List<ShopResponse> shopResponses = shops.stream()
            .map(ShopConverter::convertToDto)
            .collect(Collectors.toList());
        return new ShopResponses(shopResponses);
    }
}

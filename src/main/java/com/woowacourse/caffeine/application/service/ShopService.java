package com.woowacourse.caffeine.application.service;

<<<<<<< HEAD
import com.woowacourse.caffeine.application.dto.ShopCreateRequest;
import com.woowacourse.caffeine.application.dto.ShopResponse;
=======
import com.woowacourse.caffeine.application.converter.ShopConverter;
import com.woowacourse.caffeine.application.dto.ShopCreateRequest;
import com.woowacourse.caffeine.application.dto.ShopResponse;
import com.woowacourse.caffeine.application.dto.ShopResponses;
>>>>>>> 7da09fa83d2c5c6b01e722babfddb0e8de165bef
import com.woowacourse.caffeine.domain.Shop;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

<<<<<<< HEAD
=======
import java.util.List;

import static java.util.stream.Collectors.toList;
>>>>>>> 7da09fa83d2c5c6b01e722babfddb0e8de165bef

@Service
@Transactional
public class ShopService {

    private final ShopInternalService shopInternalService;
<<<<<<< HEAD

    public ShopService(final ShopInternalService shopInternalService) {
        this.shopInternalService = shopInternalService;
    }

    public ShopResponse createShop(final ShopCreateRequest request) {
        Shop shop = shopInternalService.createShop(request);
        return new ShopResponse(shop.getId(), shop.getName());
    }

    @Transactional(readOnly = true)
    public ShopResponse findById(final long id) {
        Shop shop = shopInternalService.findById(id);
        return new ShopResponse(shop.getId(), shop.getName());
=======
    private final ShopConverter shopConverter;

    public ShopService(final ShopInternalService shopInternalService, final ShopConverter shopConverter) {
        this.shopInternalService = shopInternalService;
        this.shopConverter = shopConverter;
    }

    public ShopResponse createShop(final ShopCreateRequest request) {
        final Shop shop = shopInternalService.createShop(request);
        return convertToShopResponse(shop);
    }

    @Transactional(readOnly = true)
    public ShopResponse findById(final Long id) {
        final Shop shop = shopInternalService.findById(id);
        return convertToShopResponse(shop);
    }

    @Transactional(readOnly = true)
    public ShopResponses findAll() {
        final List<Shop> shops = shopInternalService.findAll();
        final List<ShopResponse> shopResponses = shops.stream()
            .map(this::convertToShopResponse)
            .collect(toList());

        return new ShopResponses(shopResponses);
    }

    private ShopResponse convertToShopResponse(final Shop shop) {
        return shopConverter.convertToDto(shop, ShopResponse.class);
>>>>>>> 7da09fa83d2c5c6b01e722babfddb0e8de165bef
    }
}

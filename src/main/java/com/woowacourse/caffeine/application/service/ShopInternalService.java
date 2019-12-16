package com.woowacourse.caffeine.application.service;

<<<<<<< HEAD
import com.woowacourse.caffeine.application.exception.ShopNotFoundException;
import com.woowacourse.caffeine.application.dto.ShopCreateRequest;
=======
import com.woowacourse.caffeine.application.dto.ShopCreateRequest;
import com.woowacourse.caffeine.application.exception.ShopNotFoundException;
>>>>>>> 7da09fa83d2c5c6b01e722babfddb0e8de165bef
import com.woowacourse.caffeine.domain.Shop;
import com.woowacourse.caffeine.repository.ShopRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

<<<<<<< HEAD
=======
import java.util.List;

>>>>>>> 7da09fa83d2c5c6b01e722babfddb0e8de165bef
@Service
@Transactional
class ShopInternalService {

    private final ShopRepository shopRepository;

    public ShopInternalService(final ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

<<<<<<< HEAD
    public Shop createShop(final ShopCreateRequest request) {
        return shopRepository.save(new Shop(request.getName()));
    }

    public Shop findById(final long id) {
        return shopRepository.findById(id)
            .orElseThrow(() -> new ShopNotFoundException(id));
    }
=======
    public Shop createShop(final ShopCreateRequest shopCreateRequest) {
        return shopRepository.save(Shop.create(shopCreateRequest));
    }

    public Shop findById(final Long id) {
        return shopRepository.findById(id)
            .orElseThrow(() -> new ShopNotFoundException(id));
    }

    public List<Shop> findAll() {
        return shopRepository.findAll();
    }
>>>>>>> 7da09fa83d2c5c6b01e722babfddb0e8de165bef
}

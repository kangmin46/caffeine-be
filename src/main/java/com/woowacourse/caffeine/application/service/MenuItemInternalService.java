package com.woowacourse.caffeine.application.service;

<<<<<<< HEAD
=======
import com.woowacourse.caffeine.application.dto.MenuCreateRequest;
import com.woowacourse.caffeine.application.dto.MenuItemUpdateRequest;
import com.woowacourse.caffeine.application.exception.MenuItemNotFoundException;
>>>>>>> 7da09fa83d2c5c6b01e722babfddb0e8de165bef
import com.woowacourse.caffeine.domain.MenuItem;
import com.woowacourse.caffeine.domain.Shop;
import com.woowacourse.caffeine.repository.MenuItemRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MenuItemInternalService {

    private final ShopInternalService shopInternalService;
    private final MenuItemRepository menuItemRepository;

    public MenuItemInternalService(final ShopInternalService shopInternalService, final MenuItemRepository menuItemRepository) {
        this.shopInternalService = shopInternalService;
        this.menuItemRepository = menuItemRepository;
    }

    public List<MenuItem> findByShopId(final long shopId) {
        Shop vendor = shopInternalService.findById(shopId);
        return menuItemRepository.findByVendor(vendor);
    }
<<<<<<< HEAD
=======

    public MenuItem createMenuItem(final MenuCreateRequest menuCreateRequest) {
        Shop vendor = shopInternalService.findById(menuCreateRequest.getVendor());
        MenuItem menuItem = MenuItem.builder()
            .name(menuCreateRequest.getName())
            .nameInEnglish(menuCreateRequest.getNameInEnglish())
            .description(menuCreateRequest.getDescription())
            .price(menuCreateRequest.getPrice())
            .imgUrl(menuCreateRequest.getImgUrl())
            .category(menuCreateRequest.getCategory())
            .vendor(vendor)
            .build();

        return menuItemRepository.save(menuItem);
    }

    public MenuItem findByMenuItemId(final long menuItemId) {
        return menuItemRepository.findById(menuItemId)
            .orElseThrow(() -> new MenuItemNotFoundException(menuItemId));
    }

    public MenuItem updateMenuItem(final long menuItemId, final MenuItemUpdateRequest menuItemUpdateRequest) {
        MenuItem updatedMenuItem = menuItemRepository.findById(menuItemId)
            .orElseThrow(() -> new MenuItemNotFoundException(menuItemId));

        updatedMenuItem.update(menuItemUpdateRequest);
        return updatedMenuItem;
    }

    public void deleteMenuItem(final long menuItemId) {
        menuItemRepository.deleteById(menuItemId);
    }
>>>>>>> 7da09fa83d2c5c6b01e722babfddb0e8de165bef
}

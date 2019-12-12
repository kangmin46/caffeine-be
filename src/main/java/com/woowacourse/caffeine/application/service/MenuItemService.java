package com.woowacourse.caffeine.application.service;

import com.woowacourse.caffeine.application.converter.MenuItemConverter;
import com.woowacourse.caffeine.application.dto.MenuCreateRequest;
import com.woowacourse.caffeine.application.dto.MenuItemResponse;
import com.woowacourse.caffeine.application.dto.MenuItemUpdateRequest;
import com.woowacourse.caffeine.domain.MenuItem;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class MenuItemService {

    private final MenuItemInternalService menuItemInternalService;

    public MenuItemService(final MenuItemInternalService menuItemInternalService) {
        this.menuItemInternalService = menuItemInternalService;
    }

    @Transactional(readOnly = true)
    public List<MenuItemResponse> findByShopId(final long shopId) {
        return menuItemInternalService.findByShopId(shopId)
            .stream()
            .map(MenuItemConverter::convertToResponse)
            .collect(Collectors.toList());
    }

    public MenuItemResponse createMenuItem(final MenuCreateRequest menuCreateRequest) {
        MenuItem menuItem = menuItemInternalService.createMenuItem(menuCreateRequest);
        return MenuItemConverter.convertToResponse(menuItem);
    }

    @Transactional(readOnly = true)
    public MenuItemResponse findByMenuItemId(final long menuItemId) {
        MenuItem menuItem = menuItemInternalService.findById(menuItemId);
        return MenuItemConverter.convertToResponse(menuItem);
    }

    public MenuItemResponse updateMenuItem(final long menuItemId, final MenuItemUpdateRequest menuItemUpdateRequest) {
        MenuItem updatedMenuItem = menuItemInternalService.updateMenuItem(menuItemId, menuItemUpdateRequest);
        return MenuItemConverter.convertToResponse(updatedMenuItem);
    }

    public void deleteMenuItem(final long menuItemId) {
        menuItemInternalService.deleteMenuItem(menuItemId);
    }
}

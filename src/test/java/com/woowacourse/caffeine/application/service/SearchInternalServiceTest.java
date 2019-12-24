package com.woowacourse.caffeine.application.service;

import com.woowacourse.caffeine.application.dto.ShopResponses;
import com.woowacourse.caffeine.application.dto.ShopSearchDto;
import com.woowacourse.caffeine.domain.SearchKeyWord;
import com.woowacourse.caffeine.domain.Shop;
import com.woowacourse.caffeine.repository.ShopRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static com.woowacourse.caffeine.presentation.controller.OwnerController.DEFAULT_IMAGE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SearchInternalServiceTest {

    @InjectMocks
    private ShopInternalService shopInternalService;

    @Mock
    private ShopRepository shopRepository;

    @Test
    void search_by_name() {
        ShopSearchDto shopSearchDto = new ShopSearchDto("name", "어디야");
        List<Shop> shops = Arrays.asList(new Shop("어디야 커피", DEFAULT_IMAGE,"송파구", "010-3080-5610")
            ,new Shop("어디야 커피 부산점", DEFAULT_IMAGE,"송파구", "010-3080-5610"));
        when(shopRepository.findByNameContaining(any())).thenReturn(Optional.of(shops));
        ShopResponses shopResponses = shopInternalService.search(shopSearchDto, SearchKeyWord.of(shopSearchDto.getKeyWord()).getSearchFunction());
        assertThat(shopResponses.getShopResponses().size()).isEqualTo(2);
    }

    @Test
    void search_by_address() {
        ShopSearchDto shopSearchDto = new ShopSearchDto("address", "송피");
        List<Shop> shops = Arrays.asList(new Shop("어디야 커피", DEFAULT_IMAGE,"송파나루", "010-3080-5610")
            ,new Shop("어디야 커피 부산점", DEFAULT_IMAGE,"송파구", "010-3080-5610"));
        when(shopRepository.findByAddressContaining(any())).thenReturn(Optional.of(shops));
        ShopResponses shopResponses = shopInternalService.search(shopSearchDto, SearchKeyWord.of(shopSearchDto.getKeyWord()).getSearchFunction());
        assertThat(shopResponses.getShopResponses().size()).isEqualTo(2);
    }
}

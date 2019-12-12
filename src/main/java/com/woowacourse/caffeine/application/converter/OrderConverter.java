package com.woowacourse.caffeine.application.converter;

import com.woowacourse.caffeine.application.dto.OrderResponse;
import com.woowacourse.caffeine.domain.Order;

public class OrderConverter {

    public static OrderResponse convertToResponse(final Order order) {
        return new OrderResponse(order.getId(), order.getMenuItem().getId());
    }
}

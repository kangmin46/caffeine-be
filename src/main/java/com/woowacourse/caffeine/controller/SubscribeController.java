package com.woowacourse.caffeine.controller;

import com.woowacourse.caffeine.application.service.CustomerNotificationService;
import com.woowacourse.caffeine.application.service.ShopNotificationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;

import javax.servlet.http.HttpSession;

import static com.woowacourse.caffeine.controller.SubscribeController.V1_SUBSCRIBE;

@RestController
@RequestMapping(V1_SUBSCRIBE)
public class SubscribeController {

    public static final String V1_SUBSCRIBE = "/v1/subscribe";

    private final CustomerNotificationService customerNotificationService;
    private final ShopNotificationService shopNotificationService;

    public SubscribeController(final CustomerNotificationService customerNotificationService, final ShopNotificationService shopNotificationService) {
        this.customerNotificationService = customerNotificationService;
        this.shopNotificationService = shopNotificationService;
    }

    @GetMapping("/customers")
    public ResponseBodyEmitter subscribeCustomer(final HttpSession httpSession) {
        return customerNotificationService.subscribe(httpSession.getId());
    }

    @GetMapping("/shops/{id}")
    public ResponseBodyEmitter subscribeOwner(@PathVariable Long id ) {
        return shopNotificationService.subscribe(id);
    }
}

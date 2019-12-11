package com.woowacourse.caffeine.controller;

<<<<<<< HEAD
import com.woowacourse.caffeine.application.service.CustomerNotificationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;

import static com.woowacourse.caffeine.controller.SubscribeController.V1_SUBSCRIBE;

@RestController
@RequestMapping(V1_SUBSCRIBE)
public class SubscribeController {

    public static final String V1_SUBSCRIBE = "/v1/subscribe";

    private final CustomerNotificationService customerNotificationService;

    public SubscribeController(final CustomerNotificationService customerNotificationService) {
        this.customerNotificationService = customerNotificationService;
    }

    @GetMapping("/{customerId}")
    public ResponseBodyEmitter subscribe(@PathVariable String customerId) {
        return customerNotificationService.subscribe(customerId);
    }
}

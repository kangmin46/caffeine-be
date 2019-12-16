package com.woowacourse.caffeine.application.service;

import com.woowacourse.caffeine.application.dto.LoginRequest;
import com.woowacourse.caffeine.application.dto.SignUpRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OwnerService {

    private final OwnerInternalService ownerInternalService;

    public OwnerService(OwnerInternalService ownerInternalService) {
        this.ownerInternalService = ownerInternalService;
    }

    public void signUp(SignUpRequest signUpRequest) {
        ownerInternalService.save(signUpRequest);
    }

    public String login(LoginRequest loginRequest) {
        return ownerInternalService.login(loginRequest);
    }
}

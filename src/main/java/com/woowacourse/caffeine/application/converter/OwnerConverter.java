package com.woowacourse.caffeine.application.converter;

import com.woowacourse.caffeine.application.dto.SignUpRequest;
import com.woowacourse.caffeine.domain.Owner;

public class OwnerConverter {

    public static Owner convertToEntity(SignUpRequest signUpRequest) {
        return new Owner(signUpRequest.getShopName(), signUpRequest.getShopAddress(), signUpRequest.getEmail(), signUpRequest.getPassword());
    }
}

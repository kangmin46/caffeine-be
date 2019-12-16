package com.woowacourse.caffeine.application.service;

import com.woowacourse.caffeine.application.dto.LoginRequest;
import com.woowacourse.caffeine.application.dto.SignUpRequest;
import com.woowacourse.caffeine.application.exception.PasswordMisMatchException;
import com.woowacourse.caffeine.domain.Owner;
import com.woowacourse.caffeine.repository.OwnerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OwnerInternalServiceTest {

    @InjectMocks
    private OwnerInternalService ownerInternalService;

    @Mock
    private OwnerRepository ownerRepository;

    @Test
    void save() {
        SignUpRequest signUpRequest = new SignUpRequest("kangmin46", "로비",  "kangmin789@naver.com", "Pass@word!@");
        Owner owner = new Owner("kangmin46", "로비",  "kangmin789@naver.com", "Pass@word!@");
        when(ownerRepository.save(any())).thenReturn(owner);
        assertThat(ownerInternalService.save(signUpRequest)).isNotNull();
    }

    @Test
    void login_password_mismatch() {
        LoginRequest loginRequest = new LoginRequest("kangmin46", "P@ssWrod!!");
        Owner owner = new Owner("kangmin46", "로비", "kangmin789@naver.com", "P@ssword@!@##$");
        when(ownerRepository.findByOwnerId(any())).thenReturn(Optional.of(owner));

        assertThrows(PasswordMisMatchException.class, () -> ownerInternalService.login(loginRequest));
    }

    @Test
    void login_success_login() {
        LoginRequest loginRequest = new LoginRequest("kangmin46", "P@ssWrod!!");
        Owner owner = new Owner("kangmin46", "로비", "kangmin789@naver.com", "P@ssWrod!!");
        when(ownerRepository.findByOwnerId(any())).thenReturn(Optional.of(owner));
        assertThat(ownerInternalService.login(loginRequest)).isNotNull();
    }
}

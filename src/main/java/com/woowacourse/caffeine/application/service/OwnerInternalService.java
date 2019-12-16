package com.woowacourse.caffeine.application.service;

import com.woowacourse.caffeine.application.converter.OwnerConverter;
import com.woowacourse.caffeine.application.dto.LoginRequest;
import com.woowacourse.caffeine.application.dto.SignUpRequest;
import com.woowacourse.caffeine.application.exception.OwnerNotFoundException;
import com.woowacourse.caffeine.domain.Owner;
import com.woowacourse.caffeine.repository.OwnerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Service
public class OwnerInternalService {

    private final OwnerRepository ownerRepository;

    public OwnerInternalService(final OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    public Owner save(final SignUpRequest signUpRequest) {
        Owner owner = OwnerConverter.convertToEntity(signUpRequest);
        return ownerRepository.save(owner);
    }

    public String login(final LoginRequest loginRequest) {
        Owner owner = ownerRepository.findByEmail(loginRequest.getEmail())
            .orElseThrow(OwnerNotFoundException::new);
        owner.checkAuthenticate(loginRequest.getPassword());
        return owner.getEmail();
    }
}

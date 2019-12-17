package com.woowacourse.caffeine.application.service;

import com.woowacourse.caffeine.application.converter.OwnerConverter;
import com.woowacourse.caffeine.application.dto.LoginRequest;
import com.woowacourse.caffeine.application.dto.OwnerResponse;
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

    public Long save(final SignUpRequest signUpRequest) {
        Owner owner = OwnerConverter.convertToEntity(signUpRequest);
        return ownerRepository.save(owner).getId();
    }

    public String authenticate(final LoginRequest loginRequest) {
        Owner owner = ownerRepository.findByEmail(loginRequest.getEmail())
            .orElseThrow(OwnerNotFoundException::new);
        owner.authenticate(loginRequest.getPassword());
        return owner.getEmail();
    }

    public OwnerResponse findByEmail(final String email) {
        Owner owner = ownerRepository.findByEmail(email)
            .orElseThrow(OwnerNotFoundException::new);
        return OwnerConverter.convertToResponse(owner);
    }
}

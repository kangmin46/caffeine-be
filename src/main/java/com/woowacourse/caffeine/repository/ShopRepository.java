package com.woowacourse.caffeine.repository;

import com.woowacourse.caffeine.domain.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ShopRepository extends JpaRepository<Shop, Long> {
    Optional<List<Shop>> findByNameContaining(String name);

    Optional<List<Shop>> findByAddressContaining(String address);
}

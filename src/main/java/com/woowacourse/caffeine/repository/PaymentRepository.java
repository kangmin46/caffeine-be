package com.woowacourse.caffeine.repository;

import com.woowacourse.caffeine.domain.payment.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    Payment findByCustomerId(long customerId);
}

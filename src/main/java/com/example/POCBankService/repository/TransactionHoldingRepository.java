package com.example.POCBankService.repository;

import com.example.POCBankService.entity.TransactionHolding;
import org.springframework.data.jpa.repository.JpaRepository;
import reactor.core.publisher.Flux;

public interface TransactionHoldingRepository extends JpaRepository<TransactionHolding, Long> {
    Flux<TransactionHolding> findByStatusAndRetrycountLessThan(String status, int retrycount);
}

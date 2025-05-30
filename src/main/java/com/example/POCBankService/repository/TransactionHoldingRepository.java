package com.example.POCBankService.repository;

import com.example.POCBankService.entity.TransactionHolding;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionHoldingRepository extends JpaRepository<TransactionHolding, Long> {
    List<TransactionHolding> findByStatusAndRetrycountLessThan(String status, int retrycount);
}

package com.example.POCBankService.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PaymentRequest {
    private String transactionId;
    private double amount;
    private String currency;
    private String payee;
}

package com.example.POCBankService.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
public class SubmitTransaction {
    private String transactionId;
    private double amount;
    private String currency;
    private String payee;
    private ZonedDateTime timestamp;

}

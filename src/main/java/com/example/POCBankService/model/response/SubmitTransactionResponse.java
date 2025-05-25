package com.example.POCBankService.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SubmitTransactionResponse {
    private String status;
    private String transactionDateTime;
}

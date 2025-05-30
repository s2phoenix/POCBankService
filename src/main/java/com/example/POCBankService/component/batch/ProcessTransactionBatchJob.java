package com.example.POCBankService.component.batch;

import com.example.POCBankService.entity.TransactionHolding;
import com.example.POCBankService.model.request.PaymentRequest;
import com.example.POCBankService.repository.TransactionHoldingRepository;
import com.example.POCBankService.repository.TransactionInfoRepository;
import com.example.POCBankService.repository.UserInfoRepository;
import com.example.POCBankService.service.PaymentApiGatewayService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class ProcessTransactionBatchJob {
    @Value("${batch.schedule.cron}")
    private String cronExpression;

    private final PaymentApiGatewayService paymentApi;
    private final TransactionHoldingRepository holdingRepository;
    private final TransactionInfoRepository transactionInfoRepository;
    private final UserInfoRepository userInfoRepository;


    public ProcessTransactionBatchJob(PaymentApiGatewayService paymentApi, PaymentApiGatewayService paymentApi1, TransactionHoldingRepository holdingRepository, TransactionInfoRepository transactionInfoRepository, UserInfoRepository userInfoRepository) {
        this.paymentApi = paymentApi1;
        this.holdingRepository = holdingRepository;
        this.transactionInfoRepository = transactionInfoRepository;
        this.userInfoRepository = userInfoRepository;
    }

    @Scheduled(cron = "${batch.schedule.cron}")
    public void runBatch() {
        System.out.println("Hello - Batch job running at " + java.time.LocalDateTime.now());
        Flux.fromIterable(
                        holdingRepository.findByStatusAndRetrycountLessThan("PENDING", 3)
                )
                .flatMap(this::mapToPaymentRequest)
                .flatMap(paymentApi::submitPayment)
                .onErrorContinue((error, obj) -> {
                    System.out.println("Error on transaction: " + error.getMessage());
                })
                .then()
                .subscribe();
    }

    private Mono<PaymentRequest> mapToPaymentRequest(TransactionHolding holding) {
        return Mono.just(
                new PaymentRequest(
                        holding.getTransactionId(),
                        holding.getAmount(),
                        holding.getCurrency(),
                        holding.getPayee()
                )
        );
    }
}

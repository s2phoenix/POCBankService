package com.example.POCBankService.service;

import com.example.POCBankService.model.request.PaymentRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class PaymentApiGatewayService {

    private final WebClient webClient;

    public PaymentApiGatewayService(WebClient.Builder webClientBuilder,
                                    @Value("${payment.api.base-url}") String baseUrl) {
        this.webClient = webClientBuilder.baseUrl(baseUrl).build();
    }

    public <T> Mono<T> callPostApi(String endpoint, Object requestBody, Class<T> responseType) {
        return webClient.post()
                .uri(endpoint)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(responseType);
    }

    // ตัวอย่าง method เฉพาะสำหรับ /payments/submit
    public Mono<String> submitPayment(PaymentRequest request) {
        return callPostApi("/payments/submit", request, String.class);
    }
}

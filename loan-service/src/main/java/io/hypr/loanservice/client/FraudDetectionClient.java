package io.hypr.loanservice.client;

import io.hypr.loanservice.entity.LoanStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
@RequiredArgsConstructor
@Slf4j
public class FraudDetectionClient {
    private final RestClient restClient;

    public LoanStatus evaluateLoan(int customerId) {
        log.info("Calling Fraud Detection Service for customer id: {}", customerId);
        var response = restClient
                .get()
                .uri("/fraud/check?customerId=" + customerId)
                .retrieve()
                .toEntity(LoanStatus.class)
                .getBody();
        log.info("Fraud Detection Service response: {}", response);
        return response;
    }
}

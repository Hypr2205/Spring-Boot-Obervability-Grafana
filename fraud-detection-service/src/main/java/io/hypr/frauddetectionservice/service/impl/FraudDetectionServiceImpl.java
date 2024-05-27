package io.hypr.frauddetectionservice.service.impl;

import io.hypr.frauddetectionservice.entity.LoanStatus;
import io.hypr.frauddetectionservice.repository.FraudRecordRepository;
import io.hypr.frauddetectionservice.service.FraudDetectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FraudDetectionServiceImpl implements FraudDetectionService {
    private final FraudRecordRepository fraudRecordRepository;

    @Override
    public LoanStatus checkForFraud(int customerId) {
        return fraudRecordRepository.existsByCustomerId(customerId) ? LoanStatus.REJECTED : LoanStatus.APPROVED;
    }
}

package io.hypr.frauddetectionservice.service;

import io.hypr.frauddetectionservice.entity.LoanStatus;

public interface FraudDetectionService {
    LoanStatus checkForFraud(int customerId);
}

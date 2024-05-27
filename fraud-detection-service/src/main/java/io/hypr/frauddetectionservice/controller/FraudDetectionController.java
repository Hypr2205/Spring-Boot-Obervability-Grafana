package io.hypr.frauddetectionservice.controller;

import io.hypr.frauddetectionservice.entity.LoanStatus;
import io.hypr.frauddetectionservice.service.FraudDetectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/frauds")
@RequiredArgsConstructor
public class FraudDetectionController {

    private final FraudDetectionService fraudDetectionService;

    @GetMapping("/check")
    public LoanStatus checkForFraud(@RequestParam int customerId) {
        return fraudDetectionService.checkForFraud(customerId);
    }
}

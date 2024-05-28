package io.hypr.loanservice.service.impl;

import io.hypr.loanservice.client.FraudDetectionClient;
import io.hypr.loanservice.dto.LoanDTO;
import io.hypr.loanservice.entity.LoanStatus;
import io.hypr.loanservice.mapper.LoanMapper;
import io.hypr.loanservice.repository.LoanRepository;
import io.hypr.loanservice.service.LoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoanServiceImplement implements LoanService {
    private final LoanRepository loanRepository;
    private final FraudDetectionClient fraudDetectionClient;

    @Override
    public List<LoanDTO> listAllLoans() {
        return loanRepository
                .findAll()
                .stream()
                .map(LoanMapper::toDTO)
                .toList();
    }

    @Override
    public String applyLoan(LoanDTO loanDTO) {
        var loan = LoanMapper.toEntity(loanDTO);
        LoanStatus loanStatus = fraudDetectionClient.evaluateLoan(loan.getCustomerId());
        loan.setLoanStatus(loanStatus);
        if (loanStatus.equals(LoanStatus.APPROVED)) {
            loanRepository.save(loan);
            return "Loan applied successfully";
        }
        return "Sorry! Your loan was not approved";
    }
}

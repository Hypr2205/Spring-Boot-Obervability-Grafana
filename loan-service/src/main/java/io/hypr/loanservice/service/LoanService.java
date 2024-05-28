package io.hypr.loanservice.service;

import io.hypr.loanservice.dto.LoanDTO;

import java.util.List;

public interface LoanService {
    List<LoanDTO> listAllLoans();
    String applyLoan(LoanDTO loanDTO);
}

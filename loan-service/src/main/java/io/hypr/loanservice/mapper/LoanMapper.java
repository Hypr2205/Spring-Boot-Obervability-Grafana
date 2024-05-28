package io.hypr.loanservice.mapper;

import io.hypr.loanservice.dto.LoanDTO;
import io.hypr.loanservice.entity.Loan;

public class LoanMapper {
    public static Loan toEntity(LoanDTO loanDTO) {
        return Loan
                .builder()
                .loanId(loanDTO.getLoanId())
                .amount(loanDTO.getAmount())
                .customerId(loanDTO.getCustomerId())
                .customerName(loanDTO.getCustomerName())
                .build();
    }

    public static LoanDTO toDTO(Loan loan) {
        return LoanDTO
                .builder()
                .loanId(loan.getLoanId())
                .customerName(loan.getCustomerName())
                .customerId(loan.getCustomerId())
                .amount(loan.getAmount())
                .loanStatus(loan.getLoanStatus())
                .build();
    }
}

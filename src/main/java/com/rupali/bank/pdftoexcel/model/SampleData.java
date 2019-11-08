package com.rupali.bank.pdftoexcel.model;

import lombok.Data;

@Data
public class SampleData {
    private String transactionDate;
    private String reconciliationDate;
    private String glNumber;
    private String transaction;
    private String accountNo;
    private String transactionIssuer;
    private Double debit;
    private Double credit;
    private Double TotalAmount;
}

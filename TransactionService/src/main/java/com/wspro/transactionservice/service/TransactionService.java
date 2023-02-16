package com.wspro.transactionservice.service;

import com.wspro.transactionservice.model.Transaction;
import com.wspro.transactionservice.Dto.ResponseDto;

public interface TransactionService {
	ResponseDto addTransaction(Transaction transaction);
	ResponseDto updateTransaction(Transaction transaction);
	ResponseDto findAllTransactions();
	ResponseDto findTransactionById(String transId);
	ResponseDto deposit(String walletRef,Double amount);
	ResponseDto withdraw(String walletRef,Double amount);
}

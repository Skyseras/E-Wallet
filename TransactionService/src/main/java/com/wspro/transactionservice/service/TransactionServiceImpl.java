package com.wspro.transactionservice.service;

import com.wspro.transactionservice.Dto.WalletDto;
import com.wspro.transactionservice.controller.WalletProxy;
import com.wspro.transactionservice.model.Transaction;
import com.wspro.transactionservice.model.TransactionType;
import com.wspro.transactionservice.repository.TransactionRepo;
import com.wspro.transactionservice.Dto.ResponseDto;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {
	private final TransactionRepo transactionRepository;
	private final WalletProxy walletProxy;

	public TransactionServiceImpl(TransactionRepo transactionRepository, WalletProxy walletProxy) {
		this.transactionRepository = transactionRepository;
		this.walletProxy = walletProxy;
	}

	@Override
	public ResponseDto addTransaction(Transaction transaction) {

		if (transaction == null){
			return new ResponseDto("bad request","Transaction is null");
		}
		else if (transaction.getTransactionType() == null){
			return new ResponseDto("bad request","please choose Transaction type");
		}
		else if (transaction.getAmount() == null){
			return new ResponseDto("bad request","please enter amount of transaction");
		}
		else if (transaction.getAmount() < 0){
			return new ResponseDto("bad request","amount must be greater than 0");
		}
		else {
			if (transaction.getTransactionType() == TransactionType.DEPOSIT){
				this.deposit(transaction.getWalletRef(), transaction.getAmount());
				transaction.setDateTransaction(LocalDate.now());
				transactionRepository.save(transaction);
				return new ResponseDto("success","transaction add success",transaction);
			} else if (transaction.getTransactionType() == TransactionType.WITHDRAW) {
				transaction.setTransactionType(TransactionType.WITHDRAW);
				ResponseDto responseDto=  this.withdraw(transaction.getWalletRef(), transaction.getAmount());
				if(responseDto.getStatus().equals("bad request")){
					return responseDto;
				}
			}
		}
		transaction.setDateTransaction(LocalDate.now());
		transactionRepository.save(transaction);
		return new ResponseDto("success","transaction add success",transaction);
	}

	@Override
	public ResponseDto updateTransaction(Transaction transaction) {
		return null;
	}

	@Override
	public ResponseDto findAllTransactions() {
		return new ResponseDto("success","all transactions",transactionRepository.findAll());
	}

	@Override
	public ResponseDto findTransactionById(String transId) {
		Optional<Transaction> transaction = transactionRepository.findById(transId);
		if (!transaction.isPresent()){
			return new ResponseDto("bad request","this transaction not exist");
		}else {
			return new ResponseDto("success","transaction",transaction.get());
		}
	}

	@Override
	public ResponseDto deposit(String walletRef,Double amount) {
		WalletDto wallet = walletProxy.findWalletByRef(walletRef);
		if (wallet == null){
			return new ResponseDto("bad request","this wallet not exist");
		}else{
			wallet.setBalance(wallet.getBalance()+amount);
			walletProxy.updateWallet(wallet);
			return new ResponseDto("success","this transaction success",wallet);
		}
	}

	@Override
	public ResponseDto withdraw(String walletRef,Double amount) {
		WalletDto wallet = walletProxy.findWalletByRef(walletRef);
		if (wallet == null) {
			return new ResponseDto("bad request","this wallet not exist");
		}else if (wallet.getBalance() < amount){
			return new ResponseDto("bad request","balance is less than amount");
		}else {
			wallet.setBalance(wallet.getBalance() - amount);
			walletProxy.updateWallet(wallet);
			return new ResponseDto("success","this transaction success",wallet);
		}
	}
}

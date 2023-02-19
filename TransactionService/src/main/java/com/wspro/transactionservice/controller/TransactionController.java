package com.wspro.transactionservice.controller;

import com.wspro.transactionservice.Dto.TransactionDto;
import com.wspro.transactionservice.model.Transaction;
import com.wspro.transactionservice.model.TransactionType;
import com.wspro.transactionservice.service.TransactionService;
import com.wspro.transactionservice.Dto.ResponseDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/transaction")
public class TransactionController {
	private TransactionService transactionService;
	public TransactionController(TransactionService transactionService) {
		this.transactionService = transactionService;
	}

	/*--------------------------------------------  Add New Transaction  ------------------------------------------------*/
	@PostMapping("/add")
	@CircuitBreaker(name = "wallet", fallbackMethod = "fallBack")
	public ResponseDto addTransaction(@RequestBody TransactionDto transactionDto){
		Transaction transaction = new Transaction();
		transaction.setAmount(transactionDto.getAmount());
		transaction.setWalletRef(transactionDto.getWalletRef());
		if (transactionDto.getTransactionType().equals("DEPOSIT")){
			transaction.setTransactionType(TransactionType.DEPOSIT);
		}else {
			transaction.setTransactionType(TransactionType.WITHDRAW);
		}
		return transactionService.addTransaction(transaction);
	}

	public ResponseDto fallBack(TransactionDto transactionDto, Throwable throwable){
		return new ResponseDto("FallBack response","please retry later");
	}

	/*--------------------------------------------  List All transactions  ------------------------------------------------*/
	@GetMapping("/list")
	public ResponseDto findAll(){
		return transactionService.findAllTransactions();
	}
	/*--------------------------------------------  Find transaction by Id  ------------------------------------------------*/
	@GetMapping("/transaction/{id}")
	public ResponseDto findTransaction(@PathVariable String id){
		return transactionService.findTransactionById(id);
	}
}

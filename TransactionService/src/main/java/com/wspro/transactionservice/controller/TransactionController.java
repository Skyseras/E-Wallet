package com.wspro.transactionservice.controller;

import com.wspro.transactionservice.Dto.TransactionDto;
import com.wspro.transactionservice.model.Transaction;
import com.wspro.transactionservice.model.TransactionType;
import com.wspro.transactionservice.service.TransactionService;
import com.wspro.transactionservice.Dto.ResponseDto;
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

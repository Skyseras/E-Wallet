package com.wspro.walletservice.controller;

import com.wspro.walletservice.Dto.ResponseDto;
import com.wspro.walletservice.Dto.WalletDto;
import com.wspro.walletservice.model.Wallet;
import com.wspro.walletservice.service.WalletService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/wallet")
public class WalletController {
	private final WalletService walletService;
	public WalletController(WalletService walletService) {
		this.walletService = walletService;
	}

	/*--------------------------------------------  Add New Wallet  ------------------------------------------------*/
	@PostMapping("/add")
	public ResponseDto addWallet(@RequestBody WalletDto walletdto){
		Wallet wallet = new Wallet();
		wallet.setBalance(walletdto.getBalance());
		wallet.setCustomerId(walletdto.getCustomerId());
		wallet.setReference(walletdto.getReference());
		return walletService.addWallet(wallet);
	}

	/*--------------------------------------------  Find Wallet By cusId  ------------------------------------------------*/
	@GetMapping("/customer/{cusId}")
	public ResponseDto findWalletOfCustomer(@PathVariable String cusId){
		return walletService.findWalletByCustomerId(cusId);
	}

	/*--------------------------------------------  Find Wallet By ref  ------------------------------------------------*/
	@GetMapping("/reference/{ref}")
	public Optional<Wallet> findWalletByRef(@PathVariable String ref){
		return (Optional<Wallet>) walletService.findWalletByReference(ref).getData();
	}

	/*--------------------------------------------  List All Wallets  ------------------------------------------------*/
	@GetMapping("/list")
	public ResponseDto findAllWallet(){
		return walletService.findAllWallet();
	}

	/*--------------------------------------------  Update Wallet  ------------------------------------------------*/
	@PutMapping("/update")
	public ResponseDto updateWallet(@RequestBody Wallet wallet){
		return walletService.updateWallet(wallet);
	}

}

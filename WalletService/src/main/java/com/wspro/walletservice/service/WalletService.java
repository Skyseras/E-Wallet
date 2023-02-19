package com.wspro.walletservice.service;

import com.wspro.walletservice.model.Wallet;
import com.wspro.walletservice.Dto.ResponseDto;


public interface WalletService {
	ResponseDto addWallet(Wallet wallet);
	ResponseDto updateWallet(Wallet wallet);
	ResponseDto findAllWallet();
	ResponseDto findWalletByCustomerId(String cusId);
	ResponseDto findWalletById(Long walId);
	ResponseDto findWalletByReference(String ref);
}

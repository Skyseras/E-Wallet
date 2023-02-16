package com.wspro.walletservice.service;

import com.wspro.walletservice.Dto.ResponseDto;
import com.wspro.walletservice.model.Wallet;
import com.wspro.walletservice.repository.WalletRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class WalletServiceImpl implements WalletService {
	private WalletRepo walletRepository;
	public WalletServiceImpl(WalletRepo walletRepository) {
		this.walletRepository = walletRepository;
	}
	@Override
	public ResponseDto addWallet(Wallet wallet) {
		if (wallet == null){
			return new ResponseDto("bad request","wallet is null");
		} else {
			wallet.setBalance(0D);
			wallet.setCreatedAt(LocalDate.now());
			walletRepository.save(wallet);
			return new ResponseDto("success","your wallet is created with success");
		}
	}

	@Override
	public ResponseDto updateWallet(Wallet wallet) {
		Optional<Wallet> walletFound = (Optional<Wallet>) this.findWalletByReference(wallet.getReference()).getData();
		walletFound.get().setBalance(wallet.getBalance());
		walletRepository.save(walletFound.get());
		return new ResponseDto("success","wallet updated",walletFound.get());
	}

	@Override
	public ResponseDto findAllWallet() {
		return new ResponseDto("success","all wallets",walletRepository.findAll());
	}

	@Override
	public ResponseDto findWalletByCustomerId(String cusId) {
		Optional<Wallet> wallet = walletRepository.findByCustomerId(cusId);
		if (!wallet.isPresent()){
			return new ResponseDto("bad request","wallet of this customer not exist");
		}else {
			return new ResponseDto("success","wallet of customer port cin "+cusId,wallet);
		}
	}

	@Override
	public ResponseDto findWalletById(Long walId) {
		Optional<Wallet> wallet = walletRepository.findById(walId);
		if (!wallet.isPresent()){
			return new ResponseDto("bad request","wallet of this customer not exist");
		}else {
			return new ResponseDto("success","wallet",wallet);
		}
	}

	@Override
	public ResponseDto findWalletByReference(String ref) {
		Optional<Wallet> wallet = walletRepository.findByReference(ref);
		if (wallet.isEmpty()){
			return new ResponseDto("bad request","wallet of this customer not exist");
		}else {
			return new ResponseDto("success","wallet",wallet);
		}
	}
}

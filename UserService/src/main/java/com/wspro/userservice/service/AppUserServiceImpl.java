package com.wspro.userservice.service;

import com.wspro.userservice.Dto.WalletDto;
import com.wspro.userservice.controller.WalletProxy;
import com.wspro.userservice.model.AppUser;
import com.wspro.userservice.repository.AppUserRepo;
import com.wspro.userservice.Dto.ResponseDto;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;


@Service
public class AppUserServiceImpl implements AppUserService {
	private final AppUserRepo appUserRepository;
	private final WalletProxy walletProxy;

	public AppUserServiceImpl(AppUserRepo appUserRepository, WalletProxy walletProxy) {
		this.appUserRepository = appUserRepository;
		this.walletProxy = walletProxy;
	}

	@Override
	public ResponseDto addUser(AppUser user) {
		if (user == null){
			return new ResponseDto("bad request","user is null");
		} else {
			WalletDto newUserWallet = new WalletDto();
			newUserWallet.setCustomerId(user.getCin());
			newUserWallet.setReference(UUID.randomUUID().toString());
			newUserWallet.setBalance(0D);
			appUserRepository.save(user);
			walletProxy.addWallet(newUserWallet);
			return new ResponseDto("success","user is added and new wallet is created",user);
		}
	}

	@Override
	public ResponseDto updateUser(AppUser user) {
		return null;
	}

	@Override
	public ResponseDto findById(Long userId) {
		return null;
	}

	@Override
	public ResponseDto findByEmail(String email) {
		Optional<AppUser> user = appUserRepository.findByCin(email);
		if (!user.isPresent()){
			return new ResponseDto("bad request","this user not found");
		}else {
			return new ResponseDto("success","user with email "+email,user.get());
		}
	}

	@Override
	public ResponseDto findByPhone(String phone) {
		Optional<AppUser> user = appUserRepository.findByCin(phone);
		if (!user.isPresent()){
			return new ResponseDto("bad request","this user not found");
		}else {
			return new ResponseDto("success","user with phone "+phone,user.get());
		}
	}

	@Override
	public ResponseDto findByCin(String cin) {
		Optional<AppUser> user = appUserRepository.findByCin(cin);
		if (!user.isPresent()){
			return new ResponseDto("bad request","this user not found");
		}else {
			return new ResponseDto("success","user with cin "+cin,user.get());
		}
	}
}

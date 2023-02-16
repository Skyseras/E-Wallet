package com.wspro.userservice.service;

import com.wspro.userservice.Dto.ResponseDto;
import com.wspro.userservice.model.AppUser;

public interface AppUserService {
	ResponseDto addUser(AppUser user);
	ResponseDto updateUser(AppUser user);
	ResponseDto findById(Long userId);
	ResponseDto findByEmail(String email);
	ResponseDto findByPhone(String phone);
	ResponseDto findByCin(String cin);
}

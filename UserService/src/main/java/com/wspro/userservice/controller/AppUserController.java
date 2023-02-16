package com.wspro.userservice.controller;

import com.wspro.userservice.Dto.AppUserDto;
import com.wspro.userservice.model.AppUser;
import com.wspro.userservice.service.AppUserService;
import com.wspro.userservice.Dto.ResponseDto;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/user")
public class AppUserController {
	private AppUserService appUserService;

	public AppUserController(AppUserService appUserService) {
		this.appUserService = appUserService;
	}

	@PostMapping("/register")
	public ResponseDto register(@RequestBody AppUserDto appUserDto){
		AppUser appUser = new AppUser();
		appUser.setLastName(appUserDto.getLastName());
		appUser.setFirstName(appUserDto.getFirstName());
		appUser.setCin(appUserDto.getCin());
		appUser.setEmail(appUserDto.getEmail());
		appUser.setPhone(appUserDto.getPhone());
		appUser.setPassword(appUserDto.getPassword());
		return appUserService.addUser(appUser);
	}
}

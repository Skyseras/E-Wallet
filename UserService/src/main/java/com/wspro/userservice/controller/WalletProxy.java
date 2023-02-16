package com.wspro.userservice.controller;

import com.wspro.userservice.Dto.ResponseDto;
import com.wspro.userservice.Dto.WalletDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
@FeignClient(name = "WalletService",url = "http://localhost:8383")
public interface WalletProxy {
    @PostMapping("/api/wallet/add")
    ResponseDto addWallet(@RequestBody WalletDto walletdto);
}

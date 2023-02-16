package com.wspro.transactionservice.controller;

import com.wspro.transactionservice.Dto.WalletDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "WalletService",url = "http://localhost:8383")
public interface WalletProxy {
    @GetMapping("/api/wallet/reference/{ref}")
    WalletDto findWalletByRef(@PathVariable String ref);

    @PutMapping("/api/wallet/update")
    WalletDto updateWallet(@RequestBody WalletDto walletDto);
}

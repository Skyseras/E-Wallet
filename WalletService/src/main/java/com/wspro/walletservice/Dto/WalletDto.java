package com.wspro.walletservice.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class WalletDto implements Serializable {
    private String customerId;
    private Double balance;
    private String reference;
}

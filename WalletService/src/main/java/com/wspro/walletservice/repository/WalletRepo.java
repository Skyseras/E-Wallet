package com.wspro.walletservice.repository;


import com.wspro.walletservice.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WalletRepo extends JpaRepository<Wallet, Long> {
    Optional<Wallet> findByCustomerId(String cusId);
    Optional<Wallet> findByReference(String ref);
}

package com.pbl6.music.service;

import com.pbl6.music.dto.request.PurchaseRequest;
import com.pbl6.music.dto.response.PurchaseResponse;
import com.pbl6.music.entity.BalanceUpdateType;
import com.pbl6.music.entity.Wallet;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public interface WalletService {
    Optional<Wallet> getWalletById(Long id);

    Wallet updateWalletBalance(Long id, BigDecimal amount);
     PurchaseResponse purchaseMusic(PurchaseRequest request);



    void updateBalance(Long walletId, BigDecimal amount, BalanceUpdateType type);
}

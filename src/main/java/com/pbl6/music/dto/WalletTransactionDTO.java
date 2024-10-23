package com.pbl6.music.dto;

import com.pbl6.music.enums.TransactionType;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WalletTransactionDTO {
    private Long walletTransactionIdDTO;
    private Long walletIdDTO; // Chỉ lưu trữ ID của ví
    private Double amountDTO;
    private TransactionType transactionTypeDTO;
    private Date transactionDateDTO;
}

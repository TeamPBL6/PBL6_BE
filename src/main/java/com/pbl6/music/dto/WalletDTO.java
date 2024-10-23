package com.pbl6.music.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WalletDTO {
    private Long walletIdDTO;
    private Long userIdDTO; // chỉ lưu trữ ID của người dùng
    private Double balanceDTO;
    private Date updatedAtDTO;
}

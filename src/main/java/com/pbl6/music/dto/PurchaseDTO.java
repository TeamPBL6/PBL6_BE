package com.pbl6.music.dto;

import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PurchaseDTO {
    private Long purchaseIdDTO;
    private Long userIdDTO; // chỉ lưu trữ ID của người dùng
    private Long musicIdDTO; // chỉ lưu trữ ID của bản nhạc
    private Date purchaseDateDTO;
    private BigDecimal amountDTO;
}

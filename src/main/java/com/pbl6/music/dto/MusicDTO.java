package com.pbl6.music.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MusicDTO {
    private Long musicIdDTO;
    private String titleDTO;
    private String fullUrlDTO;
    private BigDecimal priceDTO;
    private boolean isPurchasedDTO;
    private Long categoryIdDTO; // chỉ lưu trữ ID của danh mục
}

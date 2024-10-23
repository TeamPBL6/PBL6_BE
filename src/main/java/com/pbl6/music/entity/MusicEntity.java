package com.pbl6.music.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "musics")
public class MusicEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "music_id", nullable = false, unique = true)
    private Long musicId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "full_url", nullable = false)
    private String fullUrl;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Column(name = "is_purchased", nullable = false)
    private boolean isPurchased;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity categoryEntity;

    @OneToOne(mappedBy = "musicEntity")
    private PurchaseEntity purchaseEntities;
}
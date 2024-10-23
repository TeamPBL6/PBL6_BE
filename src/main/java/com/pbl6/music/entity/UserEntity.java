package com.pbl6.music.entity;

import com.pbl6.music.enums.UserRole;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class UserEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // Tự động sinh UUID
    @Column(name = "user_id", nullable = false, unique = true)
    private UUID userId; // Thay đổi từ Long thành UUID

    @Column(name = "user_name", nullable = false, unique = true)
    private String userName; // Tên người dùng phải là duy nhất

    @Column(name = "email", nullable = false, unique = true)
    private String email; // Email cũng phải duy nhất

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "user_role", nullable = false)
    private UserRole userRole;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private WalletEntity wallet;

    @OneToMany(mappedBy = "buyer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<PurchaseEntity> purchases; // Liên kết với bảng Purchases

}

package com.pbl6.music.dto;

import com.pbl6.music.enums.UserRole;
import lombok.*;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
    private UUID userIdDTO;
    private String userNameDTO;
    private String emailDTO;
    private String fullNameDTO;
    private UserRole userRoleDTO;
    private String phoneNumberDTO;
    private Long walletIdDTO; // ID của ví
}


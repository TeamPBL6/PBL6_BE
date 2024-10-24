package com.pbl6.music.mapper;

//import com.pbl6.music.dto.request.UserRequestDTO;
//import com.pbl6.music.dto.response.UserResponseDTO;
import com.pbl6.music.dto.CategoryDTO;
import com.pbl6.music.dto.UserDTO;
import com.pbl6.music.entity.UserEntity;
import com.pbl6.music.enums.UserRole;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface UserMapper {

//    UserEntity toUserEntity(UserRequestDTO userRequestDTO);
//    UserResponseDTO toUserResponseDTO(UserEntity userEntity);

    @Mapping(source = "userId", target = "userIdDTO")
    @Mapping(source = "userName", target = "userNameDTO")
    @Mapping(source = "email", target = "emailDTO")
    @Mapping(source = "fullName", target = "fullNameDTO")
    @Mapping(source = "userRole", target = "userRoleDTO")
    @Mapping(source = "phoneNumber", target = "phoneNumberDTO")
    @Mapping(source = "wallet", target = "walletIdDTO")
    UserDTO toUserDTO(UserEntity user);

    UserEntity toUserEntity(UserDTO dto);
}

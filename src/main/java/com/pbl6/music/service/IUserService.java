package com.pbl6.music.service;

//import com.pbl6.music.dto.request.UserRequestDTO;
//import com.pbl6.music.dto.response.PageResponse;
//import com.pbl6.music.dto.response.UserResponseDTO;
import com.pbl6.music.dto.UserDTO;
import com.pbl6.music.dto.response.PageResponse;
import com.pbl6.music.entity.UserEntity;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public interface IUserService {

//    UserResponseDTO getUserById(UUID id);
//
//    UserResponseDTO addUser(UserRequestDTO request);
//
//    UserResponseDTO updateUser(UUID id, UserRequestDTO request);
//
//    void deleteUser(UUID id);
//
//    PageResponse<?> getAllUser(int page, int pageSize);

    PageResponse<?> getAllUser(int page, int pageSize);
    Optional<UserDTO> getUserById(UUID id);
    Optional<UserDTO> getUserByUsername(String username);
    UserEntity addUser(UserDTO userDTO);
    UserEntity updateUser(UserDTO userDTO);
    void deleteUser(UUID id);

}

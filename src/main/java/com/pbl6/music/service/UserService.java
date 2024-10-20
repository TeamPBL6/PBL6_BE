package com.pbl6.music.service;

import com.pbl6.music.dto.request.UserRequestDTO;
import com.pbl6.music.dto.response.PageResponse;
import com.pbl6.music.dto.response.UserResponseDTO;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface UserService {

    UserResponseDTO getUserById(UUID id);

    UserResponseDTO addUser(UserRequestDTO request);

    UserResponseDTO updateUser(UUID id, UserRequestDTO request);

    void deleteUser(UUID id);

    PageResponse<?> getAllUser(int page, int pageSize);
}

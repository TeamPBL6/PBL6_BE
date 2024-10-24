package com.pbl6.music.service.impl;

//import com.pbl6.music.dto.request.UserRequestDTO;
//import com.pbl6.music.dto.response.UserResponseDTO;

import com.pbl6.music.dto.UserDTO;
import com.pbl6.music.entity.UserEntity;
import com.pbl6.music.mapper.UserMapper;
import com.pbl6.music.repository.UserRepository;
import com.pbl6.music.service.IUserService;
import com.pbl6.music.dto.response.PageResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserServiceImpl implements IUserService {

    UserRepository userRepository;
    UserMapper userMapper;

//    public UserResponseDTO getUserById(UUID id) {
//        UserEntity user = userRepository.findUserById(id).orElseThrow(() -> new ApiException(ErrorCode.USER_NOT_FOUND));
//        return userMapper.toUserResponseDTO(user);
//    }
//
//    public UserResponseDTO addUser(UserRequestDTO request) {
//        UserEntity user = userMapper.toUserEntity(request);
//        user.setIsDeleted(false);
//        user = userRepository.save(user);
//        return userMapper.toUserResponseDTO(user);
//    }
//
//    public UserResponseDTO updateUser(UUID id, UserRequestDTO request) {
//        userRepository.findById(id).orElseThrow(() -> new ApiException(ErrorCode.USER_NOT_FOUND));
//        var userMap = userMapper.toUserEntity(request);
//        userMap.setId(id);
//        return userMapper.toUserResponseDTO(userRepository.save(userMap));
//    }
//
//    public void deleteUser(UUID id) {
//        var user = userRepository.findById(id).orElseThrow(() -> new ApiException(ErrorCode.USER_NOT_FOUND));
//        user.setIsDeleted(true);
//        userRepository.save(user);
//    }
//
//    public PageResponse<?> getAllUser(int page, int pageSize) {
//
//        Pageable pageable = PageRequest.of(page > 0 ? page - 1 : 0, pageSize);
//        Page<UserResponseDTO> users = userRepository.findAllUser(pageable);
//
//        return PageResponse.builder()
//                .page(page)
//                .pageSize(pageSize)
//                .totalPage(users.getTotalPages())
//                .items(users.getContent())
//                .build();
//    }

    public PageResponse<?> getAllUser(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page > 0 ? page - 1 : 0, pageSize);
        Page<UserDTO> users = userRepository.findAllUser(pageable);
        return PageResponse.builder()
                .page(page)
                .pageSize(pageSize)
                .totalPage(users.getTotalPages())
                .items(users.getContent())
                .build();
    }

    public Optional<UserDTO> getUserById(UUID id) {
        Optional<UserEntity> userEntityOptional = userRepository.findById(id);
        return userEntityOptional.map(userMapper::toUserDTO);
    }

    public Optional<UserDTO> getUserByUsername(String username) {
        Optional<UserEntity> userEntityOptional = userRepository.findUserByUsername(username);
        return userEntityOptional.map(userMapper::toUserDTO);
    }

    @Override
    public UserEntity addUser(UserDTO userDTO) {
        return null;
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO) {
        return null;
    }

    @Override
    public void deleteUser(UUID id) {

    }


}

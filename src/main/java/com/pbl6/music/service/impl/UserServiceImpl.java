//package com.pbl6.music.service.impl;
//
//import com.pbl6.music.dto.request.UserRequestDTO;
//import com.pbl6.music.dto.response.UserResponseDTO;
//import com.pbl6.music.service.UserService;
//import com.pbl6.music.util.ErrorCode;
//import com.pbl6.music.dto.response.PageResponse;
//import com.pbl6.music.entity.UserEntity;
//import com.pbl6.music.util.AppException;
//import com.pbl6.music.mapper.UserMapper;
//import com.pbl6.music.repository.UserRepository;
//import lombok.AccessLevel;
//import lombok.RequiredArgsConstructor;
//import lombok.experimental.FieldDefaults;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Service;
//
//import java.util.UUID;
//
//@Service
//@RequiredArgsConstructor
//@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
//public class UserServiceImpl implements UserService {
//
//    UserRepository userRepository;
//    UserMapper userMapper;
//
//    @Override
//    public UserResponseDTO getUserById(UUID id) {
//        UserEntity user = userRepository.findUserById(id).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND));
//        return userMapper.toUserResponseDTO(user);
//    }
//
//    @Override
//    public UserResponseDTO addUser(UserRequestDTO request) {
//        UserEntity user = userMapper.toUserEntity(request);
//        user.setIsDeleted(false);
//        user = userRepository.save(user);
//        return userMapper.toUserResponseDTO(user);
//    }
//
//    @Override
//    public UserResponseDTO updateUser(UUID id, UserRequestDTO request) {
//        userRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND));
//        var userMap = userMapper.toUserEntity(request);
//        userMap.setId(id);
//        return userMapper.toUserResponseDTO(userRepository.save(userMap));
//    }
//
//    @Override
//    public void deleteUser(UUID id) {
//        var user = userRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND));
//        user.setIsDeleted(true);
//        userRepository.save(user);
//    }
//
//    @Override
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
//}

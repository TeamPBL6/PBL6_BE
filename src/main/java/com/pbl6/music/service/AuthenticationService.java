package com.pbl6.music.service;

import com.pbl6.music.dto.request.LoginRequestDTO;
import com.pbl6.music.dto.request.UserRegisterRequest;
import com.pbl6.music.dto.response.AuthenticationResponse;
import com.pbl6.music.entity.UserEntity;
import com.pbl6.music.mapper.UserMapper;
import com.pbl6.music.repository.UserRepository;
import com.pbl6.music.util.AppException;
import com.pbl6.music.util.ErrorCode;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@Transactional
public class AuthenticationService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Autowired
    public AuthenticationService(
            UserRepository userRepository,
            UserMapper userMapper,
            PasswordEncoder passwordEncoder,
            JwtService jwtService,
            AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    public AuthenticationResponse register(UserRegisterRequest request) {
        // Check if username exists
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new RuntimeException("Username already exists");
        }

        // Check if email exists
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        UserEntity user = userMapper.toEntity(request);
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        user = userRepository.save(user);

        String token = jwtService.generateToken(loadUserDetails(user));

        return AuthenticationResponse.builder()
                .token(token)
                .user(userMapper.toDTO(user))
                .build();
    }

    public AuthenticationResponse login(LoginRequestDTO request) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getUsername(),
                            request.getPassword()
                    )
            );
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username or password");
        }

        UserEntity user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));

        String token = jwtService.generateToken(loadUserDetails(user));

        return AuthenticationResponse.builder()
                .token(token)
                .user(userMapper.toDTO(user))
                .build();
    }

    private UserDetails loadUserDetails(UserEntity user) {
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                Collections.singleton(new SimpleGrantedAuthority(user.getRole()))
        );
    }
}
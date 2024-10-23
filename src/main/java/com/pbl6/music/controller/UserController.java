//package com.pbl6.music.controller;
//
//import com.pbl6.music.dto.request.UserRequestDTO;
//import com.pbl6.music.service.IUserService;
//import com.pbl6.music.exception.ErrorCode;
//import com.pbl6.music.util.ResponseData;
//import jakarta.validation.Valid;
//import lombok.AccessLevel;
//import lombok.RequiredArgsConstructor;
//import lombok.experimental.FieldDefaults;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.UUID;
//
//@RestController
//@RequiredArgsConstructor
//@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
//@RequestMapping("/api/v1/users")
//public class UserController {
//
//    IUserService userService;
//
//    @GetMapping
//    public ResponseData<?> getAllUser(@RequestParam(required = false, defaultValue = "1") int page,
//                                      @RequestParam(required = false, defaultValue = "10") int pageSize) {
//        return ResponseData.builder()
//                .status(HttpStatus.OK.value())
//                .code(ErrorCode.GET_SUCCESSFUL.getCode())
//                .message(ErrorCode.GET_SUCCESSFUL.getMessage())
//                .data(userService.getAllUser(page, pageSize))
//                .build();
//    }
//
//    @GetMapping("/{id}")
//    public ResponseData<?> getUserById(@PathVariable UUID id) {
//        return ResponseData.builder()
//                .status(HttpStatus.OK.value())
//                .code(ErrorCode.GET_SUCCESSFUL.getCode())
//                .message(ErrorCode.GET_SUCCESSFUL.getMessage())
//                .data(userService.getUserById(id))
//                .build();
//    }
//
//    @PostMapping
//    public ResponseData<?> addUser(@RequestBody @Valid UserRequestDTO request) {
//        return ResponseData.builder()
//                .status(HttpStatus.OK.value())
//                .code(ErrorCode.ADD_SUCCESSFUL.getCode())
//                .message(ErrorCode.ADD_SUCCESSFUL.getMessage())
//                .data(userService.addUser(request))
//                .build();
//    }
//
//    @PatchMapping
//    public ResponseData<?> updateUser(@RequestParam UUID id, @RequestBody UserRequestDTO request) {
//        return ResponseData.builder()
//                .status(HttpStatus.OK.value())
//                .code(ErrorCode.UPDATE_SUCCESSFUL.getCode())
//                .message(ErrorCode.UPDATE_SUCCESSFUL.getMessage())
//                .data(userService.updateUser(id, request))
//                .build();
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseData<?> deleteUser(@PathVariable UUID id) {
//        userService.deleteUser(id);
//        return ResponseData.builder()
//                .status(HttpStatus.OK.value())
//                .code(ErrorCode.DELETE_SUCCESSFUL.getCode())
//                .message(ErrorCode.DELETE_SUCCESSFUL.getMessage())
//                .message("Delete user success")
//                .build();
//    }
//
//}

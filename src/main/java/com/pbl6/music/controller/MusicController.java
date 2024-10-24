package com.pbl6.music.controller;

import com.pbl6.music.service.MusicService;
import com.pbl6.music.util.ErrorCode;
import com.pbl6.music.util.ResponseData;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@CrossOrigin(origins = "*")
@RequestMapping("/api/musics")
public class MusicController {
    MusicService musicService;

    @GetMapping
    public ResponseData<?> getAllMusic(@RequestParam(required = false, defaultValue = "1") int page,
                                      @RequestParam(required = false, defaultValue = "10") int pageSize) {
        return ResponseData.builder()
                .status(HttpStatus.OK.value())
                .code(ErrorCode.GET_SUCCESSFUL.getCode())
                .message(ErrorCode.GET_SUCCESSFUL.getMessage())
                .data(musicService.getAll(page, pageSize))
                .build();
    }
    @GetMapping("/{id}")
    public ResponseData<?> getById(@PathVariable Long id) {
        return ResponseData.builder()
                .status(HttpStatus.OK.value())
                .code(ErrorCode.GET_SUCCESSFUL.getCode())
                .message(ErrorCode.GET_SUCCESSFUL.getMessage())
                .data(musicService.getById(id))
                .build();
    }
}

package com.pbl6.music.controller;

import com.pbl6.music.service.MusicService;
import com.pbl6.music.util.ErrorCode;
import com.pbl6.music.util.ResponseData;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@CrossOrigin(origins = "*")
@RequestMapping("/api/musics")
public class MusicController {
    MusicService musicService;
    ResourceLoader resourceLoader;

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
    @GetMapping("/download/{filename:.+}")
    public ResponseEntity<Resource> getMusic(@PathVariable String filename) {
        String filePath = "file:///D:/resfull/PBL6/PBL6_BE/src/main/resources/Music/" + filename + ".mp3";
        Resource resource = resourceLoader.getResource(filePath);

        if (!resource.exists()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        return ResponseEntity.ok()
                .header(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "*")
                .header(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS, "GET")
                .header(HttpHeaders.ACCESS_CONTROL_MAX_AGE, "3600")
                .header(HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS, "*")
                .header("Content-Disposition", "attachment; filename=\"" + filename + ".mp3\"")
                .contentType(MediaType.parseMediaType("audio/mpeg"))
                .body(resource);
    }

}

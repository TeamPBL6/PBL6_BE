package com.pbl6.music.util;

import com.pbl6.music.dto.APIResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class JsonResponse {
    public static <T> ResponseEntity<APIResponse<T>> ok(T data){
        return ResponseEntity.ok(APIResponse.<T>builder().data(data).build());
    }
    public static <T> ResponseEntity<APIResponse<T>> create(T data){
        return ResponseEntity.status(HttpStatus.CREATED).body(APIResponse.<T>builder().data(data).build());
    }

}

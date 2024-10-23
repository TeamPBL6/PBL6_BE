package com.pbl6.music.exception;

import com.pbl6.music.dto.APIResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandleException {
    @ExceptionHandler(ApiException.class)
    public ResponseEntity<?> handlingApiException(ApiException apiException){
        ErrorCode errorCode = apiException.getErrorCode();
        return ResponseEntity.status(errorCode.getStatusCode()).body(APIResponse.builder()
                       .code(errorCode.getCode())
                     .message(errorCode.getMessage())
                     .build());
    }

}

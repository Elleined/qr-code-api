package com.elleined.qrcodeapi.controller;

import com.elleined.qrcodeapi.dto.ApiResponse;
import com.elleined.qrcodeapi.exception.data.DataException;
import com.elleined.qrcodeapi.exception.path.PathException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler({
            DataException.class,
            PathException.class
    })
    public ResponseEntity<ApiResponse> handleNotFoundException(RuntimeException ex) {
        var responseMessage = new ApiResponse(HttpStatus.BAD_REQUEST, ex.getMessage());
        return new ResponseEntity<>(responseMessage, HttpStatus.BAD_REQUEST);
    }
}

package com.elleined.qrcodeapi.controller;

import com.elleined.qrcodeapi.dto.APIResponse;
import com.elleined.qrcodeapi.exception.data.DataException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler({
            DataException.class
    })
    public ResponseEntity<APIResponse> handleNotFoundException(DataException ex) {
        var responseMessage = new APIResponse(HttpStatus.BAD_REQUEST, ex.getMessage());
        return new ResponseEntity<>(responseMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BindException.class)
    public ResponseEntity<List<APIResponse>> handleBindException(BindException ex) {
        List<APIResponse> errors = ex.getBindingResult().getAllErrors().stream()
                .map(ObjectError::getDefaultMessage)
                .map(errorMessage -> new APIResponse(HttpStatus.BAD_REQUEST, errorMessage))
                .toList();
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}

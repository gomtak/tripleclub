package com.tripleclub.controller;

import com.tripleclub.dto.ErrorResponse;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalController {
    @ExceptionHandler(ChangeSetPersister.NotFoundException.class)
    public ResponseEntity<ErrorResponse> notFoundException(Exception e) {
        return new ResponseEntity<>(
                ErrorResponse.builder()
                        .errorMessage(e.getMessage())
                        .build(),
                HttpStatus.NOT_FOUND
        );
    }
}

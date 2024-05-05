package com.home_rent.home_rent_management_system.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundExceptionHandler.class)
    public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(
            ResourceNotFoundExceptionHandler resourceNotFoundExceptionHandler) {
        String message = resourceNotFoundExceptionHandler.getMessage();
        ApiResponse apiResponse = new ApiResponse(message, false);
        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
    }
}

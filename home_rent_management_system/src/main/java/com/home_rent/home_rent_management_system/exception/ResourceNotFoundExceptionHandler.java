package com.home_rent.home_rent_management_system.exception;

public class ResourceNotFoundExceptionHandler extends RuntimeException {

    String message;
    public ResourceNotFoundExceptionHandler(String message) {
        super(message);
        this.message = message;
    }
}

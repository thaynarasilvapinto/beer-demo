package com.example.demo.commons.exceptions;

import org.springframework.http.HttpStatus;

public class BusinessException extends RuntimeException{

    private final HttpStatus status;

    public BusinessException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
}

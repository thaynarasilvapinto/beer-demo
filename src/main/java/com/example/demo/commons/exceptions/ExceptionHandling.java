package com.example.demo.commons.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ExceptionHandling {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorResponse> handleError(BusinessException businessException) {

        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage(businessException.getMessage());

        return new ResponseEntity<>(errorResponse, businessException.getStatus());
    }

}

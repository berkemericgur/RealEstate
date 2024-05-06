package com.bmg.userservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    @ExceptionHandler(BusinessException.class)
    public BusinessProblemDetails businessExceptionHandler(BusinessException businessException) {

        BusinessProblemDetails businessProblemDetails = new BusinessProblemDetails();
        businessProblemDetails.setDetail(businessException.getMessage());

        return businessProblemDetails;
    }
}

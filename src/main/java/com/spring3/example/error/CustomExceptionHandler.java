package com.spring3.example.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Snehasis Mondal
 */
@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ProblemDetail onRuntimeException(RuntimeException e){
        ProblemDetail detail= ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST,e.getMessage());
        return detail;
    }
}

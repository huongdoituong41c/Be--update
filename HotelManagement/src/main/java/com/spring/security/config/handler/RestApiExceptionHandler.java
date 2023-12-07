package com.spring.security.config.handler;

import com.spring.security.dto.ErrorExceptionDto;
import com.spring.security.exception.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Objects;

@ControllerAdvice("com.spring.security.controller")
public class RestApiExceptionHandler {

    @ResponseBody
    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorExceptionDto> badRequestException(BadRequestException ex){
        ErrorExceptionDto errorExceptionDto =  Objects.nonNull(ex.getErrorObject()) ? ex.getErrorObject() : new ErrorExceptionDto("ER01", "An unknown error");

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(
                        errorExceptionDto
                );

    }
}

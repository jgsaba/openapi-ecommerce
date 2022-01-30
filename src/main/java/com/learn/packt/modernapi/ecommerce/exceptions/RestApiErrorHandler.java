package com.learn.packt.modernapi.ecommerce.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

import static com.learn.packt.modernapi.ecommerce.exceptions.ErrorCode.*;
import static com.learn.packt.modernapi.ecommerce.exceptions.ErrorUtils.createError;
import static org.springframework.http.HttpStatus.*;

@Slf4j
@RestControllerAdvice
public class RestApiErrorHandler {

    @ResponseStatus(INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public Error handleException(HttpServletRequest request, Exception ex) {
        ex.printStackTrace(); // TODO: Should be kept only for development
        return createError(GENERIC_ERROR, INTERNAL_SERVER_ERROR, request);
    }

}

package com.learn.packt.modernapi.ecommerce.exceptions;

import com.fasterxml.jackson.core.JsonParseException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

import static com.learn.packt.modernapi.ecommerce.exceptions.ErrorCode.*;
import static com.learn.packt.modernapi.ecommerce.exceptions.ErrorUtils.createError;
import static org.springframework.http.HttpStatus.NOT_ACCEPTABLE;
import static org.springframework.http.HttpStatus.UNSUPPORTED_MEDIA_TYPE;

@Slf4j
@RestControllerAdvice
public class HttpErrorHandler {

    @ResponseStatus(UNSUPPORTED_MEDIA_TYPE)
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public Error handleHttpMediaTypeNotSupportedException(HttpServletRequest request, Exception ex) {
        ex.printStackTrace(); // TODO: Should be kept only for development
        return createError(HTTP_MEDIATYPE_NOT_SUPPORTED, UNSUPPORTED_MEDIA_TYPE, request);
    }

    @ResponseStatus(UNSUPPORTED_MEDIA_TYPE)
    @ExceptionHandler(HttpMessageNotWritableException.class)
    public Error handleHttpMessageNotWritableException(HttpServletRequest request, Exception ex) {
        ex.printStackTrace(); // TODO: Should be kept only for development
        return createError(HTTP_MESSAGE_NOT_WRITABLE, UNSUPPORTED_MEDIA_TYPE, request);
    }

    @ResponseStatus(UNSUPPORTED_MEDIA_TYPE)
    @ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
    public Error handleHttpMediaTypeNotAcceptableException(HttpServletRequest request, Exception ex) {
        ex.printStackTrace(); // TODO: Should be kept only for development
        return createError(HTTP_MEDIA_TYPE_NOT_ACCEPTABLE, UNSUPPORTED_MEDIA_TYPE, request);
    }

    @ResponseStatus(UNSUPPORTED_MEDIA_TYPE)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Error handleHttpMessageNotReadableException(HttpServletRequest request, Exception ex) {
        ex.printStackTrace(); // TODO: Should be kept only for development
        return createError(HTTP_MESSAGE_NOT_READABLE, NOT_ACCEPTABLE, request);
    }

    @ResponseStatus(UNSUPPORTED_MEDIA_TYPE)
    @ExceptionHandler(JsonParseException.class)
    public Error handleJsonParseException(HttpServletRequest request, Exception ex) {
        ex.printStackTrace(); // TODO: Should be kept only for development
        return createError(JSON_PARSE_ERROR, NOT_ACCEPTABLE, request);
    }
}

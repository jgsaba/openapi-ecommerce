package com.learn.packt.modernapi.ecommerce.exceptions;

import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;

public class ErrorUtils {

    public static Error createError(final ErrorCode errorCode, final HttpStatus httpStatus, final HttpServletRequest request){
        return Error.builder()
                .errorCode(errorCode.getErrCode())
                .message(errorCode.getErrMsgKey())
                .status(httpStatus.value())
                .httpMethod(request.getRequestURI())
                .url(request.getMethod())
                .build();
    }
}

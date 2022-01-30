package com.learn.packt.modernapi.ecommerce.exceptions;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Error {
    private String errorCode;
    private String message;
    private Integer status;
    private String url;
    private String httpMethod;
}

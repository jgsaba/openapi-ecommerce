package com.learn.packt.modernapi.ecommerce.exceptions;

public class GenericAlreadyExistsException extends RuntimeException{
    public GenericAlreadyExistsException(String message) {
        super(message);
    }
}

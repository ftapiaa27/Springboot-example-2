package com.amigoscode.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class CannotCreateCustomerException extends RuntimeException{
    public CannotCreateCustomerException(String message){
        super(message);
    }
}

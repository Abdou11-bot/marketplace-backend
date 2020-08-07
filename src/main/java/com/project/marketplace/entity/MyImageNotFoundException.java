package com.project.marketplace.entity;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MyImageNotFoundException extends RuntimeException {
    public MyImageNotFoundException(String message) {
        super(message);
    }

    public MyImageNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}

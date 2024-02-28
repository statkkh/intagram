package com.clone.instagram.handler;

public class CustomApiException extends RuntimeException{

    public CustomApiException(String message) {
        super(message);
    }    
}

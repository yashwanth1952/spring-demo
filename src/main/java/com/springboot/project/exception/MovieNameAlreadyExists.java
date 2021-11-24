package com.springboot.project.exception;

public class MovieNameAlreadyExists extends RuntimeException{
    public MovieNameAlreadyExists(String message) {
        super(message);
    }

    public MovieNameAlreadyExists(String message, Throwable cause) {
        super(message, cause);
    }

    public MovieNameAlreadyExists(Throwable cause) {
        super(cause);
    }
}

package com.springboot.project.exception;

public class PlatformNameAlreadyExists extends RuntimeException{
    public PlatformNameAlreadyExists(String message) {
        super(message);
    }

    public PlatformNameAlreadyExists(String message, Throwable cause) {
        super(message, cause);
    }

    public PlatformNameAlreadyExists(Throwable cause) {
        super(cause);
    }
}

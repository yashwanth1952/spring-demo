package com.springboot.project.exception;

public class PlatformNotFoundException extends RuntimeException{
    public PlatformNotFoundException(String message) {
        super(message);
    }

    public PlatformNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public PlatformNotFoundException(Throwable cause) {
        super(cause);
    }
}

package com.aleksandrmishin.exception;

public class IncorrectInputStringException extends Exception{
    public IncorrectInputStringException() {
        super();
    }

    public IncorrectInputStringException(String message) {
        super(message);
    }

    public IncorrectInputStringException(String message, Throwable cause) {
        super(message, cause);
    }

    public IncorrectInputStringException(Throwable cause) {
        super(cause);
    }

    protected IncorrectInputStringException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

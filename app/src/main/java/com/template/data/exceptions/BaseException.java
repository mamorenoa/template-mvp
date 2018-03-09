package com.template.data.exceptions;

public class BaseException extends Exception {

    public BaseException() {
        super();
    }

    public BaseException(final String message) {
        super(message);
    }

    public BaseException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public BaseException(final Throwable cause) {
        super(cause);
    }
}

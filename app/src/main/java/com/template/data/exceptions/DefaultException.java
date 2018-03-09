package com.template.data.exceptions;

public class DefaultException extends BaseException {

    public DefaultException() {
        super();
    }

    public DefaultException(final String message) {
        super(message);
    }

    public DefaultException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public DefaultException(final Throwable cause) {
        super(cause);
    }
}


package com.template.data.exceptions;

public class ConnectionException extends BaseException {

    public ConnectionException() {
        super();
    }

    public ConnectionException(final String message) {
        super(message);
    }

    public ConnectionException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public ConnectionException(final Throwable cause) {
        super(cause);
    }
}


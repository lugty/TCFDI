package com.tscfdi.keys;

/**
 * Created by lugty on 22/08/16.
 */
public class KeyException extends RuntimeException {

    public KeyException() {
        super();
    }

    public KeyException(String message) {
        super(message);
    }

    public KeyException(String message, Throwable cause) {
        super(message, cause);
    }

    public KeyException(Throwable cause) {
        super(cause);
    }
}
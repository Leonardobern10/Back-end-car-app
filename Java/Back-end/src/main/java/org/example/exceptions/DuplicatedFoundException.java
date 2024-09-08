package org.example.exceptions;

public class DuplicatedFoundException extends RuntimeException {
    public DuplicatedFoundException (String message) {
        super(message);
    }
}

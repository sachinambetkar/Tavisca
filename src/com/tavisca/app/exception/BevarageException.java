package com.tavisca.app.exception;

public class BevarageException extends RuntimeException {

    // thrown when all the ingredients are excluded from an item in order
    public BevarageException (String errorMessage) {
        super(errorMessage);
    }
}

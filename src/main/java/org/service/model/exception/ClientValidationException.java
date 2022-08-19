package org.service.model.exception;

public class ClientValidationException extends Exception {

    public ClientValidationException(String field) {
        super(String.format("Field %s cannot be empty", field));
    }
}

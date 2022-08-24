package org.service.repository.exception;

import static java.lang.String.format;

public class ClientIdException extends Exception {
    public ClientIdException(int clientId) {
        super(format("Client with id %d does not exists", clientId));
    }
}

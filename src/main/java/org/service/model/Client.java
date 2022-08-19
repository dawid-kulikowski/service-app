package org.service.model;

import org.service.model.exception.ClientValidationException;

public class Client {
    private String name;
    private String surname;
    private String phoneNumber;
    private String secondPhoneNumber;
    private String email;

    public Client(String name, String surname, String phoneNumber, String secondPhoneNumber, String email)
            throws ClientValidationException {
        this.name = validate( "name", name);
        this.surname = validate("surname", surname);
        this.phoneNumber = validate("phoneNumber", phoneNumber);
        this.secondPhoneNumber = secondPhoneNumber;
        this.email = email;
    }

    private static String validate(String fieldName, String value) throws ClientValidationException {
        if (value == null || value.isBlank()) {
            throw new ClientValidationException(fieldName);
        }
        return value;
    }
}

package org.service.model;

import org.service.model.exception.ClientValidationException;

public class Client {
    private int clientId;
    private String name;
    private String surname;
    private String phoneNumber;
    private String secondPhoneNumber;
    private String email;

    public Client() {
    }

    public Client(String name, String surname, String phoneNumber, String secondPhoneNumber, String email)
            throws ClientValidationException {
        this.name = validate( "name", name);
        this.surname = validate("surname", surname);
        this.phoneNumber = validate("phoneNumber", phoneNumber);
        this.secondPhoneNumber = secondPhoneNumber;
        this.email = email;
    }

    public Client(int clientId,
                  String name,
                  String surname,
                  String phoneNumber,
                  String secondPhoneNumber,
                  String email)
            throws ClientValidationException {
        this(name, surname, phoneNumber, secondPhoneNumber, email);
        this.clientId = clientId;
    }

    private static String validate(String fieldName, String value) throws ClientValidationException {
        if (value == null || value.isBlank()) {
            throw new ClientValidationException(fieldName);
        }
        return value;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getSecondPhoneNumber() {
        return secondPhoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public Integer getClientId() {
        return clientId;
    }
}

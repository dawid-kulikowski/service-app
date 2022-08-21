package org.service.repository;

import org.service.model.Client;
import org.service.model.exception.ClientValidationException;

public class ClientEntity {
    private int clientId;
    private String name;
    private String surname;
    private String phoneNumber;
    private String secondPhoneNumber;
    private String email;

    public ClientEntity(int clientId,
                        String name,
                        String surname,
                        String phoneNumber,
                        String secondPhoneNumber,
                        String email) {
        this.clientId = clientId;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.secondPhoneNumber = secondPhoneNumber;
        this.email = email;
    }

    public Client createClient() {
        try {
            return new Client(this.clientId,
                    this.name,
                    this.surname,
                    this.phoneNumber,
                    this.secondPhoneNumber,
                    this.email);
        } catch (ClientValidationException e) {
            throw new RuntimeException(e);
        }
    }

    private int getClientId() {
        return clientId;
    }

    private void setClientId(int clientId) {
        this.clientId = clientId;
    }

    private String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    private String getSurname() {
        return surname;
    }

    private void setSurname(String surname) {
        this.surname = surname;
    }

    private String getPhoneNumber() {
        return phoneNumber;
    }

    private void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    private String getSecondPhoneNumber() {
        return secondPhoneNumber;
    }

    private void setSecondPhoneNumber(String secondPhoneNumber) {
        this.secondPhoneNumber = secondPhoneNumber;
    }

    private String getEmail() {
        return email;
    }

    private void setEmail(String email) {
        this.email = email;
    }
}

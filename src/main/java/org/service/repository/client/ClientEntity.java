package org.service.repository.client;

import org.service.model.Client;
import org.service.model.exception.ClientValidationException;

public class ClientEntity {
    private int clientId;
    private String name;
    private String surname;
    private String phoneNumber;
    private String secondPhoneNumber;
    private String email;

    public ClientEntity() {
    }

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

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSecondPhoneNumber() {
        return secondPhoneNumber;
    }

    public void setSecondPhoneNumber(String secondPhoneNumber) {
        this.secondPhoneNumber = secondPhoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

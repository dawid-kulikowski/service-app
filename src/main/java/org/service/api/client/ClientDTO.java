package org.service.api.client;

import org.service.model.Client;
import org.service.model.exception.ClientValidationException;

public class ClientDTO {
    private String name;
    private String surname;
    private String phoneNumber;
    private String secondPhoneNumber;
    private String email;

    public ClientDTO() {
    }

    public ClientDTO(String name, String surname, String phoneNumber, String secondPhoneNumber, String email) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.secondPhoneNumber = secondPhoneNumber;
        this.email = email;
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

    public Client createClient() throws ClientValidationException {
        return new Client(this.name, this.surname, this.phoneNumber, this.secondPhoneNumber, this.email);
    }

    @Override
    public String toString() {
        return "ClientDTO{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", secondPhoneNumber='" + secondPhoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

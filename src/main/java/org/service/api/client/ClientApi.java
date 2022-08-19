package org.service.api;


import org.service.model.Client;

public interface ClientApi {
    void addClient(Client client);
    void updateClient(Client client);
}

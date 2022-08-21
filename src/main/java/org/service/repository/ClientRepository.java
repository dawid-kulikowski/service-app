package org.service.repository;

import org.service.model.Client;

import java.util.List;

public interface ClientRepository {

    void addClient(Client client);

    void updateClient(Client client);

    List<Client> getAllClients();

}

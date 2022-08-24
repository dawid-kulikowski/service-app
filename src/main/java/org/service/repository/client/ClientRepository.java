package org.service.repository.client;

import org.service.model.Client;
import org.service.repository.exception.ClientIdException;

import java.util.List;

public interface ClientRepository {

    void addClient(Client client);

    void updateClient(Client client);

    Client getClientById(Integer clientId) throws ClientIdException;

    List<Client> getAllClients();
}

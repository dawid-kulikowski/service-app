package org.service.api.client;


import org.service.model.Client;

import java.util.List;

public interface ClientApi {
    void addClient(Client client);
    List<Client> getAllClients();
}

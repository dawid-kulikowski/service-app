package org.service.api.client;


import org.service.model.Client;

import java.util.List;

public interface ClientApi {
    Integer addClient(Client client);
    List<Client> getAllClients();
}

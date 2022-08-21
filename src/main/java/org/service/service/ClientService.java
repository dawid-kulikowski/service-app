package org.service.service;

import org.service.model.Client;
import org.service.repository.DatabaseClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    private DatabaseClientRepository databaseClientRepository;

    public ClientService(DatabaseClientRepository databaseClientRepository) {
        this.databaseClientRepository = databaseClientRepository;
    }

    public void addClient(Client client) {
        databaseClientRepository.addClient(client);
    }

    public List<Client> getAllClients() {
        return databaseClientRepository.getAllClients();
    }
}

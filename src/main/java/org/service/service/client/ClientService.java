package org.service.service.client;

import org.service.model.Client;
import org.service.repository.client.DatabaseClientRepository;
import org.service.repository.exception.ClientIdException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    private final DatabaseClientRepository databaseClientRepository;

    public ClientService(DatabaseClientRepository databaseClientRepository) {
        this.databaseClientRepository = databaseClientRepository;
    }

    public void addClient(Client client) {
        databaseClientRepository.addClient(client);
    }

    public List<Client> getAllClients() {
        return databaseClientRepository.getAllClients();
    }

    public Client getClientById(Integer clientId) throws ClientIdException {
        return databaseClientRepository.getClientById(clientId);
    }
}

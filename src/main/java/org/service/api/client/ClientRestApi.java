package org.service.api.client;

import org.service.model.Client;
import org.service.model.exception.ClientValidationException;
import org.service.service.client.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientRestApi implements ClientApi {

    private final ClientService clientService;

    public ClientRestApi(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public ResponseEntity<String> addClient(@RequestBody ClientDTO clientDTO) {
        String clientId;

        try {
            clientId = Integer.toString(addClient(clientDTO.createClient()));
        } catch (ClientValidationException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok(clientId);
    }

    @GetMapping
    public ResponseEntity<List<Client>> getClients() {
        return ResponseEntity.ok(getAllClients());
    }

    @Override
    public Integer addClient(Client client) {
        return clientService.addClient(client);
    }

    @Override
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }
}

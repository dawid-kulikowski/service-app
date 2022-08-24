package org.service.api.client;

import org.service.model.Client;
import org.service.model.exception.ClientValidationException;
import org.service.service.client.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientRestApi implements ClientApi {

    private ClientService clientService;

    public ClientRestApi(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public ResponseEntity<String> addClient(@RequestBody ClientDTO clientDTO) {
        try {
            addClient(clientDTO.createClient());
        } catch (ClientValidationException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Client>> getClients() {
        return ResponseEntity.ok(getAllClients());
    }

    @Override
    public void addClient(Client client) {
        clientService.addClient(client);
    }

    @Override
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }
}

package org.service.api;

import org.service.model.Client;
import org.service.model.exception.ClientValidationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class ClientRestApi implements ClientApi {

    @PostMapping
    public ResponseEntity<String> addClient(@RequestBody ClientDTO clientDTO) {

        try {
            clientDTO.createClient();
        } catch (ClientValidationException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

        return ResponseEntity.ok().build();
    }

    @Override
    public void addClient(Client client) {

    }

    @Override
    public void updateClient(Client client) {

    }


}

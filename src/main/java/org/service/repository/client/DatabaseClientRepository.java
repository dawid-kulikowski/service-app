package org.service.repository.client;

import org.service.model.Client;
import org.service.repository.exception.ClientIdException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class DatabaseClientRepository implements ClientRepository {
    private static final String INSERT_CLIENT_SQL = """
            INSERT INTO client
            (name, surname, phone_number, second_phone_number, email)
            VALUES(?, ?, ?, ?, ?);
            """;

    private static final String GET_ALL_CLIENTS_SQL = """
            SELECT client_id, name, surname, phone_number, second_phone_number, email
            FROM client
            """;

    private static final String GET_CLIENT_BY_ID = """
            SELECT client_id, name, surname, phone_number, second_phone_number, email
            FROM client
            WHERE client_id = ?
            """;

    private final JdbcTemplate jdbcTemplate;

    public DatabaseClientRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void addClient(Client client) {
        jdbcTemplate.update(INSERT_CLIENT_SQL,
                client.getName(),
                client.getSurname(),
                client.getPhoneNumber(),
                client.getSecondPhoneNumber(),
                client.getEmail());
    }

    @Override
    public void updateClient(Client client) {

    }

    @Override
    public Client getClientById(Integer clientId) throws ClientIdException {

        ClientEntity clientEntity;

        try {
            clientEntity = jdbcTemplate
                    .queryForObject(GET_CLIENT_BY_ID,
                            new BeanPropertyRowMapper<>(ClientEntity.class),
                            clientId);
        } catch (DataAccessException ex) {
            throw new ClientIdException(clientId);
        }

        return clientEntity.createClient();
    }

    @Override
    public List<Client> getAllClients() {
        List<ClientEntity> clientEntities =
                jdbcTemplate.query(GET_ALL_CLIENTS_SQL, new BeanPropertyRowMapper<>(ClientEntity.class));

        return clientEntities.stream()
                .map(ClientEntity::createClient)
                .toList();
    }
}

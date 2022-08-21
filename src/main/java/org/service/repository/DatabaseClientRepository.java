package org.service.repository;

import org.service.model.Client;
import org.service.model.exception.ClientValidationException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

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
    private final JdbcTemplate jdbcTemplate;

    public DatabaseClientRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
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
    public List<Client> getAllClients() {
        List<ClientEntity> clientEntities =
                jdbcTemplate.query(GET_ALL_CLIENTS_SQL, new BeanPropertyRowMapper<>(ClientEntity.class));

        return clientEntities.stream()
                .map(ClientEntity::createClient)
                .toList();
    }
}

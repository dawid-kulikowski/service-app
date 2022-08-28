package org.service.repository.client;

import org.service.model.Client;
import org.service.repository.exception.ClientIdException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

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
    public static final String CLIENT_ID = "client_id";

    private final JdbcTemplate jdbcTemplate;

    public DatabaseClientRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Integer addClient(Client client) {
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CLIENT_SQL, RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, client.getName());
            preparedStatement.setString(2, client.getSurname());
            preparedStatement.setString(3, client.getPhoneNumber());
            preparedStatement.setString(4, client.getSecondPhoneNumber());
            preparedStatement.setString(5, client.getEmail());

            return preparedStatement;
        }, generatedKeyHolder);

        return (Integer) generatedKeyHolder.getKeyList().get(0).get(CLIENT_ID);
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

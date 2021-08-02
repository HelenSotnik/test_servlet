package com.hillel.dao;

import com.hillel.database.Database;
import com.hillel.entity.Client;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClientDao {
    private static final String SELECT_ALL = "SELECT * FROM clients";

    public List<Client> findAllClients() {
        List<Client> resultList = new ArrayList<>();
        try ( Connection connection = Database.getConnection();
              Statement statement = connection.createStatement();
              ResultSet rs = statement.executeQuery(SELECT_ALL) ) {

            while (rs.next()) {
                Client client = new Client();
                client.setId(rs.getInt("id"));
                client.setName(rs.getString("name"));
                client.setEmail(rs.getString("email"));
                client.setPhone(rs.getLong("phone"));
                client.setAbout(rs.getString("about"));
                client.setAge(rs.getInt("age"));
                resultList.add(client);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return resultList;
    }
}
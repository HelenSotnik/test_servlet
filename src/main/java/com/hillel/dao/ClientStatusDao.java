package com.hillel.dao;

import com.hillel.database.Database;
import com.hillel.entity.ClientStatus;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClientStatusDao {
    private static final String SELECT_QUERY = "SELECT *  FROM client_status";

    public List<ClientStatus> findNameEmailAlias() {
        List<ClientStatus> list = new ArrayList<>();
        try ( Connection connection = Database.getConnection();
              Statement statement = connection.createStatement();
              ResultSet resultSet = statement.executeQuery(SELECT_QUERY) ) {

            while (resultSet.next()) {
                ClientStatus cs = new ClientStatus();
                cs.setClientId(resultSet.getInt("client_id"));
                cs.setStatusId(resultSet.getInt("status_id"));
                list.add(cs);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return list;
    }
}

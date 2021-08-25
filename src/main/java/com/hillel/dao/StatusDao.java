package com.hillel.dao;

import com.hillel.database.Database;
import com.hillel.entity.Status;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StatusDao {
    private static final String SELECT_ALL = "SELECT * FROM statuses";

    public List<Status> findAllStatuses() {
        List<Status> resultList = new ArrayList<>();
        try ( Connection connection = Database.getConnection();
              Statement statement = connection.createStatement();
              ResultSet rs = statement.executeQuery(SELECT_ALL) ) {

            while (rs.next()) {
                Status status = new Status();
                status.setId(rs.getInt("id"));
                status.setAlias(rs.getString("alias"));
                status.setDescription(rs.getString("description"));
                resultList.add(status);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return resultList;
    }
}

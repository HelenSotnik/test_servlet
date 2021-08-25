package com.hillel.dao;

import com.hillel.database.Database;
import com.hillel.entity.Account;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AccountDao {
    private static final String SELECT_ALL = "SELECT * FROM accounts";

    public List<Account> findAllAccounts() {
        List<Account> resultList = new ArrayList<>();
        try ( Connection connection = Database.getConnection();
              Statement statement = connection.createStatement();
              ResultSet rs = statement.executeQuery(SELECT_ALL) ) {
            while (rs.next()) {
                Account account = new Account();
                account.setId(rs.getInt("id"));
                account.setClientId(rs.getInt("client_id"));
                account.setNumber(rs.getString("number"));
                account.setValue(rs.getDouble("value"));
                resultList.add(account);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return resultList;
    }
}

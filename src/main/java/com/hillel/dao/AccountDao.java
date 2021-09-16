package com.hillel.dao;

import com.hillel.dao.util.LogDaoMessageUtil;
import com.hillel.database.Database;
import com.hillel.entity.Account;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AccountDao {
    private static final String SELECT_ALL = "SELECT * FROM accounts";
    private static final Logger LOG = Logger.getLogger(AccountDao.class.getName());
    private static final String TABLE_NAME = "ACCOUNTS";

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
            LOG.info(LogDaoMessageUtil.getSuccessInfoMessage(TABLE_NAME));

        } catch (SQLException exception) {
            LOG.debug(LogDaoMessageUtil.getFailDebugMessage(TABLE_NAME));
        }
        return resultList;
    }
}

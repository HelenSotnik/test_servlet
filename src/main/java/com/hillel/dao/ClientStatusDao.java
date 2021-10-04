package com.hillel.dao;

import com.hillel.dao.util.LogDaoMessageUtil;
import com.hillel.database.Database;
import com.hillel.entity.ClientStatus;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClientStatusDao {
    private static final String SELECT_QUERY = "SELECT *  FROM client_status";
    private static final Logger LOG = Logger.getLogger(ClientStatusDao.class.getName());
    private static final String TABLE_NAME = "CLIENT_STATUS";

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
            LOG.info(LogDaoMessageUtil.getSuccessInfoMessage(TABLE_NAME));

        } catch (SQLException exception) {
            LOG.debug(LogDaoMessageUtil.getFailDebugMessage(TABLE_NAME));
        }
        return list;
    }
}

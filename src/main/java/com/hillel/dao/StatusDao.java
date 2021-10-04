package com.hillel.dao;

import com.hillel.dao.util.LogDaoMessageUtil;
import com.hillel.database.Database;
import com.hillel.entity.Status;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StatusDao {
    private static final String SELECT_ALL = "SELECT * FROM statuses";
    private static final Logger LOG = Logger.getLogger(StatusDao.class.getName());
    private static final String TABLE_NAME = "STATUSES";

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
            LOG.info(LogDaoMessageUtil.getSuccessInfoMessage(TABLE_NAME));

        } catch (SQLException exception) {
            LOG.debug(LogDaoMessageUtil.getFailDebugMessage(TABLE_NAME));
        }
        return resultList;
    }
}

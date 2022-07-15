package com.hillel.dao.util;

public class LogDaoMessageUtil {
    private static final String FAIL = "FAIL in ";
    private static final String SUCCESS = "SUCCESS in ";
    private static final String FIND_ALL = "Find All ";
    private static final String TABLE = "Table: ";


    public static String getFailDebugMessage(String tableName) {
        StringBuilder sb = new StringBuilder();
        sb.append(FAIL).append(FIND_ALL);
        sb.append(TABLE).append(tableName).append(".");
        return sb.toString();
    }

    public static String getSuccessInfoMessage(String tableName) {
        StringBuilder sb = new StringBuilder();
        sb.append(SUCCESS).append(FIND_ALL);
        sb.append(TABLE).append(tableName).append(".");
        return sb.toString();
    }
}

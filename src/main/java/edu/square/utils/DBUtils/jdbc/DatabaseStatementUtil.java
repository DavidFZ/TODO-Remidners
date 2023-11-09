package edu.square.utils.DBUtils.jdbc;

import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseStatementUtil {
    public static Statement getStatement() throws SQLException {
        return DatabaseConnectionUtil.getConnection().createStatement();
    }

}

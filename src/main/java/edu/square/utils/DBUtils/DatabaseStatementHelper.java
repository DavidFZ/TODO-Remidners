package edu.square.utils.DBUtils;

import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseStatementHelper {
    private static Statement getStatement() throws SQLException {
        return DatabaseConnectionHelper.getConnection().createStatement();
    }

    public static void executeSQL(String s) {
        try {
            Statement statement = getStatement();
            statement.execute(s);
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

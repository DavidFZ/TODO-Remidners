package edu.square.utils.DBUtils;

import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseStatementUtil {
    public static Statement getStatement() throws SQLException {
        return DatabaseConnectionUtil.getConnection().createStatement();
    }


//    public static void executeSQL(String s) {
//        try {
//            Statement statement = getStatement();
//            statement.execute(s);
//            statement.close();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
}

package edu.square.utils.DBUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DerbyStarter extends Thread {
    private static final String DB_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String DB_URL_PREFIX = "jdbc:derby:";
    private static final String DB_URL_DEFAULT_PATH = "derbyDB;";
    private static final String DB_CREATE = "create=true";

    private static String createDefaultDBURL() {
        return DB_URL_PREFIX + DB_URL_DEFAULT_PATH + DB_CREATE;
    }

    private static String getDefaultDBURL() {
        return DB_URL_PREFIX + DB_URL_DEFAULT_PATH;
    }


    public static void main(String[] args) {
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            Connection conn = DriverManager.getConnection("jdbc:derby:derbyDB");
            Statement statement = conn.createStatement();

            statement.execute("USE ADMIN;\n" +
                    "INSERT INTO TEST VALUES (1, 'Hello')");

            statement.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}

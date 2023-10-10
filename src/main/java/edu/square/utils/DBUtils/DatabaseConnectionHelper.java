package edu.square.utils.DBUtils;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionHelper {
    private static final String DB_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String DB_URL_PREFIX = "jdbc:derby:";
    private static final String DB_URL_DEFAULT_PATH = "derbyDB;";
    private static final String DB_CREATE = "create=true";

    //single instance of the connection
    private static Connection connection;

    static {
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            connection = DriverManager.getConnection(getDefaultDBURL());
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                connection = DriverManager.getConnection(createDefaultDBURL());
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static String createDefaultDBURL() {
        return DB_URL_PREFIX + DB_URL_DEFAULT_PATH + DB_CREATE;
    }

    private static String getDefaultDBURL() {
        return DB_URL_PREFIX + DB_URL_DEFAULT_PATH;
    }

    /**
     * Returns the connection to the database
     *
     * @return connection to the database
     */
    protected static Connection getConnection() {
        return connection;
    }

    /**
     * Closes the connection to the database
     *
     * @throws RuntimeException if the connection cannot be closed
     */
    protected static void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    private boolean isDerbyRunning() {
        //TODO: implement this
        return false;
    }

    private boolean isDerbyDBExistsAtDefaultPath() {
        //TODO: implement this
        return false;
    }


}

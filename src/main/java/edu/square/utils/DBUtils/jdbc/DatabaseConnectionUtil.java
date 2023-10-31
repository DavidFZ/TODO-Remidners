package edu.square.utils.DBUtils.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static edu.square.utils.DBUtils.jdbc.DatabaseStatusUtil.isDBDirExist;

public class DatabaseConnectionUtil {
    private static final String DB_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String DB_DRIVER_TYPE = "jdbc:derby:";
    private static final String DB_URL_DEFAULT_PATH = "derbyDB";
    private static final String DB_CREATE = ";create=true";

    //single instance of the connection
    private static Connection connection;

    static {
        if (isDBDirExist()) //isDBDirExist cant nested in setUpConnection!
            //if the database is not existing, skip
            setUpConnection(false);
    }

    private static void setUpConnection(boolean isInitializing) {
        try {
            //TODO: check if derby is existing and running
            Class.forName(DB_DRIVER);
            if (!isInitializing)
                connection = DriverManager.getConnection(createDefaultDBURL());
            else
                connection = DriverManager.getConnection(getDefaultDBURL());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    private static String createDefaultDBURL() {
        return DB_DRIVER_TYPE + DB_URL_DEFAULT_PATH + DB_CREATE;
    }

    private static String getDefaultDBURL() {
        return DB_DRIVER_TYPE + DB_URL_DEFAULT_PATH;
    }

    /**
     * Returns the connection to the database
     * if the connection is closed, it will be reopened
     *
     * @return connection to the database
     */
    protected static Connection getConnection() throws SQLException {
        if (connection.isClosed())
            setUpConnection(isDBDirExist());
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

    /**
     * Create database files at the default path
     */
    static void createDB() {
        try {
            connection = DriverManager.getConnection(createDefaultDBURL());
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static boolean isDBRunning() {
        try {
            return connection != null && !connection.isClosed();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //TODO: implement these methods
    private boolean isDerbyRunning() {
        return false;
    }

    private boolean isDerbyDBExistsAtDefaultPath() {
        return false;
    }


}

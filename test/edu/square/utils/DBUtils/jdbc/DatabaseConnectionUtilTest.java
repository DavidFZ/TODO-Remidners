package edu.square.utils.DBUtils.jdbc;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static edu.square.utils.DBUtils.jdbc.DatabaseConnectionUtil.*;
import static org.junit.Assert.*;

public class DatabaseConnectionUtilTest {

    @Test
    public void getConnection() {
        try {
            Connection connection = DatabaseConnectionUtil.getConnection();
            assertNotNull(connection);
            assertTrue(!connection.isClosed());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    public void closeConnection() {
        try {
            Connection connection = DatabaseConnectionUtil.getConnection();
            DatabaseConnectionUtil.closeConnection();
            assertTrue(connection.isClosed());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void createDB() {
        DatabaseConnectionUtil.createDB();
        try (Connection connection = DatabaseConnectionUtil.getConnection()) {
            assertNotNull(connection);
            assertFalse(connection.isClosed());
        } catch (SQLException e) {
            fail("SQLException occurred: " + e.getMessage());
        }

    }

    @Test
    public void isDBRunning() {
        DatabaseConnectionUtil.createDB();
        assertTrue(DatabaseConnectionUtil.isDBRunning());
    }
}
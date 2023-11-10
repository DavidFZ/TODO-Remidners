package edu.square.utils.DBUtils.jdbc;

import org.junit.Test;

import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.Assert.*;

public class DatabaseStatementUtilTest {

    @Test
    public void getStatement() {
        try {
            Statement statement = DatabaseStatementUtil.getStatement();
            assertNotNull(statement);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
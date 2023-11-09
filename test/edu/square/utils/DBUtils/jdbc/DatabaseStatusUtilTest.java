package edu.square.utils.DBUtils.jdbc;

import org.junit.Test;

import java.io.File;
import java.sql.SQLException;

import static org.junit.Assert.*;

public class DatabaseStatusUtilTest {

    @Test
    public void deleteDBDir() {
        DatabaseStatusUtil.deleteDBDir(false);
        File deleteDBDirFile = new File("DIR");
        assertFalse(deleteDBDirFile.exists());
    }

//    @Test
//    public void stopDB() {
//
//    }

    @Test
    public void isDBDirExist() {
        assertTrue(DatabaseStatusUtil.isDBDirExist());
    }
    //uncompleted
    @Test
    public void initDB() {
        try {
            DatabaseStatusUtil.initDB();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //uncompleted
    @Test
    public void forcedInitDB() {
    }
}
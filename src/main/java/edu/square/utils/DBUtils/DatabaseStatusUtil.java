package edu.square.utils.DBUtils;

import java.io.File;
import java.sql.SQLException;
import java.sql.Statement;

import static edu.square.utils.DevUtils.deleteDir;
import static edu.square.utils.DevUtils.isDirExist;

public class DatabaseStatusUtil extends Thread {

    /**
     * Deletes the Database Directory recursively
     *
     * @param isDeleteOnExit if true, the file will be deleted when the JVM exits
     */
    public static void deleteDBDir(boolean isDeleteOnExit) {
        String dbDir = "derbyDB";
        File dbDirFile = new File(dbDir);
        if (dbDirFile.exists()) {
            try {
                deleteDir(dbDirFile, isDeleteOnExit);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Stop the database
     */
    public static void stopDB() {
        if (!isDBDirExist()||DatabaseConnectionUtil.isDBRunning())
            return;
        try {
            DatabaseConnectionUtil.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Checks if the database directory exists
     *
     * @return
     */
    public static boolean isDBDirExist() {
        return isDirExist("derbyDB");
    }

    /**
     * Initialize the database
     *
     * @throws SQLException if the database cannot be initialized
     */
    public static void initDB() throws SQLException {
        DatabaseConnectionUtil.createDB();
        Statement statement = DatabaseStatementUtil.getStatement();

        //TODO: use sql file to create tables
        statement.execute("CREATE TABLE T (I INT)");
        statement.execute("INSERT INTO T VALUES(1),(2),(3)");

        statement.close();
    }

    public static void forcedInitDB() throws SQLException {
        deleteDBDir(false);
        initDB();
    }


    public static void main(String[] args) throws SQLException {
        forcedInitDB();
        stopDB();

        Statement statement = DatabaseStatementUtil.getStatement();

        statement.execute("INSERT INTO T VALUES(4),(5),(6)");

        statement.close();

//        deleteDBDir(false);
    }
}

package edu.square.utils.DBUtils.jdbc;

import edu.square.utils.FileUtil;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

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
        if (!isDBDirExist() || DatabaseConnectionUtil.isDBRunning())
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

        try {
            //TODO: Multi-threading
            useSQLFileInitDB();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        statement.close();
    }

    private static void useSQLFileInitDB() throws SQLException, IOException {
        List<String> sqlList = FileUtil.parseSQLFile("sql/init.sql");
        Statement statement = DatabaseStatementUtil.getStatement();
        for (String sqlStatement : sqlList) {
            statement.execute(sqlStatement);
        }
        statement.close();
    }

    public static void forcedInitDB() throws SQLException {
        deleteDBDir(false);
        initDB();
    }


    public static void main(String[] args) throws SQLException {
        forcedInitDB();
//        stopDB();

        Statement statement = DatabaseStatementUtil.getStatement();

//        statement.execute("INSERT INTO T VALUES(4),(5),(6)");
        statement.execute("INSERT INTO APP.REMINDER (UUID, CONTENT, CREATE_TIME, LAST_MODIFIED_TIME, REMIND_TIME, DONE_TIME, IS_EMERGENCY, IS_IMPORTANT) VALUES ('1234', 'test!', '2023-10-12 20:08:48.000000000', '2023-10-12 20:08:50.000000000', '2023-10-12 20:08:51.000000000', '2023-10-12 20:08:53.000000000', true, true)");
        statement.close();

//        deleteDBDir(false);
    }
}

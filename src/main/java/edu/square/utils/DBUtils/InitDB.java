package edu.square.utils.DBUtils;

import java.sql.SQLException;
import java.sql.Statement;
import edu.square.utils.DBUtils.DatabaseStatusUtil;

import static edu.square.utils.DBUtils.DatabaseStatusUtil.forcedInitDB;

public class InitDB {
    public static void main(String[] args) throws SQLException {
        forcedInitDB();
//        stopDB();

        Statement statement = DatabaseStatementUtil.getStatement();

//        statement.execute("INSERT INTO T VALUES(4),(5),(6)");
        statement.execute("INSERT INTO APP.REMINDER (UUID, CREATE_TIME, LAST_MODIFIED_TIME, CONTENT, DONE_TIME, IS_EMERGENCY, IS_IMPORTANT) VALUES ('124', '2023-10-12 15:27:02.000000000', '2023-10-12 15:27:05.000000000', 'have a try', '2023-10-12 15:27:13.000000000', false, false)");
        statement.close();
    }
}

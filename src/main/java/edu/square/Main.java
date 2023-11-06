package edu.square;

import java.sql.SQLException;

import static edu.square.utils.DBUtils.jdbc.DatabaseStatusUtil.forcedInitDB;
import static edu.square.utils.DevUtils.isDirExist;

public class Main {
    public static void main(String[] args) throws SQLException {
        if (!isDirExist("derbyDB"))
            forcedInitDB();


    }
}
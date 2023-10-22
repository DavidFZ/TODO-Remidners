package edu.square;

import edu.square.views.view.View1;

import java.sql.SQLException;

import static edu.square.utils.DBUtils.jdbc.DatabaseStatusUtil.forcedInitDB;
import static edu.square.utils.DevUtils.isDirExist;

public class Main {
    public static void main(String[] args) throws SQLException {
        if (!isDirExist("derbyDB"))
            forcedInitDB();


        View1 view1 = new View1();

    }
}
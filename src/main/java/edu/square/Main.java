package edu.square;

import edu.square.views.component.GroupedListComponent;

import java.sql.SQLException;

import static edu.square.utils.DBUtils.jdbc.DatabaseStatusUtil.forcedInitDB;
import static edu.square.utils.DevUtils.isDirExist;

public class Main {
    public static void main(String[] args) throws SQLException {
        if (!isDirExist("derbyDB"))
            forcedInitDB();






        GroupedListComponent groupedListComponent = new GroupedListComponent();

    }
}
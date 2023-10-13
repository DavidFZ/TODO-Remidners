package edu.square.utils.DBUtils;

import static edu.square.utils.DBUtils.jdbc.DatabaseStatusUtil.deleteDBDir;

public class DeleteDB {
    public static void main(String[] args) {
        deleteDBDir(false);
    }
}

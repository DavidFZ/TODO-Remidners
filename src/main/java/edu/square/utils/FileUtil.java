package edu.square.utils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
    //TODO: use multithreading to parse the sql file
    public static List<String> parseSQLFile(String sqlFilePath) throws IOException {

        String sql = new String(Files.readAllBytes(Path.of(sqlFilePath)));
        String[] sqlStatements = sql.split(";");

        if (sqlStatements.length == 0)
            throw new RuntimeException("No SQL statements found in " + sqlFilePath);

        List<String> sqlList = new ArrayList<>();
        for (String sqlStatement : sqlStatements) {
            if (!sqlStatement.trim().isEmpty()) {
                sqlList.add(sqlStatement);
            }
        }
        return sqlList;
    }
}

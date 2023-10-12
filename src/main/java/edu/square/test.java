package edu.square;

import java.io.IOException;
import java.util.List;

import static edu.square.utils.FileUtil.parseSQLFile;

public class test {
    public static void main(String[] args) throws IOException {
        List<String> list=parseSQLFile("sql/init.sql");
        for (String s:list){
            System.out.println(s);
        }
    }
}

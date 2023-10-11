package edu.square;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DerbyIntegration {
    public static void main(String[] args) {
        try {
            // 加载Derby的JDBC驱动
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");

            // 建立数据库连接
            Connection connection = DriverManager.getConnection("jdbc:derby:mydb");

            // 创建Statement对象
            Statement statement = connection.createStatement();

            // 执行数据库操作
            statement.executeUpdate("CREATE TABLE my_table (id INT, name VARCHAR(255))");

            // 关闭资源
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}


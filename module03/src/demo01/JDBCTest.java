package demo01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * MySQL的 URL 格式：jdbc:mysql://<hostname>:<port>/<db>?key1=value1&key2=value2
 *
 */

public class JDBCTest {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/test?useSSL=false&characterEncoding=utf8";

        Connection conn = null;
        Statement statement = null;

        try {
            // 创建连接
            conn = DriverManager.getConnection(url, "root", "123456");

            // 通过连接对象得到语句对象
            statement = conn.createStatement();

            // 执行 SQL
            statement.executeUpdate("create table student (id int PRIMARY key auto_increment, name varchar(20) not null, gender boolean, birthday date");

            // ("create table student (id int PRIMARY key auto_increment, name varchar(20) not null, gender boolean, birthday date)"

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 释放资源
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

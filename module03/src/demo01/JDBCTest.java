package demo01;

import java.sql.*;
import java.util.Properties;

/**
 * 使用 JDBC 开发使用到的包
 * java.sql：所有与 JDBC 访问数据库相关的接口和类
 * javax.sql：数据库扩展包，提供数据库额外的功能。如：连接池
 * 数据库的驱动：由各大数据库厂商提供，是对 JDBC 接口的实现类
 *
 * JDBC 的核心 API
 *
 * DriverManager 类：1. 管理和注册数据库驱动 2. 获取数据库连接对象
 * Connection 接口：连接对象，可用于创建 Statement 和 PreparedStatement 对象
 * Statement 接口： SQL 语句对象，用于将 SQL 语句发送给数据库服务器
 * PreparedStatement 接口： SQL 语句对象，是 Statement 的子接口
 * ResultSet 接口： 用于封装数据库查询的结果集，返回给客户端 Java 程序
 *
 * DriverManager 类
 * 静态方法：
 * Connection getConnection (String url, String user, String password)：通过连接字符串，用户名，密码来得到数据库的连接对象
 * Connection getConnection (String url, Properties info)： 通过连接字符串，属性对象来得到连接对象
 *
 * 连接数据库的 URL 地址格式：协议名:子协议://服务器名或 IP 地址:端口号/数据库名?参数=参数值
 * MySQL的 URL 格式：jdbc:mysql://<hostname>:<port>/<db>?key1=value1&key2=value2
 *
 */

public class JDBCTest {
    public static void main(String[] args){

        createStatement();
    }

    // 使用属性文件连接数据库
    static void getConnection() {
        // 数据库 URL
        String url = "jdbc:mysql://localhost:3306/my_test?useSSL=false&characterEncoding=utf8";

        // 属性对象
        Properties info = new Properties();

        // 把用户名和密码放在 info 对象

    }

    // 使用 createStatement 创建语句对象
    static void createStatement() {
        String url = "jdbc:mysql://localhost:3306/my_test?useSSL=false&characterEncoding=utf8";

        Connection conn = null;
        Statement statement = null;

        try {
            // 创建连接
            conn = DriverManager.getConnection(url, "root", "123456");

            // 通过连接对象得到语句对象
            statement = conn.createStatement();

            // 执行 SQL 语句
            ResultSet rs = statement.executeQuery("SELECT id, name FROM students WHERE id <= 10");

            while (rs.next()) {
                // 获取每列数据
                int id = rs.getInt(1);
                String name = rs.getString(2);
                System.out.println(id + ":" + name);

            }

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

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
 * DriverManager 类：管理和注册驱动，创建数据库的连接
 * Connection getConnection (String url, String user, String password)：通过连接字符串，用户名，密码来得到数据库的连接对象
 * Connection getConnection (String url, Properties info)： 通过连接字符串，属性对象来得到连接对象
 * 连接数据库的 URL 地址格式：协议名:子协议://服务器名或 IP 地址:端口号/数据库名?参数=参数值
 * MySQL的 URL 格式：jdbc:mysql://<hostname>:<port>/<db>?key1=value1&key2=value2
 *
 * Connection 接口： 具体的实现类由数据库的厂商实现，代表一个连接对象
 * Statement createStatement() 创建一条 SQL 语句对象
 *
 * Statement 接口：代表一条语句对象，用于发送 SQL 语句，用于执行静态 SQL 语句并返回它所生成结果的对象
 * int executeUpdate(String sql)：用于发送 DML 语句，增删改的操作，insert、update、delete。参数：SQL 语句。返回值：返回对数据库影响的行数
 * ResultSet executeQuery(String sql)：用于发送 DQL 语句，执行查询的操作，select。参数：SQL 语句。返回值：查询的结果集
 *
 * ResultSet 接口：封装数据库查询的结果集，对结果集进行遍历，取出每一条记录。
 * boolean next()：游标向下移动 1 行，返回 boolean 类型，如果还有下一条记录，返回 true，否则返回 false
 * 数据类型 getXxx()：通过字段名，参数是 String 类型。返回不同的类型；通过列号，参数是整数，从 1 开始。返回不同的类型
 *
 * 释放资源
 * 需要释放的对象：ResultSet 结果集，Statement 语句，Connection 连接
 * 释放原则：先开的后关，后开的先关。ResultSet  Statement  Connection
 * 在 finally 代码块中释放资源
 *
 * PreparedStatement 接口：是 Statement 接口的子接口，继承于父接口中所有的方法
 * PreparedStatement 会先将 SQL 语句发送给数据库预编译，再引用预编译的结果，可以提高 SQL 执行效率，有效防止 SQL 注入
 *
 * Connection 接口中获取 prepareStatement
 * PreparedStatement prepareStatement(String sql)：指定预编译的 SQL 语句，SQL 语句中使用占位符 ? 创建一个语句对象
 *
 * PreparedStatement 接口中的方法：
 * int executeUpdate()：执行 DML，增删改的操作，返回影响的行数
 * ResultSet executeQuery()：执行 DQL，查询的操作，返回结果集
 *
 * PreparedStatement 接口中设置参数的方法：
 * void setDouble(int parameterIndex, double x)：将指定参数设置为给定 Java double 值
 * void setFloat(int parameterIndex, float x)：将指定参数设置为给定 Java REAL 值
 * void setInt(int parameterIndex, int x)：将指定参数设置为给定 Java int 值
 * void setLong(int parameterIndex, long x)：将指定参数设置为给定 Java long 值
 * void setObject(int parameterIndex, Object x)：使用给定对象设置指定参数的值
 * void setString(int parameterIndex, String x)：将指定参数设置为给定 Java String 值
 *
 *
 * 使用 PreparedStatement 的步骤：
 * 1. 编写 SQL 语句，未知内容使用 ? 占位
 * 2. 获得 PreparedStatement 对象
 * 3. 设置实际参数：setXxx(占位符的位置, 真实的值)
 * 4. 执行参数化 SQL 语句
 * 5. 关闭资源
 *
 */

public class JDBCTest {
    public static void main(String[] args) throws SQLException {
//        getConnection();
//        executeUpdate();
        executeQuery();
    }

    // getConnection() 连接数据库
    static void getConnection() throws SQLException {
        Connection conn = null;
        String url = "jdbc:mysql://localhost:3306/my_test?useSSL=false&characterEncoding=utf8";

        // 属性对象
        Properties info = new Properties();

        // 把用户名和密码放在 info 对象
        info.setProperty("user", "root");
        info.setProperty("password", "123456");

        try {
            // 创建连接
            conn = DriverManager.getConnection(url, info);

            System.out.println(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 释放资源
            if (conn != null) {
                conn.close();
            }
        }
    }

    // executeUpdate() 增、删、改
    static void executeUpdate() {
        Connection conn = null;
        Statement stmt = null;
        String url = "jdbc:mysql://localhost:3306/my_test?useSSL=false&characterEncoding=utf8";

        try {
            // 创建连接
            conn = DriverManager.getConnection(url, "root", "123456");

            // 通过连接对象获取语句对象
            stmt = conn.createStatement();

            // SQL 语句
            String CREATE_TABLE_SQL = "CREATE TABLE IF NOT EXISTS teacher (id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(20) NOT NULL, course VARCHAR(20) NOT NULL)";
            String INSERT_SQL_01 = "INSERT INTO teacher VALUES(null, '李雷', 'match')";
            String INSERT_SQL_02 = "INSERT INTO teacher VALUES(null, '韩梅梅', 'english')";
            String INSERT_SQL_03 = "INSERT INTO teacher VALUES(null, '张丽丽', 'chinese')";

            // 执行 SQL
            stmt.executeUpdate(CREATE_TABLE_SQL);
            stmt.executeUpdate(INSERT_SQL_01);
            stmt.executeUpdate(INSERT_SQL_02);
            stmt.executeUpdate(INSERT_SQL_03);

            System.out.println("数据库创建成功！");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 释放资源
            if (stmt != null) {
                try {
                    stmt.close();
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // executeQuery() 查询
    static void executeQuery() {

        Connection conn = null;
        Statement stmt = null;
        String url = "jdbc:mysql://localhost:3306/my_test?useSSL=false&characterEncoding=utf8";


        try {
            // 创建连接
            conn = DriverManager.getConnection(url, "root", "123456");

            // 通过连接对象得到语句对象
            stmt = conn.createStatement();

            // 执行 SQL 语句
            ResultSet rs = stmt.executeQuery("SELECT id, name FROM teacher");

            while (rs.next()) {
                // 通过序号获取数据，从 1 开始
                int id = rs.getInt(1);
                // 通过字段名获取数据
                String name = rs.getString("name");
                System.out.println(id + ":" + name);
            }

            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 释放资源
            if (stmt != null) {
                try {
                    stmt.close();
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

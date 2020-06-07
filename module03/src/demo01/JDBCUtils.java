package demo01;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

/**
 * 自定义 JDBC 工具类
 */

public class JDBCUtils {
    // 定义常量
    private static String url;
    private static String user;
    private static String password;
    private static String driver;

    // 使用静态代码块读取一次配置文件
    static {
        try {
            // 创建 Properties 集合类，加载配置文件
            Properties prop = new Properties();

            // 使用 ClassLoader 类加载器获取字节码文件
            ClassLoader classLoader = JDBCUtils.class.getClassLoader();
            // 获取 src 目录下文件资源
            URL resource = classLoader.getResource("demo01/jdbc.properties");
            // 配置文件路径
            String path = resource.getPath();

            // 加载配置文件
            prop.load(new FileReader(path));

            // 获取数据
            url = prop.getProperty("url");
            user = prop.getProperty("user");
            password = prop.getProperty("password");
            driver = prop.getProperty("driver");

            // 注册驱动
            Class.forName(driver);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // 获取数据库连接
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    // 释放资源
    public static void close(Connection conn, Statement stmt) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(Connection conn, Statement stmt, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        close(conn, stmt);
    }
}

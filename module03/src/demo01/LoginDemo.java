package demo01;


import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.Scanner;

/**
 * 从控制台输入用户名密码登录
 */
public class LoginDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

       // 从控制台输入用户名和密码
        System.out.println("请输入用户名：");
        String name = sc.nextLine();
        System.out.println("请输入密码： ");
        String pwd = sc.nextLine();

//        login(name, pwd);
        loginSafe(name, pwd);
    }

    // 不安全，有 SQL 注入风险
    public static void login(String name, String pwd) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // 通过自定义 JDBC 工具类得到连接
            conn = JDBCUtil.getConnection();
            // 创建语句对象
            stmt = conn.createStatement();

            // 查询数据库
            String sql = "SELECT * FROM user WHERE name = '" + name + "' AND password = '" + pwd + "'";
            rs = stmt.executeQuery(sql);

            if (rs.next()) {
                System.out.println("登录成功，欢迎您！" + name);
            } else {
                System.out.println("登录失败，用户名或密码不正确");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 释放资源
            JDBCUtil.close(conn, stmt, rs);
        }
    }

    // 使用 PreparedStatement 防止 SQL 注入
    public static void loginSafe(String name, String pwd) {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        // SQL 语句
        String sql = "SELECT * FROM user WHERE name = ? AND password = ?";

        try {

            // 连接对象
            conn = JDBCUtil.getConnection();

            // 获取语句对象
            ps = conn.prepareStatement(sql);

            // 设置参数
            ps.setString(1, name);
            ps.setString(2, pwd);

            // 执行 SQL，注意不用再传入 sql
            rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("登录成功，欢迎您！" + name);
            } else {
                System.out.println("登录失败，用户名或密码不正确");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 释放资源
            JDBCUtil.close(conn, ps, rs);
        }


    }

}

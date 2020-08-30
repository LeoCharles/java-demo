package demo01;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * JDBC(Java Database Connectivity) Java 数据库连接
 *
 * JDBC 定义了操作所有关系型数据库的规则（接口）
 *
 * 各个数据库厂商实现了 JDBC 这套接口，提供数据库驱动 jar 包
 *
 * JDBC 使用步骤：
 * 1. 导入 jar bao
 * 2. 注册驱动
 * 3. 获取数据库连接对象 Connection
 * 4. 定义 SQL
 * 5. 获取执行 SQL 语句的对象 Statement
 * 6. 执行 SQL, 接收返回结果
 * 7. 处理结果
 * 8. 释放资质
 *
 * JDBC 的核心 API
 *
 * DriverManager：驱动管理对象，管理和注册数据库驱动，获取数据库连接对象
 * Connection：数据库连接对象，获取执行 SQL 的对象。管理事务
 * Statement：执行静态 SQL 语句对象，用于执行静态 SQL 语句
 * PreparedStatement：预编译 SQL 语句对象，用于执行 SQL 语句，是 Statement 的子接口
 * ResultSet：结果集对象，数据库查询的结果集
 *
 * DriverManager 类：管理和注册驱动，创建数据库的连接
 * Connection getConnection (String url, String user, String password)：通过连接字符串，用户名，密码来得到数据库的连接对象
 * Connection getConnection (String url, Properties info)： 通过连接字符串，属性对象来得到连接对象
 * 连接数据库的 URL 地址格式：协议名:子协议://服务器名或 IP 地址:端口号/数据库名?参数=参数值
 * MySQL的 URL 格式：jdbc:mysql://ip地址(域名):端口号/数据库名称?key1=value1&key2=value2
 *
 * Connection 接口： 获取执行 SQL 的对象，事务管理
 * Statement createStatement()：创建 SQL 语句对象
 * void setAutoCommit(boolean autoCommit)：如果为 false，表示关闭自动提交，相当于开启事务
 * void commit()：提交事务
 * void rollback()：回滚事务
 *
 * Statement 接口：用于执行静态 SQL 语句并返回它所生成结果的对象
 * int executeUpdate(String sql)：执行 DML(INSERT、UPDATE、DELETE)、DDL(CREATE、ALTER、DROP)语句。返回对数据库影响的行数
 * ResultSet executeQuery(String sql)：执行 DQL(SELECT) 语句。返回查询的结果集
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
    public static void main(String[] args) throws Exception {
//        useJDBC();
//        executeQuery();
//        executeUpdate();
//        findAllTeacher();
        transferMoney();
    }

    // 使用 JDBC
    public static void useJDBC(){

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // 注册驱动，MySQL 5 以后不需要手动注册
            Class.forName("com.mysql.jdbc.Driver");
            // 获取数据库连接对象
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_test?useSSL=false", "root", "123456");

            // 定义 SQL 语句
            String sql = "SELECT * FROM teacher";

            // 获取执行 SQL 语句对象 Statement
            stmt = conn.createStatement();

            // 执行 sql
            rs = stmt.executeQuery(sql);


            while (rs.next()) {
                // 根据列编号获取值，从 1 开始
                System.out.println(rs.getInt(1) + ". " + rs.getString(2));
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // 释放资源
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
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
    }

    // executeQuery() 查询
    public static void executeQuery() {

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // 使用自定义JDBC工具类获取连接
            conn = JDBCUtils.getConnection();

            // 通过连接对象得到语句对象
            stmt = conn.createStatement();

            // 执行 SQL 语句
            rs = stmt.executeQuery("SELECT * FROM student");

            while (rs.next()) {
                // 通过字段名获取数据
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String sex = rs.getString("sex");
                String address = rs.getString("address");
                System.out.println("姓名：" + name + "，年龄：" + age + "，性别：" + sex + "，地址：" + address);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 释放资源
            JDBCUtils.close(conn, stmt, rs);
        }
    }

    // executeUpdate() 增、删、改
    public static void executeUpdate() {
        Connection conn = null;
        Statement stmt = null;

        try {
            // 使用自定义JDBC工具类获取连接
            conn = JDBCUtils.getConnection();

            // 通过连接对象获取语句对象
            stmt = conn.createStatement();

            // 创建表
            String CREATE_TABLE_SQL = "CREATE TABLE IF NOT EXISTS teacher (id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(20) NOT NULL, course VARCHAR(20) NOT NULL)";

            // 插入数据
//            String UPDATE_SQL = "INSERT INTO teacher VALUES(null, '陈云慧', 'chinese')";

            // 更新数据
//            String UPDATE_SQL = "UPDATE teacher SET course = 'math' WHERE name = '李雷'";

            // 删除数据
            String UPDATE_SQL = "DELETE FROM teacher WHERE name = '张三'";

            // 执行 SQL
            stmt.executeUpdate(CREATE_TABLE_SQL);

            // 更新操作影响的记录数量
            int i = stmt.executeUpdate(UPDATE_SQL);

            System.out.println("更新了 " + i + " 条数据！");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 释放资源
            JDBCUtils.close(conn, stmt);
        }
    }

    // 查询 teacher 表中的数据，封装为对象
    public static List<Teacher> findAllTeacher() {

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        List<Teacher> list = null;
        Teacher teacher;

        try {

            // 使用自定义JDBC工具类获取连接
            conn = JDBCUtils.getConnection();

            // 定义 SQL
            String sql = "SELECT * FROM teacher";

            // 获取执行 SQL 的对象
            stmt = conn.createStatement();

            // 执行 SQL
            rs = stmt.executeQuery(sql);

            // 遍历结果集，封装对象，装置集合
            list = new ArrayList<>();
            while (rs.next()) {
                // 获取数据
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String course = rs.getString("course");

                // 创建对象并赋值
                teacher = new Teacher();
                teacher.setId(id);
                teacher.setName(name);
                teacher.setCourse(course);

                // 封装集合
                list.add(teacher);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 释放资源
            JDBCUtils.close(conn, stmt, rs);
        }

        System.out.println(list);

        return list;
    }

    // 使用事务完成转账操作
    public static void transferMoney() {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            // 获取连接
            conn = JDBCUtils.getConnection();

            // 开启事务
            conn.setAutoCommit(false);

            // 获取 prepareStatement
            ps = conn.prepareStatement("UPDATE account SET balance = balance - ? WHERE name = ?");

            ps.setInt(1, 500);
            ps.setString(2, "Leo");
            ps.executeUpdate();

            ps = conn.prepareStatement("UPDATE account SET balance = balance + ? WHERE name = ?");
            ps.setInt(1, 500);
            ps.setString(2, "Rex");
            ps.executeUpdate();

            // 提交事务
            conn.commit();
            System.out.println("转款成功！");

        } catch (SQLException e) {
            e.printStackTrace();

            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            System.out.println("转账失败！");
        }
    }
}

package demo02;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * C3P0 使用步骤：
 * 1. 导入 jar包 c3p0-0.9.5.2.jar 和 mchange-commons-java-0.2.12.jar
 * 2. 定义配置文件
 *    名称：c3p0.properties 或者 c3p0-config.xml
 *    位置：根目录
 * 3. 创建数据库连接池对象 ComboPooledDataSource()
 * 4. 获取连接 getConnection()
 *
 */

public class C3P0Demo {
    public static void main(String[] args) throws SQLException {

        // 创建数据库连接池对象，使用指定名称的配置
        DataSource ds = new ComboPooledDataSource("my_test");

        // 获取连接对象
        Connection conn =  ds.getConnection();

        System.out.println(conn);
    }
}

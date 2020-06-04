package demo02;


import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * 使用 Druid 连接池
 *
 * Druid 使用步骤：
 * 1. 导入jar包 druid-1.0.9.jar
 * 2. 定义配置文件：任意名称的properties文件，可以放在任意位置
 * 3. 加载配置文件
 * 4. 获取数据库连接池对象：通过工厂来来获取  DruidDataSourceFactory
 * 5. 获取连接：getConnection
 *
 */

public class DruidDemo {
    public static void main(String[] args) throws Exception {

        // 加载配置文件
        Properties prop = new Properties();
        InputStream is = DruidDemo.class.getClassLoader().getResourceAsStream("druid.properties");
        prop.load(is);

        // 获取连接池对象
        DataSource ds = DruidDataSourceFactory.createDataSource(prop);

        // 获取连接对象
        Connection conn = ds.getConnection();

        System.out.println(conn);
    }
}

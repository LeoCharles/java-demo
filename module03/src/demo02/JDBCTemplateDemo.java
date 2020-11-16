package demo02;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

/**
 * JDBCTemplate
 *
 * Spring 框架对 JDBC的简单封装，提供了一个 JDBCTemplate 对象简化 JDBC 的开发
 *
 * 步骤：
 *  1. 导入 jar 包
 *  2. 创建 JDBCTemplate 对象，依赖于数据源 DataSource
 *      JdbcTemplate template = new JdbcTemplate(ds)
 *  3. 调用 JDBCTemplate 里的方法来完成 CRUD 操作
 *      update(): 执行 DML 语句。增、删、改语句
 *      queryForMap(): 查询结果将结果集封装为 Map 集合，将列名作为 key，将值作为 value
 *      queryForList():查询结果将结果集封装为 List 集合
 *      query():查询结果，将结果封装为 JavaBean 对象。一般使用 BeanPropertyRowMapper 实现类，完成 JavaBean 自动封装
 *      queryForObject()：查询结果，将结果封装为对象。一般用于聚合函数查询
 */

public class JDBCTemplateDemo {
    public static void main(String[] args) {
        update();
        queryForMap();
        queryForList();
        query();
        queryForObject();
    }

    // 创建 JDBCTemplate 对象，需要传入 DataSource
    private static JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    // update，用于增、删、改
    public static void update() {
        String sql = "UPDATE account SET balance = 5000 WHERE id = ?";

        int count = template.update(sql, 1);
        System.out.println(count);
    }

    // queryForMap，将查询结果封装为 Map，查询的结果集长度为 1
    public static void queryForMap() {
        String sql = "SELECT * FROM account WHERE id =?";

        Map<String, Object> map = template.queryForMap(sql, 1);
        System.out.println(map);
    }

    // queryForList，将查询结果封装为 Map 集合，再将 Map 集合装载到 List 集合
    public static void queryForList() {
        String sql  = "SELECT * FROM account";

        List<Map<String, Object>> list = template.queryForList(sql);
        System.out.println(list);
    }

    // query，将查询结果封装到 JavaBean 对象，再装载到 List 集合
    public static void query() {
        String sql  = "SELECT * FROM student";

        // 需要传入 RowMapper 接口
        List<Student> list = template.query(sql, new BeanPropertyRowMapper<Student>(Student.class));

        for (Object student : list) {
            System.out.println(student);
        }
    }

    // queryForObject，将查询结果封装为对象，一般用于聚合函数
    public static void queryForObject() {
        String sql = "Select count(id) from student";

        Long total = template.queryForObject(sql, Long.class);
        System.out.println(total);
    }
}

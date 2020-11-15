package demo02;

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
 *      queryForMap(): 查询结果将结果集封装为 map 集合，将列名作为 key，将值作为 value
 *      queryForList():查询结果将结果集封装为 list 集合
 *      query():查询结果，将结果封装为 JavaBean 对象
 *      queryForObject()：查询结果，将结果封装为对象
 */

public class JDBCTemplateDemo {
    public static void main(String[] args) {

    }
}

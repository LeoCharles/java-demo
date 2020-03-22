package demo03;

/**
 * 员工类
 */
public class Employee {

    String title = "员工";
    String name;

    public Employee() {
        System.out.println("Employee 类无参构造");
    }

    public Employee(String name) {
        this.name = name;
        System.out.println("Employee 类有参构造");
    }

    public void method() {
        System.out.println("Employee 类方法执行");
    }

    // 父类返回值类型是 Object 是所有公共类的父类，范围最大
    public Object returnNull() {
        return null;
    }

    // 方法权限修饰符：public > protected > (default) > private
    protected void testMethod() {
        System.out.println("Employee 类中一个受保护的方法");
    }

}

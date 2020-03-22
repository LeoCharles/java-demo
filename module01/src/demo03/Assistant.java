package demo03;

/**
 * 助教类 继承自 员工类
 */
public class Assistant extends Employee {

    String title = "助教";

    public Assistant() {
        // super(); // 默认调用父类无参构造方法
        System.out.println("Assistant 类构造方法");
    }

    // 重写父类方法，参数名一样，参数列表也一样
    // @Override 注解，用来检测是不是有效的重写
    @Override
    public void method() {
        System.out.println("Assistant 类方法执行");
    }

    // 重写父类的方法，方法反回值范围必须【小于等于】父类的范围
    // 父类是 Object，子类是 int[]， Object > int[]
    @Override
    public int[] returnNull() {
        return null;
    }

    // 重写父类的方法，方法权限修饰符必须【大于等于】父类的权限修饰符
    // public > protected > (default) > private
    @Override
    protected void testMethod(){
        System.out.println("Assistant 类中一个受保护的方法");
    }
}

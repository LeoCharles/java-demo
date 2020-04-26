package demo14;

/**
 * 函数式接口：有且只有一个抽象方法的接口，称之为函数式接口
 *
 * 使用：作为方法的参数和返回值类型
 *
 *
 *
 *
 *
 *
 */

public class MainTest {
    public static void main(String[] args) {
        // 参数传入实现类对象
        testFunctional(new MyFunctionalInterfaceImpl());

        // 参数传入接口的匿名内部类
        testFunctional(new MyFunctionalInterface() {
            @Override
            public void myAbstractMethod() {
                System.out.println("使用匿名内部类重写接口中的抽象方法");
            }
        });

        // 参数使用 Lambda 表达式
        testFunctional(() -> {
            System.out.println("使用 Lambda 表达式重写接口中的抽象方法");
        });

        // 简化 Lambda 表达式
        testFunctional(() -> System.out.println("简化 Lambda 表达式"));
    }


    // 参数使用函数式接口
    public static void testFunctional(MyFunctionalInterface myInter) {
        myInter.myAbstractMethod();
    }
}

package demo14;

/**
 * 函数式接口：有且只有一个抽象方法
 *
 * 接口中可以包含其他的方法(默认、静态、私有)
 *
 * 添加 FunctionalInterface 注解，检测接口是否是函数式接口
 *
 * 函数式接口一般可以作为方法的参数和返回值类型
 */

@FunctionalInterface
public interface MyFunctionalInterface {

    // 定义一个抽象方法
    public abstract void myAbstractMethod();
}

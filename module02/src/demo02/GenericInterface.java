package demo02;

/**
 * 含有泛型的接口
 *
 * 定义格式：
 * 修饰符 interface 接口名<代表泛型的变量> { }
 *
 * 1.创建实现类时确定泛型的具体类型
 * 2.创建对象时，确定泛型的具体类型
 */
public interface GenericInterface<I> {

    // 抽象方法
    public abstract void method(I i);
}

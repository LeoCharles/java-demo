package demo02;

/**
 * 含有泛型的接口的实现类
 *
 * 使用方式 1：
 * 创建接口实现类的时候，指定泛型的具体类型
 *
 * 例如:
 * public final class Scanner extends Object implements Iterator<String>
 *
 * Scanner 类实现了 Iterator 接口，并指定其泛型为 String 类型
 * 所以重写的 next 方法的返回值类型就是 String
 *
 */
public class GenericInterfaceImplA implements GenericInterface<String> {

    // 创建接口实现类的时候，指定泛型的具体类型


    // 重写接口中的抽象方法
    @Override
    public void method(String s) {
        System.out.println(s);
    }
}

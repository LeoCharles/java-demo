package demo02;

/**
 * 含有泛型的接口的实现类
 *
 * 使用方式 2：
 * 创建实现类的时候，不指定泛型的具体类型
 * 接口使用什么类型，实现类就使用什么类型
 * 相当于创建了一个含有泛型的类
 * 创建对象的时候确定泛型的具体类型
 *
 * 例如：
 * public interface List<E>
 * public class ArrayList<E> implements List<E>
 * ArrayList 类在实现 List 接口时没有指定泛型的具体类型
 *
 *
 */
public class GenericInterfaceImplB<I> implements GenericInterface<I> {

    // 接口使用泛型 I，实现类也使用泛型 I，重写抽象方法也使用泛型 I
    @Override
    public void method(I i) {
        System.out.println(i);
    }
}

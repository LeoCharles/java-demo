package demo02;

/**
 * 定义一个含有泛型的类
 *
 * 定义格式：
 * 修饰符 class 类名<代表泛型的变量> { }
 *
 * 在创建对象的时候确定泛型的具体类型
 *
 */
public class GenericClass<E> {

    // 变量 E 的值在创建对象的时候确定
    private E name;

    public E getName() {
        return name;
    }

    public void setName(E name) {
        this.name = name;
    }
}

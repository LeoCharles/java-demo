package demo02;

/**
 * 定义含有泛型的方法
 *
 * 定义格式：
 * 修饰符 <代表泛型的变量> 返回值类型 方法名(参数) { }
 *
 * 调用方法时，确定泛型的具体类型
 * 传递什么类型的参数，泛型就是什么类型
 */
public class GenericMethod {

    // 定义一个含有泛型的方法
    public <M> void genericMethod(M param) {
        System.out.println("参数是：" + param);
    }

    // 定义一个含有泛型的静态方法
    public static <S> void genericStaticMethod(S param) {
        System.out.println("参数是：" + param);
    }
}

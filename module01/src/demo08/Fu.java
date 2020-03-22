package demo08;

/**
 * 使用 final 关键字修饰方法
 *
 * 格式： 修饰符 final 返回值类型 方法名称() {}
 */
public class Fu {

    // 使用 final 修饰方法时，这个方法就是最终方法，不能被重写
    public final void method() {
        System.out.println("父类方法执行！");
    }
}

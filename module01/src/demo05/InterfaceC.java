package demo05;

/**
 * 接口 C 继承多个接口
 */
public interface InterfaceC extends InterfaceA, InterfaceB {

    // 接口C的抽象方法
    public abstract void methodC();

    @Override
    default void methodDefault() {
        System.out.println("必须覆盖重写接口AB的默认方法");
    }
}

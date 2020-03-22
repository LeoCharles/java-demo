package demo05;

/**
 * 接口的默认方法
 *
 * 从 java 8 开始接口里允许定义默认方法 ，为了解决接口升级问题
 *
 * public default 返回值类型 方法名 {
 *     方法体
 * }
 *
 * 1. 接口的默认方法，可以通过接口实现类对象直接调用。
 * 2. 接口的默认方法，可以被接口实现类进行覆盖重写。
 *
 */
public interface InterfaceDefault {

    // 抽象方法
    public abstract void methodAbs();

    // 如果接口添加一个新的抽象方法（接口升级），则需要在所有实现类都重写实现该方法

    // 将新添加的方法改为默认方法就可以解决问题
    // public 可以省略，default 不能省略
    public default void methodDefault() {
        System.out.println("接口新添加的默认方法");
    }

}

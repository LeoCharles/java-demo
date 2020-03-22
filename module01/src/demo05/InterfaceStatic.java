package demo05;

/**
 * 接口的静态方法
 *
 * 从 java 8 开始接口中可以定义静态方法
 *
 * public static 返回值类型 方法名(参数列表) {
 *     方法体
 * }
 *
 *
 */
public interface InterfaceStatic {

    // 定义接口的静态方法
    // public 可以省略
    public static void methodStatic() {
        System.out.println("这是接口定义的静态方法");
    }
}

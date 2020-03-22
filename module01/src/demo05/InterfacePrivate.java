package demo05;

/**
 * 接口私有方法
 *
 * 从 java 9 开始可以在接口中定义私有方法
 *
 * 私有方法可以解决默认方法或静态方法之间重复代码问题
 * 这个方法是私有的，不能让实现类使用
 *
 * 普通私有方法，解决多个默认方法之间重复代码问题
 * private 返回值类型 方法名称(参数列表){
 *     方法体
 * }
 *
 * 静态私有方法，解决多个静态方法之间重复代码问题
 * private static 返回值类型 方法名称(参数列表) {
 *     方法体
 * }
 *
 */
public interface InterfacePrivate {

    // 默认方法
    public default void methodDefault1() {
        System.out.println("接口默认方法1");
        methodDefaultCommon();
    }

    // 默认方法
    public default void methodDefault2() {
        System.out.println("接口默认方法2");
        methodDefaultCommon();
    }

    public static void methodStatic1() {
        System.out.println("接口静态方法1");
        methodStaticCommon();
    }

    public static void methodStatic2() {
        System.out.println("接口静态方法2");
        methodStaticCommon();
    }

    // 普通私有方法 - 抽取默认方法中的重复代码
    private void methodDefaultCommon() {
        System.out.println("接口默认方法中的重复代码");
    }

    // 静态私有方法 - 抽取静态方法中重复代码
    private static void methodStaticCommon() {
        System.out.println("接口静态方法中的重复代码");
    }
}

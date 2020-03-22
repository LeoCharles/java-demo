package demo05;

/**
 * 接口中可以定义 成员变量
 *
 * 这个成员变量必须使用 public static final 三个关键字进行修饰
 *
 * 从效果上看，这就是接口的常量
 *
 * public static final 数据类型 常量变量 = 数据值;
 *
 */
public interface InterfaceConst {

    // 这就是一个常量，一旦赋值，不可以修改
    // public static final 可以不写，不写一是这些
    // 常量名大写
    public static final int NUM_OF_AGE = 30;  // 接口中的常量必须手动赋值



}

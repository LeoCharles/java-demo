package demo05;

/**
 * 接口是多个类的公共规范
 *
 * 接口是一种引用数据类型
 *
 * 接口最重要的内容就是抽象方法
 *
 * 抽象方法格式:
 * public abstract 返回值类型 方法名称(参数列表);
 *
 * 修饰符必须是 public abstract，可以省略
 * 方法的三要素可以随意定义。
 */
public interface InterfaceAbstract {


    // 接口的抽象方法修饰符必须是 public abstract，可以省略
    public abstract void methodAbs1();
    abstract  void methodAbs2();
    public void methodAbs3();
    void methodAbs4();
}

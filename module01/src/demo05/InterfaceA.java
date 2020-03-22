package demo05;

public interface InterfaceA {

    // 接口A的抽象方法
    public abstract void methodA();

    // 接口AB都有的抽象方法
    public abstract  void methodCommon();

    // 接口AB同名的默认方法
    public default void methodDefault() {
        System.out.println("默认方法AAA");
    }
}

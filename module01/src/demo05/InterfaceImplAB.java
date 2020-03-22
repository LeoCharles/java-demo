package demo05;

/**
 * 实现多个接口
 *
 * 必须覆盖重写所有接口的抽象方法
 */
public class InterfaceImplAB implements InterfaceA, InterfaceB  {

    @Override
    public void methodA() {
        System.out.println("覆盖重写接口A的抽象方法A");
    }

    @Override
    public void methodB() {
        System.out.println("覆盖重写接口B的抽象方法B");
    }

    @Override
    public void methodCommon() {
        System.out.println("覆盖重写接口A、B的都有的同名抽象方法");
    }

    // 必须重写 接口AB中同名的默认方法
    @Override
    public void methodDefault() {

    }
}

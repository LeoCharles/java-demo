package demo05;

/**
 * 接口的实现类名称，建议使用 接口名+Impl
 *
 * 接口的实现类要覆盖重写所有的抽象方法
 *
 */
public class InterfaceAbstractImpl implements InterfaceAbstract {


    // 实现类要覆盖重写接口的所有抽象方法
    @Override
    public void methodAbs1() {
        System.out.println("实现接口抽象方法1");
    }

    @Override
    public void methodAbs2() {
        System.out.println("实现接口抽象方法2");
    }

    @Override
    public void methodAbs3() {
        System.out.println("实现接口抽象方法3");
    }

    @Override
    public void methodAbs4() {
        System.out.println("实现接口抽象方法3");
    }
}


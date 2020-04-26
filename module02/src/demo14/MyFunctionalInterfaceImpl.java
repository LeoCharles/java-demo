package demo14;

public class MyFunctionalInterfaceImpl implements MyFunctionalInterface {

    @Override
    public void myAbstractMethod() {
        System.out.println("实现类重写接口中的抽象方法");
    }
}

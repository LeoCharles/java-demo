package demo05;

public class InterfaceDefaultImplA implements InterfaceDefault {

    // 覆盖重写接口所有的
    @Override
    public void methodAbs() {
        System.out.println("A 实现了抽象方法");
    }
}

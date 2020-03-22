package demo05;

public class InterfaceDefaultImplB implements InterfaceDefault {

    // 重写接口抽象方法
    @Override
    public void methodAbs() {
        System.out.println("B 实现了抽象方法");
    }


    // 重写接口默认方法
    @Override
    public void methodDefault() {
        System.out.println("B 重写接口新添加的默认方法");
    }
}

package demo10;

public class MyInterfaceImpl implements MyInterface {


    // 重写接口抽象方法
    @Override
    public void methodAbs() {
        System.out.println("实现类覆盖重写了方法");
    }
}

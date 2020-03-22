package demo06;

/**
 * 子类继承父类
 */
public class Zi extends Fu {

    String label = "子类";

    // 子类重写父类方法
    @Override
    public void method() {
        System.out.println("子类方法");
    }
}

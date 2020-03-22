package demo03;

/**
 * Cat 类继承抽象类 Animal
 */
public class Cat extends Animal {


    // 子类覆盖重写父类的抽象方法
    @Override
    public void eat() {
        System.out.println("猫吃鱼");
    }
}

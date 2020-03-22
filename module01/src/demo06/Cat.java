package demo06;

public class Cat extends Animal {

    // 重写父类抽象方法
    @Override
    public void eat() {
        System.out.println("猫吃鱼");
    }

    // 子类特有方法
    public void catchMouse() {
        System.out.println("猫捉老鼠");
    }
}

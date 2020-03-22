package demo06;

public class Dog extends Animal {

    // 重写父类抽象方法
    @Override
    public void eat() {
        System.out.println("狗啃骨头");
    }

    public void watchHouse() {
        System.out.println("狗看家");
    }
}

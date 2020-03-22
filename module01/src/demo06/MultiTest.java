package demo06;

/**
 * 多态性
 *
 * 父类：人类
 * 子类：学生类  员工类
 * 对象小明既是一个学生，也是一个人
 * 一个对象拥有多种形态，这就是对象的多态性
 *
 * 代码中提现多态性：父类引用指向子类对象
 *
 * 格式： 父类名称 对象名 = new 子类名称()
 *        接口名称 对象名 = new 实现类名称()
 *
 * 成员方法优先使用子类的方法，没有则向上查找
 * 通过对象名称访问成员变量，看等号左边是谁（父类），优先用谁，没有则向上找
 *
 * 对象的向上转型：父类名称 对象名 = new 子类名称();  向上转型一定是安全的
 * 类似于自动类型转换 double num = 10; int --> double
 *
 * 对象的向下转型：子类名称 对象名 = (子类名称) 父类对象；
 * 类似强制类型转换 int num = (int) 10.0
 */
public class MultiTest {
    public static void main(String[] args) {

        // 使用多态的写法
        // 左侧父类的引用，指向了右侧子类的对象
        Fu obj = new Zi();

        // 优先使用子类的方法
        obj.method(); // 子类方法
        // 如果子类没有该方法，就找父类
        obj.methodFu(); // 父类特有方法

        // 优先使用父类的成员变量
        System.out.println(obj.label); // 父类


        // 无论右边 new 的是哪个子类，等号左边调用方法不变
        Employee one = new Teacher();
        Employee two = new Assistant();
        one.work(); // 讲课
        two.work(); // 辅导


        // 对象的向上转型：父类引用指向子类对象
        Animal animal = new Cat();
        // 编译看左，运行看右
        animal.eat();  // 猫吃鱼
        // 一旦转型为父类，就无法调用子类特有方法
        // animal.catchMouse(); // 错误写法

        // 对象的向下转型：将父类对象，还原成本来的子类对象
        Cat cat = (Cat) animal; // 本来是猫，向上转型为了动物，再还原成猫
        // 本来是猫才能还原成猫，不能还原成狗
        // 编译不报错，运行异常
        Dog dog = (Dog) animal; // 类型转换异常 java.lang.ClassCastException



    }
}

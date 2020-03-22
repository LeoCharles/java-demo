package demo05;

/**
 * 接口是多个类的公共规范
 *
 * 接口是一种引用数据类型
 *
 * 接口的使用步骤：
 *
 * 1. 接口不能直接使用，必须有一个实现类来实现(implements)该接口。
 *
 * 2. 接口的实现类，必须覆盖重写(实现)接口中所有的抽象方法。
 *
 * 3. 创建实现类的对象，进行使用。
 *
 *  接口是一系列方法的抽象。
 *  抽象类是一类事物的抽象，包括属性和方法。
 *  接口是特殊的抽象类。
 */
public class InterfaceTest {
    public static void main(String[] args) {

        // 不能直接 new 创建接口对象
        // InterfaceAbstract inter = new InterfaceAbstract(); // 错误写法

        // 创建实现类对象
        InterfaceAbstractImpl impl = new InterfaceAbstractImpl();

        impl.methodAbs1(); // 实现接口抽象方法1
        impl.methodAbs2(); // 实现接口抽象方法2
        impl.methodAbs3(); // 实现接口抽象方法3
        impl.methodAbs4(); // 实现接口抽象方法4

        // 创建实现类对象，默认方法会被继承
        InterfaceDefaultImplA implA = new InterfaceDefaultImplA();
        InterfaceDefaultImplB implB = new InterfaceDefaultImplB();
        // 调用默认方法，如果实现类没有，会向上找接口的默认方法
        implA.methodDefault(); // 新添加的默认方法
        implB.methodDefault(); // B 重写接口新添加的默认方法

        // 接口静态方法直接通过接口名调用
        InterfaceStaticImpl implStatic = new InterfaceStaticImpl();
        // 不能通过接口实现类对象调用接口中的静态方法
        // implStatic.methodStatic(); // 错误写法
        // 直接通过接口名称调用静态方法
        InterfaceStatic.methodStatic(); // 这是接口定义的静态方法

        // 接口中的私有方法不能被外部使用
        // InterfacePrivate.methodStaticCommon() // 错误


        // 访问接口中的常量
        System.out.println(InterfaceConst.NUM_OF_AGE); // 30

    }



}

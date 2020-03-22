package demo07;

public class Demo07Main {

    public static void main(String[] args) {

        // 创建笔记本
        Computer computer = new Computer();

        computer.powerOn();

        // 向上转型成 USB 类型，给电脑使用
        USB usbMouse = new Mouse(); // 向上转型
        // 电脑使用 USB 设备
        computer.useDevice(usbMouse);

        // 创建一个键盘
        KeyBoard keyBoard = new KeyBoard(); // 子类对象
        // 方法参数是 USB 类型，传递进去的是一个实现类对象
        computer.useDevice(keyBoard); // 发生了向上转型
        // 使用匿名对象也是正确写法
        // computer.useDevice(new Keyboard());

        computer.powerOff();

    }
}

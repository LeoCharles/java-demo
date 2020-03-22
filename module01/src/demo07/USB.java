package demo07;

/**
 * USB 接口
 *
 * 通过 USB 接口，鼠标和键盘连接电脑使用
 *
 * 鼠标、键盘实现 USB 接口
 *
 * 电脑使用 USB 接口
 *
 */
public interface USB {

    // 抽象方法 - 打开设备
    public abstract void open();

    // 抽象方法 - 关闭设备
    public abstract void close();
}

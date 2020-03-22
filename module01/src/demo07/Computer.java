package demo07;

/**
 * 电脑类
 */
public class Computer {

    public void powerOn() {
        System.out.println("电脑开机");
    }

    public void powerOff() {
        System.out.println("电脑关机");
    }

    // 使用 SUB 接口设备
    public void  useDevice(USB usb) {
        // 打开 usb 设备
        usb.open();

        // 使用设备前，先判断
        if (usb instanceof Mouse) {
            // 向下转型
            Mouse mouse = (Mouse) usb;
            mouse.click();
        }
        if (usb instanceof  KeyBoard) {
            // 向下转型
            KeyBoard keyBoard = (KeyBoard) usb;
            keyBoard.type();
        }

        // 关闭 usb 设备
        usb.close();
    }
}

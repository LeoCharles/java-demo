package demo03;

/**
 * 新手机 继承自手机类
 */
public class NewPhone extends Phone {

    // 覆盖重写父类中的方法，添加新功能
    @Override
    public void show() {
        // 通过 super 关键字调用父类的方法，继承父类的功能
        super.show();
        // 添加子类自己的功能
        System.out.println("显示姓名");
        System.out.println("显示头像");
    }
}

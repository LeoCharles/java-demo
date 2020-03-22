package demo10;

/**
 * 局部内部类：定义在一个方法内部的类
 * 只有当前所属方法才能使用它，出了这个方法外面就不能使用
 *
 * 格式:
 * 修饰符 class 外部类名称 {
 *     修饰符 返回值类型 外部类名称(参数列表) {
 *         class 局部内部类名称 {
 *             // ...
 *         }
 *     }
 * }
 *
 * 局部内部类，如果希望访问所在方法的局部变量，这个局部变量必须是有效 final 的
 *
 * 从 java 8 开始，只要局部变量事实不变，那么 final 关键字可以省略
 *
 * 原因：
 * 1.new 出来的对象在堆内存，局部变量在栈内存
 * 2.方法运行结束后，立刻出栈，局部变量立刻消失
 * 3.new 出来的对象会在堆内存中持续存在，直到垃圾回收消失
 */
public class Outer {

    // 局部内部类定义在方法中
    public void methodOuter() {
        final int num = 10;

        // 局部内部类
        class Inner {
            // 内部类方法
            public void methodInner() {
                // 局部类访问所在方法的局部变量，局部变量必须是事实 final 的
                System.out.println(num);
            }
        }

        // 局部内部类只能在当前方法内部使用

        Inner inner = new Inner();
        inner.methodInner();
    }

}

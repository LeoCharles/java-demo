package demo13;

import java.util.ArrayList;

/**
 * 包装类
 *
 * 基本数据类型使用起来很方便，但是没有对应的方法来操作这些基本类型。
 * 可以使用一个类把基本数据类型的数据包装起来，在类中定义一些方法，这个类就是包装类。
 *
 * 基本类型      包装类
 * byte           Byte
 * short          Short
 * int            Integer
 * long           Long
 * float          Float
 * double         Double
 * char           Character
 * boolean        Boolean
 *
 * 装箱：从基本类型转换为对应的包装类型
 * 构造方法：
 * Integer(int value) 构造一个新分配的 Integer 对象，它表示指定的 int 值。
 * Integer(String s) 构造一个新分配的 Integer 对象，它表示 String 参数所指示的 int 值。
 * 静态方法：
 * static Integer valueOf(String s) 返回保存指定的 String 的值的 Integer 对象。
 * static Integer valueOf(int i) 返回一个表示指定的 int 值的 Integer 实例。
 *
 * 拆箱：从包装类对象转换为对应的基本类型
 *
 * 自动装箱与拆箱
 * 从Java 5 开始，基本类型与包装类的装箱、拆箱动作可以自动完成
 */
public class IntegerTest {

    public static void main(String[] args) {

        // 装箱：基本类型 -->  包装类
        // 构造方法
        Integer int1 = new Integer(1); // 已过时
        System.out.println(int1); // 重写了 toString 方法

        Integer int2 = new Integer("2");  // 已过时
        System.out.println(int2);

        // 静态方法
        Integer int3 = Integer.valueOf(3);
        System.out.println(int3);

        Integer int4 = Integer.valueOf("4");
        System.out.println(int4);

        // 拆箱：包装类 --> 基本类型
        int in2 = int2.intValue();
        System.out.println(in2);

        // 自动装箱
        Integer int5 = 5;
        // 自动拆箱
        int5 = int5 + 2; // 相当于 int5.intValue() + 2
        System.out.println(int5);

        // ArrayList 集合不能直接存储整数，可以存储 Integer 包装类
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            // 自动装箱
            list.add(i);
        }
        System.out.println(list); // [0, 1, 2, 3, 4]
        // 自动拆箱
        int a = list.get(0); // 取出来的是 Integer 类型数据，自动拆箱为 int 类型

    }
}

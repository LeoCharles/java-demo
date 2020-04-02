package demo05;

import java.util.Objects;

/**
 * throw 关键字
 *
 * 使用 throw 关键字在指定的方法中抛出指定的异常
 *
 * 格式：
 * ，。/throw new xxxException("异常产生的元素");
 *
 * 注意：
 * 1. throw 关键字必须写在方法的内部
 * 2. throw 关键字后面 new 的对象必须是 Exception 对象或者子类对象
 * 3. throw 关键字抛出 RuntimeException 对象或者子类对象，可以不处理，交给 JVM 处理(中断程序，打印出异常对象)
 * 4. throw 关键字抛出编译期异常，必须处理(try...catch 或者 throws)
 *
 * 在实际工作中，首先要对方法的参数进行合法性校验，如果参数不合法，需要抛出异常
 *
 * public static <T> T requireNonNull(T obj):查看指定引用对象不是 null。
 *
 */
public class ThrowTest {
    public static void main(String[] args) {

        // 测试方法参数异常
        int[] arr = {1, 2, 3, 4, 5};
        int e = getElement(arr, 4);
        System.out.println(e);

        // 测试非空异常
//        getObject(null);

    }
    // 对方法的参数进行合法性校验
    public static int getElement(int[] arr, int idx) {
        // 对 arr 进行非空校验
        if (arr == null) {
            // 空指针异常是运行期异常，可以不处理
            throw new NullPointerException("传递的数组是 null");
        }
        // 判断 idx 是否越界
        if(idx < 0 || idx > arr.length - 1) {
            // 数组索引越界异常是运行期异常，可以不处理
            throw new ArrayIndexOutOfBoundsException("传递的数组索引超出了使用范围");
        }
        return arr[idx];
    }

    // 使用 Objects 的静态方法进行 参数非空校验
    public static void getObject(Object obj) {

//        Objects.requireNonNull(obj);
        Objects.requireNonNull(obj, "传递的对象是 null");

        System.out.println(obj);
    }
}

package demo03;

/**
 * 可变参数，jdk 1.5 新特性
 *
 * 当方法的参数列表数据类型已经确定，但是参数的个数不确定，就可以使用可变参数
 *
 * 格式：
 * 修饰符 返回值类型 方法名(数据类型...形参名) { }
 *
 * 特殊写法：
 * public static void method(Object...obj) { }
 *
 * 原理：
 * 可变参数底层是一个数组，根据传递参数个数不同，会创建不同长度的数组，来存储这些参数。
 *
 * 注意：
 * 一个方法的参数列表，只能有一个可变参数
 * 如果一个方法拥有多参数，可变参数一定要写在参数列表的末尾位置
 *
 *
 */
public class VarArgsTest {
    public static void main(String[] args) {

        int sum = getSum(1, 2, 3, 4, 5);
        System.out.println(sum);
    }

    // 数据类型确定，但是参数个数不定，可以用可变参数
    // 可变参数底层是一个数组
    private static int getSum(int... arr) {
        System.out.println(arr);
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        return sum;
    }
}

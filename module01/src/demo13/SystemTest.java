package demo13;

import java.util.Arrays;

/**
 * 系统类
 * java.lang.System 类提供了获取、操作与系统相关的信息
 *
 * public static long currentTimeMillis()：返回以毫秒为单位的当前时间。
 *
 * public static void arraycopy()：将数组中指定的数据拷贝到另一个数组中。
 * 参数：
 * Object src：原数组
 * int srcPos：起始索引
 * Object dest：目标数组
 * int destPos：目标数组起始索引
 * int length： 要复制的数组元素个数
 *
 *
 */
public class SystemTest {

    public static void main(String[] args) {

        // 获取当前时间毫秒数
        System.out.println(System.currentTimeMillis());

        // 数组中指定的数据复制到另一个数组中
        // 原数组
        int[] src = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        // 目标数组
        int[] dest = {10, 20, 30, 40, 50};
        System.out.println("复制前：" + Arrays.toString(dest)); // [10, 20, 30, 40, 50]
        // 使用 arraycopy 方法
        System.arraycopy(src, 0, dest, 0, 3);
        System.out.println("复制后：" + Arrays.toString(dest)); // [1, 2, 3, 40, 50]


    }
}

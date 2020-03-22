package demo02;

import java.util.Arrays;

/**
 * java.util.Arrays 是一个和数组相关的工具类，提供了大量数组操作的静态方法
 *
 * public static String toSting()：将数组转换成字符串
 *
 * public static void sort(): 按默认升序（从小到大）将数组排序
 * 备注：
 * 1.如果是字符串默认按字母升序
 * 2.如果是自定义类型，那这个自定义的类需要有 Comparable 或 Comparator 接口支持。
 */
public class ArraysTest {
    public static void main(String[] args) {

        int[] intArr1 = {3, 2, 6, 7, 1, 9};

        // toSting 将数组转换成字符串
        String str1 = Arrays.toString(intArr1);
        System.out.println(str1); // [3, 2, 6, 7, 1, 9]

        // sort 将数组按升序排序
        int[] intArr2 = {2, 9, 2, 4, 1, 5, 2, 6};
        Arrays.sort(intArr2); // 没有返回值
        System.out.println(Arrays.toString(intArr2)); // [1, 2, 2, 2, 4, 5, 6, 9]

        String[] arr3 = {"aaa", "vvv", "cc", "dd", "b"};
        Arrays.sort(arr3);
        System.out.println(Arrays.toString(arr3)); // [aaa, b, cc, dd, vvv]

        // 将随机字符串中的所有字符升序排序，并倒叙打印
        String str = "sd2ix2wo3ddd21wva1e23sd2";
        // 字符串 --> 数组  toCharArray
        char[] charArr = str.toCharArray();
        Arrays.sort(charArr);
        // 倒序打印
        for (int i = charArr.length - 1; i >= 0; i--) {
            System.out.print(charArr[i]);
        }
    }
}

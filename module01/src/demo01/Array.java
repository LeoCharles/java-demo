package demo01;

import java.util.Arrays;

public class Array {
    public static void main(String[] args) {

        // 动态初始化数组
        char[] arr0 = new char[10];
        int[] arr1 = new int[10];
        double[] arr2 = new double[5];
        String[] arr3 = new String[50];

        // 静态初始化
        float[] arr4 = new float[] {1.2F, 3.4F, 3.11F};
        String[] arr5 = new String[] {"hello", "java"};
        // 省略格式
        Long[] arr6 = {1L, 2L, 4L};


        // 直接打印数组名称，得到的是内存地址哈希值
        System.out.println(arr1);
        System.out.println(arr2);
        System.out.println(arr3);
        System.out.println(arr4);
        System.out.println(arr5);

        System.out.println("============");

        // 访问数组内部元素
        // 动态初始化的数组
        System.out.println(arr0[3]); // 空字符 '\u0000'
        System.out.println(arr1[3]); // 0
        System.out.println(arr2[2]); // 0.0
        System.out.println(arr3[4]); // null
        // System.out.println(arr0[10]); // 异常 Index 10 out of bounds for length 10
        // 静态初始化的数组
        System.out.println(arr4[1]); // 3.4
        System.out.println(arr5[0]); // hello
        System.out.println(arr6[2]); // 4

        System.out.println("============");

        // 数组赋值
        arr0[0] = 'b';
        System.out.println(arr0[0]); // b

        String[] arr7 = arr5;
        System.out.println(arr7[0]);

        System.out.println("============");

        // 获取数组长度
        System.out.println(arr4.length); // int 的数字表示数组的长度

        System.out.println("============");

        // 遍历数组
        for (int i = 0; i < arr4.length; i++) {
            System.out.println(arr4[i]);
        }

        System.out.println("============");

        for (int i = 0; i < arr5.length; i++) {
            System.out.println(arr5[i]);
        }

        System.out.println("============");

        // 求数组最大值
        float m = arr4[0];
        for (int i = 1; i < arr4.length; i++) {
            if (arr4[i] > m) {
                m = arr4[i];
            }
        }
        System.out.println("arr4 最大值为：" + m);


        System.out.println("============");

        int[] arr = {2, 34, 22, 52, 44, 49, 22, 97, 52};
        printArray(arr);

        // 数组反转
        for (int min = 0, max = arr.length - 1; min < max; min++, max --) {
            int temp = arr[min];
            arr[min] = arr[max];
            arr[max] = temp;
        }
        printArray(arr);

        // 返回的是一个地址
        int[] res = calculate(3, 4, 9);
        System.out.println("三个数总和为：" + res[0]);
        System.out.println("三个数平均值为：" + res[1]);


    }

    /**
     * 打印数组元素
     * @param arr
     */
    public static void printArray(int [] arr) {
        System.out.println(arr); // 传递进去的是地址

        // 面向过程
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                System.out.println(arr[i] + "]");
            } else {
                System.out.print(arr[i] + ", ");
            }
        }

        System.out.println("===========");

        // 面向对象
        // 使用 jdk 提供的 Arrays 类 提供的 toString 方法
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 返回三个数的总和和平均值
     * @param a
     * @param b
     * @param c
     * @return
     */
    public static int[] calculate(int a, int b, int c) {
        int sum = a + b + c;
        int avg = sum / 3;
        // 返回一个数组
        int[] arr = {sum, avg};
        return arr;
    }
}

package demo00;

public class DataType {
    public static void main(String[] args) {
        System.out.println(1024); // 默认是 int 类型
        System.out.println(3.14); // 默认是 double 类型

        // int --> long 数据范围从小到大，可以自动转换
        long num1 = 100;
        System.out.println(num1);

        // float --> double 数据范围从小到大，可以自动转换
        double num2 = 2.5F;
        System.out.println(num2);

        // long --> float  数据范围从小到大，可以自动转换
        float num3 = 30L;
        System.out.println(num3); // 30.0

        // long --> int 数据范围从大到小，不能自动转换，需要强制转换
        // 格式：范围小的类型 范围小的变量名 = (范围小的类型) 原本范围大的数据;
        int num4 = (int) 250L;  // 强制类型转换
        System.out.println(num4);

        // long --> int 数值超出了 int 的范围，强制转换会造成数据溢出
        int num5 = (int) 6000000000L;
        System.out.println(num5); // 1705032704

        // double --> int, 强制转换造成精度损失
        int num6 = (int) 3.99;  // 不是四舍五入，小数部分会全部去掉
        System.out.println(num6); // 3

        // byte short char 在计算时 首先被转换成 int 类型
        char char1 = 'A';
        System.out.println(char1 + 0); // 65 字符 A 被当作 65 处理了
        System.out.println(char1 + 1); // 66

        char char2 = '0';
        System.out.println(char2 + 0); // 48

        byte num7 = 70;
        byte num8 = 80;
        // byte + byte --> int + int --> int
        int result1 = num7 + num8; // 如果 result1 是 byte 类型则会报错
        System.out.println(result1);

        short num9 = 90;
        // byte + short --> int + int --> int --> short
        short result2 = (short) (num8 + num9); // byte short 先转换成 int 再被强制转换成short
        System.out.println(result2);

        char char3 = 'a';
        // char --> int
        int num10 = char3;
        System.out.println(num10); // 97

        char char4 = '国';
        System.out.println(char4 + 0); // 22269
    }
}

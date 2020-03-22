package demo00;

public class Operator {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        double c = 3.0;
        System.out.println(a + b); // 30
        System.out.println(a - b); // -10
        System.out.println(a * b); // 200
        // 对于整数表达式，除法用的是整除，结果只保留商，不保留余数
        System.out.println(a / b); // 0
        System.out.println(a % b); // 10 取模
        // int + double --> double + double --> double
        System.out.println(a + c); // 13.0
        System.out.println(a / c); // 3.3333333333333335

        String str1 = "hello";
        System.out.println(str1 + a); // hello10

        a += 6;
        System.out.println(a); // 16
        b %= 3;
        System.out.println(b); // 2

        byte num = 30;
        // 复合赋值运算符包含隐式类型转换
        // num = byte + int  --> num = int + int --> num = int --> num = (byte) int
        num += 5;
        System.out.println(num); // 35
    }
}

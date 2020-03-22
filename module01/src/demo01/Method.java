package demo01;

public class Method {
    public static void main(String[] args) {
        // 单独调用
        sum(3, 4);

        // 打印调用
        System.out.println(sum(10, 20));

        // 赋值调用
        int num = sum(12, 23);
        System.out.println(num);

        sum(11, 2.3);

        System.out.println(isSame(10, 10));

    }

    /**
     * 求和
     * @param a
     * @param b
     * @return
     */
    public static int sum(int a, int b) {
        return  a + b;
    }

    public static int sum(int a, double b) {
        return (int) (a + b);
    }

    /**
     * 判断是否相等
     * @param a
     * @param b
     * @return
     */
    public static boolean isSame(int a, int b) {
        return a == b;
    }

    // 方法重载
    public static void myPrint(byte num) {
        System.out.println(num);
    }

    public static void myPrint(short num) {
        System.out.println(num);
    }

    public static void myPrint(int num) {
        System.out.println(num);
    }

    public static void myPrint(long num) {
        System.out.println(num);
    }

    public static void myPrint(float num) {
        System.out.println(num);
    }

    public static void myPrint(double num) {
        System.out.println(num);
    }

    public static void myPrint(char num) {
        System.out.println(num);
    }

    public static void myPrint(boolean num) {
        System.out.println(num);
    }

    public static void myPrint(String num) {
        System.out.println(num);
    }

}

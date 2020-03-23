package demo13;

/**
 * 基本类型和字符串之间相互转换
 *
 * 基本类型 --> 字符串
 * 1.基本类型 + ""，最简单的方法
 * 2.包装类的静态方法 toString(参数)，重载了 Object 类的 toString
 * 3.String 类的静态方法 valueOf(参数)
 *
 * 字符串 --> 基本类型
 * 包装类的静态方法 parseXXXX("字符串");
 * Integer类：static int parseInt(Sting s);
 * Double类： static double parseDouble(Sting s);
 *
 *
 */
public class StringTest {

    public static void main(String[] args) {


        // 基本类型 --> 字符串
        int i1 = 100;
        String s1 = i1 + "";
        System.out.println(s1 + 200);

        String s2 = Integer.toString(200);
        System.out.println(s2 + 200);

        String s3 = String.valueOf(300);
        System.out.println(s3 + 200);

        // 字符串  -->  基本类型
        int int1 = Integer.parseInt(s1);
        System.out.println(int1 + 200);

    }
}

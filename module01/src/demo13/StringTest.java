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
 * public static byte parseByte(String s)：将字符串参数转换为对应的byte基本类型。
 * public static short parseShort(String s)：将字符串参数转换为对应的short基本类型。
 * public static int parseInt(String s)：将字符串参数转换为对应的int基本类型。
 * public static long parseLong(String s)：将字符串参数转换为对应的long基本类型。
 * public static float parseFloat(String s)：将字符串参数转换为对应的float基本类型。
 * public static double parseDouble(String s)：将字符串参数转换为对应的double基本类型。
 * public static boolean parseBoolean(String s)：将字符串参数转换为对应的boolean基本类型。
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
        int int1 = Integer.parseInt("100");
        System.out.println(int1);
        boolean bool1 = Boolean.parseBoolean("false");
        System.out.println(bool1);
        double dou1 = Double.parseDouble("3.3");
        System.out.println(dou1);
        byte by1 = Byte.parseByte("1");
        System.out.println(by1);
        long long1 = Long.parseLong("500");
        System.out.println(long1);
        short short1 = Short.parseShort("22");
        System.out.println(short1);

    }
}

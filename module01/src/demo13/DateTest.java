package demo13;

import java.util.Date;

/**
 * 日期类
 *
 * java.util.Date 类表示特定的瞬间，精确到毫秒
 * 0 毫秒： 1970年 1 月 1 日 00:00:00
 * 中国属于东八区，会把时间增加 8个小时
 * System.currentTimeMillis() 获取系统当前毫秒值
 *
 *
 * Date 类构造方法
 * 无参：Date() 获取系统当前的日期和时间
 * 有参：Date(毫秒数) 把当前的毫秒值转成日期对象
 *
 * getTime(): 获取自 1970 以来的毫秒数
 *
 *
 *
 */
public class DateTest {
    public static void main(String[] args) {

        // 获取系统当前毫秒值
        System.out.println(System.currentTimeMillis());

        // 无参构造，获取系统当前的日期和时间
        Date date1 = new Date();
        System.out.println(date1); // Sat Mar 21 16:44:12 CST 2020

        // 参数为毫秒值的构造方法，把当前的毫秒值转成日期对象
        Date date2 = new Date(0L);
        System.out.println(date2); // Thu Jan 01 08:00:00 CST 1970

        // 获取自 1970 以来的毫秒数
        long now = date1.getTime();
        System.out.println(now); // 1584780765510
    }
}

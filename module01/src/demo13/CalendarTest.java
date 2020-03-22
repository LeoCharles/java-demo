package demo13;

import java.util.Calendar;
import java.util.Date;

/**
 * 日历类
 *
 * java.util.Calendar 日历类是抽象类，提供了很多操作日历字段的方法
 *
 * Calendar 类在创建对象时并非直接创建，而是通过静态方法 getInstance 创建，返回子类对象
 * Calendar rightNow = Calendar.getInstance(); // 使用默认时区和语言环境获得一个日历
 *
 * 日历类的字段：
 * YEAR         年
 * MONTH        月（从0开始，可以 +1 使用）
 * DAY_OF_MONTH 月中的天（几号）
 * HOUR         时（12小时制）
 * HOUR_OF_DAY  时（24小时制）
 * MINUTE       分
 * SECOND       秒
 * DAY_OF_WEEK  周中的天（周几，周日为 1，可以 -1 使用）
 *
 * 成员方法
 * public int get(int field) ：返回给定日历字段的值。
 * public void set(int field, int value)：将给定的日历字段设置为给定值。
 * public abstract void add(int field, int amount)：根据日历的规则，为给定的日历字段添加或减去指定的时间量。
 * public Date getTime()：返回一个表示此Calendar时间值（从历元到现在的毫秒偏移量）的Date对象。
 *
 *
 */
public class CalendarTest {

    public static void main(String[] args) {

        // 获取日历类对象
        Calendar c = Calendar.getInstance(); // 多态
        System.out.println(c);

        // get 获取给定日历字段的值
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        System.out.println(year);
        System.out.println(month);
        System.out.println(day);

        // set 设置给定日历字段的值
        c.set(Calendar.MONTH, 6);
        System.out.println(c.get(Calendar.MONTH));
        // 同时设置年月日
        c.set(2038, 6, 19);
        System.out.println(c.get(Calendar.YEAR));
        System.out.println(c.get(Calendar.MONTH));
        System.out.println(c.get(Calendar.DAY_OF_MONTH));


        // add 将给定的字段增加或减少值
        c.add(Calendar.MONTH, 1);
        System.out.println(c.get(Calendar.MONTH));

        // getTime 将日历对象，转成日期对象
        Date date = c.getTime();
        System.out.println(date);
    }
}

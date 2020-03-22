package demo13;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * java.text.DateFormat 是日期/时间格式化子类的抽象类
 * 作用：进行日期时间格式化、解析和标准化。
 *
 * 成员方法：
 * String format(Date date)：将一个 Date 格式化为日期/时间字符串。
 * Date parse(String source)：把符合模式的字符串解析为日期。
 *
 * DateFormat 是一个抽象类，不能直接使用
 * 可以使用 DateFormat 类的子类 java.text.SimpleDateFormat
 *
 * SimpleDateFormat 类构造方法：
 * SimpleDateFormat(String pattern)：用给定的模式构造 SimpleDateFormat。
 * 模式： y 年；  M 月；  d 日；  H 时；  m 分；  s 秒，连接符可以改变
 */
public class DateFormatTest {

    public static void main(String[] args) throws ParseException {

        // 使用 DateFormat 类中 format 方法，把日期格式化为文本
        // 创建 SimpleDateFormat 对象
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 调用 format 方法，传递 date 类型参数
        Date date = new Date();
        String dateStr = sdf.format(date);
        System.out.println(date);    // Sat Mar 21 20:50:34 CST 2020
        System.out.println(dateStr); // 2020-03-21 20:50:34

        // 使用 DateFormat 类中 parse 方法，把文本解析为日期
        // 注意，如果字符串和构造方法的模式不一样，会抛出解析异常 ParseException
        Date parseDate = sdf.parse("2020-03-21 20:50:34");
        System.out.println(parseDate); // Sat Mar 21 20:50:34 CST 2020

        // 计算一个人出生了多少天
        getBirthday();
    }

    public static void getBirthday () throws ParseException {
        System.out.println("请输入出生日期，格式 yyyy-MM-dd");
        // 获取键盘输入的出生日期
        String birthdayString = new Scanner(System.in).next();

        // 创建 SimpleDateFormat
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        // 将字符串转成 data 对象
        Date birthdayDate = sdf.parse(birthdayString);

        // 获取今天的 data 对象
        Date todayDate = new Date();

        // 将 data 对象转成毫秒数
        long birthdayDateTime = birthdayDate.getTime();
        long todayDateTime = todayDate.getTime();
        long diff = todayDateTime - birthdayDateTime;

        // 毫秒数转成天数
        if (diff < 0) {
            System.out.println("还没出生呢");
        } else {
            long day = diff / 1000 / 60 / 60 / 24;
            System.out.println("你已经出生了" + day + "天");
        }

    }

}


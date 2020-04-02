package demo05;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 异常
 *
 * java.lang.Throwable 类 Java 语言中所有错误和异常的超类
 *
 * Exception: 编译期异常，子类 RuntimeException 运行期异常
 * Error: 错误
 *
 * 异常处理的五个关键字：try、catch、finally、throw、throws
 *
 */
public class ExceptionTest {
    public static void main(String[] args) {

//        testException();
//        testRuntimeException();
//        testError();


    }

    public static void testException() /*throws ParseException*/ {
        // 编译期异常
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = sdf.parse("2019-12-23");
            System.out.println(date);
        } catch (ParseException e) {
            e.printStackTrace(); // ParseException
        }
        System.out.println("后续代码");

    }

    public static void testRuntimeException() {
        int[] arr = {1, 2, 3};
        try {
            System.out.println(arr[3]);
        } catch (Exception e) {
            e.printStackTrace(); // ArrayIndexOutOfBoundsException
        }
        System.out.println("后续代码");
    }

    public static void testError() {
        // 内存溢出错误
//        int[] arr = new int[1024*1024*1024]; // OutOfMemoryError
        // 错误必须修改源代码才能解决
        int[] arr = new int[10];
        System.out.println(arr);
        System.out.println("后续代码");
    }

}

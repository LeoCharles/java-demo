package demo16;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * 简单的测试框架
 *
 * 测试用 @Check 注解标识的方法是否有异常
 *
 * 主方法执行后，会自动执行被检测的所有方法，记录到文件日志中
 */

public class TestCheck {
    public static void main(String[] args) throws IOException {
        // 1. 创建计算器对象
        Calculator c = new Calculator();

        // 2. 获取字节码文件对象
        Class<? extends Calculator> cls = c.getClass();

        // 3. 获取所有的方法
        Method[] methods = cls.getMethods();

        // 记录异常的个数
        int count = 0;

        // 记录异常的文件日志
        BufferedWriter bw = new BufferedWriter(new FileWriter("module02\\src\\demo16\\bug.txt"));

        for (Method method : methods) {
            // 4. 判断方法上是否有 @Check 注解
            if (method.isAnnotationPresent(Check.class)) {
                // 5. 如有有，则执行方法
                try {
                    method.invoke(c);
                } catch (Exception e) {
                    // 6. 捕获异常，记录到文件日志中
                    count ++;

                    bw.write(method.getName() + " 方法发生了异常");
                    bw.newLine();
                    bw.write("异常的名称：" + e.getCause().getClass().getSimpleName());
                    bw.newLine();
                    bw.write("异常的原因：" + e.getCause().getMessage());
                    bw.newLine();
                    bw.write("-------------------------------------");
                    bw.newLine();
                }
            }
        }

        bw.write("本次测试一共出现了 " + count + " 次异常");

        bw.flush();
        bw.close();
    }
}

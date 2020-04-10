package demo08;

import java.io.File;

/**
 * 递归：方法自己调用自己
 *
 * 当调用方法的时候，方法的主体不变，每次方法的参数不同，可以使用递归
 *
 * 注意事项：
 * 1. 递归一定要有条件限制，确保递归能够停止，否则会发生栈内存溢出
 * 2. 递归次数不能太多，否则也会发生栈内存溢出
 * 3. 构造方法禁止递归
 *
 */
public class RecursiveTest {
    public static void main(String[] args) {
//        System.out.println(sum(100));
//        System.out.println(factorial(5));
//        getAllFile(new File("E:\\Java\\java-demo\\module02"));
        getAllJavaFile(new File("E:\\Java\\java-demo\\module02"));


    }

    // 递归计算 1 到 n 的和， n + (n-1) + (n-2) + ... + 1
    // 递归的目的：获取到下一个被加的数字，递归结束条件：加到 1 的时候结束
    public static int sum(int n) {
        // 结束条件
        if (n == 1) {
            return 1;
        }
        return n + sum(n - 1);
    }

    // 使用递归计算阶乘
    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    // 递归打印多级目录
    public static void getAllFile(File dir) {
        System.out.println(dir);
        File[] files = dir.listFiles();
        for (File f : files) {
            // 如果是文件夹，继续遍历
            if (f.isDirectory()) {
                getAllFile(f);
            } else {
                System.out.println(f);
            }
        }
    }

    // 文件搜索，只遍历 .java 结尾的文件
    // 把 File 对象转换为 String 对象，调用 String 对象的 endWith 方法
    public static void getAllJavaFile(File dir) {
        File[] files = dir.listFiles();
        for (File f : files) {
            if (f.isDirectory()) {
                getAllJavaFile(f);
            } else {
                // 把 File 对象转换为 String，并统一改为小写
                String s = f.toString().toLowerCase();
                // 判断后缀名是否为 .java
                boolean b = s.endsWith(".java");
                if(b) {
                    System.out.println(f);
                }
            }
        }
    }


}

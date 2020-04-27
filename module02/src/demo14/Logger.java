package demo14;

/**
 * 日志
 *
 * 使用 Lambda 优化日志，延迟加载
 *
 * 使用 Lambda 的前提必须有函数式接口
 *
 *
 *
 */
public class Logger {
    public static void main(String[] args) {
        // 定义 3 个日志信息
        String s1 = "info message";
        String s2 = "warning message";
        String s3 = "error message";

        // 调用 showLog 方法，参数传入 Lambda 表达式
        showLog(1, () -> s1 + s2 + s3);


    }

    // 根据日志级别显示日志信息，传入日志等级和 MessageBuilder 接口
    private static void showLog(int level, MessageBuilder mb) {

        // 如果日志等级是 1 级，调用 MessageBuilder 中的 buildMessage 方法
        if (level == 1) {
            // 只有满足条件，才会调用接口中的方法
            System.out.println(mb.buildMessage());
        }
    }
}

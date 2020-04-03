package demo05;

/**
 * 自定义异常类
 *
 * 格式：
 * public class xxxException extends Exception / RuntimeException {
 *   空参构造
 *   带异常信息的构造方法
 * }
 *
 * 注意：
 * 1. 自定义异常类都是以 Exception 结尾
 * 2. 自定义异常类必须继承 Exception 或 RuntimeException
 *
 *
 */
public class RegisterException extends Exception {
    // 无参构造
    public RegisterException() {
    }
    // 带异常信息的构造方法
    public RegisterException(String message) {
        super(message);
    }
}

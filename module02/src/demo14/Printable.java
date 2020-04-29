package demo14;

/**
 * 自定义打印接口
 */

@FunctionalInterface
public interface Printable {

    // 抽象方法，打印字符串
    public abstract void print(String str);
}

package demo16;

/**
 * Annotation 注解是放在Java源码的类、方法、字段、参数前的一种特殊“注释说明”
 *
 * 注释会被编译器直接忽略，注解则可以被编译器打包进入 class文件，因此，注解是一种用作标注的元数据
 *
 * 注解可以分为三类：
 * 由编译器使用的注解，这类注解不会被编译进入.class文件，它们在编译后就被编译器扔掉了
 * 由工具处理 .class 文件时使用，这类注解会被编译进入.class文件，但加载结束后并不会存在于内存中。
 * 程序运行期能够读取的注解，这些注解在加载后一直存在于 JVM 中。
 *
 * JDK 中预定义的一些注解
 * `@Override`：让编译器检查该方法是否正确地实现了覆写
 * `@SuppressWarnings`：压制编译器警告
 * `@Deprecated`：该注解标识的内容表示已过时
 *
 * 自定义注解
 *
 * 格式：
 *  元注解
 *  public @interface 注解名称 {}
 *
 * 本质：注解本质是一个接口，继承自 java.lang.annotation.Annotation
 * 属性：接口中可以定义的成员方法
 *
 *
 */

public class AnnotationTest {
    public static void main(String[] args) {

    }
}

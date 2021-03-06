package demo16;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

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
 *
 * 元注解：用来修饰其他注解的注解
 *
 * `@Target`：描述注解能够被应用于源码的哪些位置：
 *
 * 类或接口：ElementType.TYPE
 * 字段：ElementType.FIELD
 * 方法：ElementType.METHOD
 * 构造方法：ElementType.CONSTRUCTOR
 * 方法参数：ElementType.PARAMETER
 *
 * `@Retention`：描述注解的生命周期：
 *
 * 仅编译期：RetentionPolicy.SOURCE
 * 仅class文件：RetentionPolicy.CLASS
 * 运行期：RetentionPolicy.RUNTIME
 *
 * 如果 @Retention不存在，则该注解默认为 CLASS
 * 自定义的注解通常都是 RUNTIME，所以，要加上 @Retention(RetentionPolicy.RUNTIME) 这个元注解
 *
 * `@Repeatable`：描述注解是否可重复
 * `@Documented`：描述注解是否被抽取到 API 文档中
 * `@Inherited`：描述子类是否可继承父类定义的注解
 *
 * 使用反射技术读取注解的方法
 *
 * 读取注解步骤:
 * 1. 获取注解描述的对象，如 Class、Method、Field
 * 2. 获取指定的注解
 *  Class.getAnnotation(Class)
 *  Field.getAnnotation(Class)
 *  Method.getAnnotation(Class)
 *  Constructor.getAnnotation(Class)
 * 3. 调用注解中的抽象方法获取配置的属性值
 *
 * 判断某个注解是否存在于 Class、Field、Method或 Constructor：
 * Class.isAnnotationPresent(Class)
 * Field.isAnnotationPresent(Class)
 * Method.isAnnotationPresent(Class)
 * Constructor.isAnnotationPresent(Class)
 *
 */

@Prop(className = "demo16.Person", methodName = "sayHello")
public class AnnotationTest {
    public static void main(String[] args) throws Exception {
        testAnnotation();
        useReflect();
    }

    // 使用自定义注解，使用反射技术获取读取注解数据
    @MyAnno(value = "test", type = 1, level = "message")
    public static void testAnnotation() throws NoSuchMethodException {
        // 获取 class 对象
        Class<AnnotationTest> annotationTestClass = AnnotationTest.class;

        // 获取方法
        Method testAnnotation = annotationTestClass.getMethod("testAnnotation");

        // 读取注解
        MyAnno an = testAnnotation.getAnnotation(MyAnno.class);
        String value = an.value();
        System.out.println(value);
    }

    // 使用解析获取配置信息
    public static void useReflect() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // 获取该类的字节码文件对象
        Class<AnnotationTest> annotationTestClass = AnnotationTest.class;
        // 获取注解，在内存中生成了一个该注解接口的的子类对象，实现了注解的抽象方法
        Prop an = annotationTestClass.getAnnotation(Prop.class);
        // 调用注解对象中定义的方法，获取返回值
        String className = an.className();
        String methodName = an.methodName();

        // 加载该类进内存
        Class<?> cls = Class.forName(className);

        // 创建对象
        Object obj = cls.getDeclaredConstructor().newInstance();

        // 获取方法对象
        Method method = cls.getDeclaredMethod(methodName);

        // 执行方法
        method.invoke(obj);
    }
}

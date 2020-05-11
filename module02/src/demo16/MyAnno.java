package demo16;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解
 *
 * 注解本质是一个接口，继承自 java.lang.annotation.Annotation
 *
 * 格式：
 *
 * 元注解
 * public @interface 注解名称 {
 *     属性类型 属性名() default 默认值
 * }
 *
 * 注解的属性类似无参方法，可以用 default 设一个默认值。
 *
 * 最常用的属性应当命名为 value，使用时，可以省略 value
 *
 * 属性的返回值类型：基本数据类型、String、枚举、注解，以及以上类型的数组
 *
 * 数组类型的属性赋值时，使用大括号，如果只有一个值，大括号可以省略
 *
 */

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnno {
    // 返回值类型：基本数据类型、String、枚举、注解，以及以上类型的数组
    int type() default 0;
    String level() default "info";
    String value() default "";
}

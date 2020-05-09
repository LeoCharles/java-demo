package demo16;

import javax.lang.model.element.Element;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解
 *
 * 注解本质是一个接口，继承自 java.lang.annotation.Annotation
 *
 * 注解的参数类似无参方法，可以用 default 设一个默认值。最常用的参数应当命名为 value
 *
 * 格式：
 *
 * 元注解
 * public @interface 注解名称 {}
 *
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnno {
    int type() default 0;
    String level() default "info";
    String value() default "";
}

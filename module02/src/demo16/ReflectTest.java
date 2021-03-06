package demo16;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 反射：将类的各个组成部分封装为其他对象，这就是反射机制
 *
 * 反射是框架设计的灵魂
 *
 * Java 代码在计算机中经历的三个阶段：
 *
 * Source 源代码阶段 --(反射)-->  Class 类对象阶段  --->   Runtime 运行时阶段
 *
 * 成员变量封装成 Field[] 数组
 * 构造方法封装成 Constructor[] 数组
 * 成员方法封装成 Method[] 数组
 *
 * 这种通过Class实例获取class信息的方法称为反射（Reflection）。
 *
 * 获取 Class 对象的方式：
 *
 * 1. Class.forName(全类名)：将字节码文件加载进内存，返回 Class 对象。
 *    用于读取配置文件(将类名、方法名定义在配置文件中)，加载类
 *
 * 2. 类名.class：通过类名的属性 class 获取。
 *    用于参数的传递
 *
 * 3. 对象.getClass()：getClass方法继承自 Object 类。
 *    用于对象获取字节码
 *
 * 同一个字节码文件(*.class)在一次程序运行过程中，只会被加载一次，三种方式获取的 Class 对象都是同一个
 *
 * java.lang.Class 类对象
 *
 * Class 类对象的功能：
 *
 * 获取全类名：
 * String getName()
 *
 * 获取成员变量：
 * Field[] getFields() ：获取所有 public 修饰的成员变量
 * Field getField(String name)：获取指定名称的 public 修饰的成员变量
 * Field[] getDeclaredFields()：获取所有的成员变量，不考虑修饰符
 * Field getDeclaredField(String name)：获取指定名称的，不考虑修饰符的成员变量
 *
 * 获取构造方法：
 * Constructor<>[] getConstructors()：获取所有 public 修饰的构造方法
 * Constructor<T> getConstructor(类<>... parameterTypes): 获取某个参数类型的 public 修饰的构造方法
 * Constructor<>[] getDeclaredConstructors()：获取所有的构造方法
 * Constructor<T> getDeclaredConstructor(类<>... parameterTypes)：获取某个参数类型的构造方法
 *
 *
 * 获取成员方法：
 * Method[] getMethods()：获取所有 public 修饰的成员方法，包括父类
 * Method getMethod(String name, 类<>... parameterTypes)：获取某个 public 修饰的成员方法，包括父类
 * Method[] getDeclaredMethods()：获取所有成员方法，不包括父类
 * Method getDeclaredMethod(String name, 类<>... parameterTypes)：获取某个成员方法，不包括父类
 *
 *
 * 暴力反射：
 * void	setAccessible​(boolean flag)：忽略访问权限修饰符的安全检测
 *
 * java.lang.reflect.Field：字段对象
 * void set(Object obj, Object value)：设置值
 * Object get(Object obj)：获取值
 *
 * java.lang.reflect.Constructor<T>：构造器对象
 * T newInstance​(Object... args): 创建实例
 *
 * java.lang.reflect.Method：方法对象
 * Object invoke​(Object obj, Object... args)：调用方法
 * getName()：获取方法名称
 * getReturnType()：获取方法返回值类型，也是一个Class实例，例如：String.class；
 * getParameterTypes()：返回方法的参数类型，是一个 Class 数组，例如：{String.class, int.class}；
 *
 *
 *
 */

public class ReflectTest {
    public static void main(String[] args) throws Exception {
        getClassObj();
//        getFields();
//        useField();
//        getConstructor();
//        getMethod();

    }

    // 获取 Class 类对象
    public static void getClassObj() throws ClassNotFoundException {
        // 1. Class.forName(全类名)
        Class<?> cls1 = Class.forName("demo16.Person");
        System.out.println(cls1); // class demo16.Person

        // 2. 类名.class
        Class<Person> cls2 = Person.class;
        System.out.println(cls2); // class demo16.Person

        // 3. 对象.getClass()
        Person p = new Person();
        Class<? extends Person> cls3 = p.getClass();
        System.out.println(cls3); // class demo16.Person

        // 同一个字节码文件(*.class)在一次程序运行过程中，只会被加载一次
        // 无论是通过那种方式获取的 Class 对象都是同一个
        System.out.println(cls1 == cls2); // true
        System.out.println(cls1 == cls3); // true
    }

    // 获取成员变量
    public static void getFields() throws NoSuchFieldException {
        // 获取 Person 类的 Class 对象
        Class<Person> personClass = Person.class;

        // 获取 public 修饰的成员变量
        Field[] fields = personClass.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }

        // 获取指定 name 的 public 修饰的成员变量
        Field label = personClass.getField("label");
        System.out.println(label);

        // 获取所有的成员变量
        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field field : declaredFields) {
            System.out.println(field);
        }

        // 获取指定 name 的成员变量对象
        Field name = personClass.getDeclaredField("name");
        System.out.println(name);

    }

    // 获取/设置成员变量的值
    public static void useField() throws NoSuchFieldException, IllegalAccessException {
        // 获取 Person 类的 Class 对象
        Class<Person> personClass = Person.class;
        Person p = new Person();

        Field label = personClass.getField("label");
        Field name = personClass.getDeclaredField("name");


        // 设置 public 修饰的成员变量的值
        label.set(p, "test");
        // 设置 public 修饰的成员变量的值
        Object value1 = label.get(p);
        System.out.println(value1);

        // 访问私有的成员变量会抛异常，需要忽略访问权限修饰符的安全检测(暴力反射)
        name.setAccessible(true);
        Object value2 = name.get(p);
        System.out.println(value2);
    }

    // 获取构造器
    public static void getConstructor() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // 获取 Person 类的 Class 对象
        Class<Person> personClass = Person.class;

        // 获取不同参数的构造器
        Constructor<Person> constructor = personClass.getConstructor(String.class, int.class);
        System.out.println(constructor);

        // 获取所有的构造器
        Constructor<?>[] declaredConstructors = personClass.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor);
        }

        // 创建对象
        Person leo = constructor.newInstance("Leo", 23);
        System.out.println(leo);

        // 如果要使用私有的构造器，需要暴力反射
        constructor.setAccessible(true);
    }

    // 获取成员方法
    public static void getMethod() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // 获取 Person 类的 Class 对象
        Class<Person> personClass = Person.class;

        // 获取 public 修饰的成员方法，包括父类的
        Method[] methods = personClass.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }

        // 获取所有成员方法，不包括父类
        Method[] declaredMethods = personClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);
            // 获取方法名
            String name = declaredMethod.getName();
            System.out.println(name);
        }

        // 获取指定 name 的方法对象
        Method sayHello = personClass.getMethod("sayHello");
        Method print = personClass.getMethod("print", String.class);
        Method sayHi = personClass.getDeclaredMethod("sayHi");

        // 调用方法，需要传递对象，和参数
        Person person = new Person();
        sayHello.invoke(person);
        print.invoke(person, "你好");

        // 要使用私有方法，需要暴力反射
        sayHi.setAccessible(true);
        sayHi.invoke(person);
    }
}

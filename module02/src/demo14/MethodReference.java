package demo14;

/**
 * 方法引用
 *
 * 如果 Lambda 要表达的函数方案已经存在于某个方法的实现中，那么可以通过双冒号来引用该方法作为 Lambda 的替代者。
 *
 * 双冒号 :: 为引用运算符，而它所在的表达式被称为方法引用。
 *
 * Lambda表达式写法： s -> System.out.println(s)
 * 方法引用写法： System.out::println
 *
 * 注意：Lambda 中传递的参数，一定是方法引用中的那个方法可以接收的类型，否则会抛出异常
 *
 * 通过对象名，引用成员方法
 * 如果一个类中已经存在了一个成员方法，则可以通过对象名引用成员方法
 * 格式：对象名::method
 *
 * 通过类名，引用静态成员方法
 * 如果一个类中已经存在了一个静态方法，则可以通过对象名引用静态方法
 * 格式：类名::method
 *
 * 通过 super 引用成员方法
 * 如果存在继承关系，当 Lambda 中需要出现 super 调用时，也可以使用方法引用进行替代。
 * 格式：super::method
 *
 * 通过this引用成员方法
 * 如果需要引用的方法就是当前类中的成员方法，那么可以使用 this 来方法引用
 * 格式：this::成员方法
 *
 * 类的构造器引用
 * 由于构造器的名称与类名完全一样，可以使用 new 来引用
 * 格式：类名::new
 *
 * 数组的构造器引用
 * 数组也是 Object 的子类对象，所以同样具有构造器，只是语法稍有不同。
 * 格式：int[]::new
 *
 *
 */

public class MethodReference {
    public static void main(String[] args) {
        // 参数经过 Lambda 表达式传递给 System.out.println 方法去处理
        printString("Hello World", str -> System.out.println(str));

        // 直接让 System.out 对象中的 println 方法来取代 Lambda
        printString("Hello World", System.out::println);

        // 传入 Lambda 表达式
        int abs1 = getAbs(-20, (num) -> {
            // 对参数进行绝对值计算
            return Math.abs(num);
        });
        System.out.println(abs1);

        // 通过类名 Math 引用静态方法 abs
        int abs2 = getAbs(-20, Math::abs);
        System.out.println(abs2);

    }


    // 打印字符串
    public static void printString(String str, Printable p) {
        p.print(str);
    }

    // 计算绝对值整数
    public static int getAbs(int num, Calcable c) {
        return c.calcAbs(num);
    }
}

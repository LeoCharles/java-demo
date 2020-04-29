package demo14;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * 函数式接口：有且只有一个抽象方法的接口，称之为函数式接口
 *
 * 使用：作为方法的参数和返回值类型
 *
 * java.util.function 包，提供了很多函数式接口
 *
 * 常用的函数式接口：
 *
 * java.util.function.Supplier<T> 接口是生产型接口，用来获取一个泛型参数指定类型的对象数据。
 * 抽象方法：T get()，获取结果。
 *
 * java.util.function.Consumer<T> 接口则正好与 Supplier 接口相反，它不是生产一个数据，而是消费一个数据，其数据类型由泛型决定。
 * 抽象方法：void accept(T t)，意为消费一个指定泛型的数据。
 * 默认方法：andThen，把两个 Consumer 接口组合到一起，再对数据进行消费。con1.andThen(con2).accept()，写在前面的先消费。
 *
 * java.util.function.Predicate<T> 接口，对某种数据类型的数据进行判断，结果返回一个布尔值。
 * 抽象方法：boolean test(T t)，用于对指定数据类型的数据进行判断的方法。
 * 默认方法：and，与
 * 默认方法：or，或
 * 默认方法：negate，取反
 *
 * java.util.function.Function<T,R> 接口用来根据一个类型的数据得到另一个类型的数据，前者称为前置条件，后者称为后置条件。
 * 抽象方法：R apply(T t)，根据类型 T 的参数获取类型 R 的结果。
 * 默认方法：andThen，把两个 Function 接口组合在一起。
 *
 */

public class MainTest {
    public static void main(String[] args) {
//        testLambda();
//        getMax();
//        testConsumer();
//        testPredicate();
//        changeType();
    }

    // 测试 Lambda 表达式
    public static void testLambda() {
        // 参数传入实现类对象
        testFunctional(new MyFunctionalInterfaceImpl());

        // 参数传入接口的匿名内部类
        testFunctional(new MyFunctionalInterface() {
            @Override
            public void myAbstractMethod() {
                System.out.println("使用匿名内部类重写接口中的抽象方法");
            }
        });

        // 参数使用 Lambda 表达式
        testFunctional(() -> {
            System.out.println("使用 Lambda 表达式重写接口中的抽象方法");
        });

        // 简化 Lambda 表达式
        testFunctional(() -> System.out.println("简化 Lambda 表达式"));
    }

    // 参数使用函数式接口
    public static void testFunctional(MyFunctionalInterface myInter) {
        myInter.myAbstractMethod();
    }

    // 参数的返回值是类型是一个接口，用于生产数据
    public static Comparator<String> getComparator() {
        // 返回值类型是一个函数式接口
//        return new Comparator<String>() {
//            @Override
//            public int compare(String s1, String s2) {
//                return s2.length() - s1.length();
//            }
//        };

        // 返回值类型是一个函数式接口，可以返回一个 Lambda 表达式
        return (s1, s2) -> s2.length() - s1.length();
    }

    // 参数传入一个 Supplier<Integer> 接口
    public static int useSupplier(Supplier<Integer> supplier) {
        // 使用 get 方法获取一个指定类型的数据，具体如何生产数据，使用 Lambda 实现
        return supplier.get();
    }

    // 获取数组中最大值
    public static void getMax() {

        int[] numbers = {22, 14, -12, 33, 93};

        // 传入 Supplier 接口
        int maxValue = useSupplier(() -> {
            int max = numbers[0];
            for (int num : numbers) {
                if (num > max) {
                    max = num;
                }
            }
            return max;
        });
        System.out.println("数组最大值是：" + maxValue);
    }

    // 参数传递 Consumer 接口，用来消费数据
    public static void useConsumer(String str, Consumer<String> con1, Consumer<String> con2) {
        // 使用 andThen 连接两个 Consumer 接口，先执行 con1 消费数据，在执行 con2 进行消费
        con1.andThen(con2).accept(str);
    }

    // 打印信息，参数传入 String 类型的数组和两个 Consumer 接口
    public static void printInfo(String[] arr, Consumer<String> con1, Consumer<String> con2) {
        for (String s : arr) {
            con1.andThen(con2).accept(s);
        }
    }

    public static void testConsumer() {
        // 消费指定的字符串
        useConsumer("Hello World",
                (str) -> {
                    System.out.println("小写形式：" + str.toLowerCase());
                },
                (str) -> {
                    System.out.println("大写形式：" + str.toUpperCase());
                });

        // 消费指定的数据
        String[] infoArr = {"Leo,15,男", "Eve,30,女", "Rex,23,男", "Tom,19,男"};
        printInfo(infoArr,
                (s) -> {
                    String name = s.split(",")[0];
                    System.out.print("姓名：" + name);
                },
                (s) -> {
                    String age = s.split(",")[1];
                    System.out.println(", 年龄：" + age);
                });
    }

    // 使用 Predicate 中的 test 方法，返回判断的结果
    public static boolean usePredicate(String str, Predicate<String> pred1, Predicate<String> pred2) {
        // add: 与 ，  or: 或， negate: 取反
        return pred1.or(pred2).test(str) ;
    }

    // 过滤信息
    public static ArrayList<String> filterInfo(String[] arr, Predicate<String> pred1, Predicate<String> pred2) {
        ArrayList<String> list = new ArrayList<>();

        for (String s : arr) {
            // 使用 Predicate 接口中的 test 方法进行判断
            boolean b = pred1.and(pred2).test(s);
            if (b) {
                // 满足条件加入集合
                list.add(s);
            }
        }

        return list;
    }

    public static void testPredicate() {
        // 对传入的字符串进行判断，返回一个布尔值
        boolean b = usePredicate("hello",
                (str) -> str.length() > 5,
                (str) -> str.contains("e"));
        System.out.println(b);

        // 通过 Predicate 接口过滤信息
        String[] infoArr = {"Leo,15,男", "Eve,30,女", "Rex,23,男", "Tom,19,男"};
        ArrayList<String> list = filterInfo(infoArr,
                (s) -> s.split(",")[2].equals("男"),
                (s) -> Integer.parseInt(s.split(",")[1]) > 18);
        System.out.println(list);
    }

    // 使用 Function 转换类型
    public static String useFunction(String str, Function<String, Integer> func1, Function<Integer, String> func2) {
        return func1.andThen(func2).apply(str);
    }

    public static void changeType() {
        // 转换类型
        String str = useFunction("1234",
                (s) -> Integer.parseInt(s) + 10,
                (i) -> i + "");
        System.out.println(str);
    }

}

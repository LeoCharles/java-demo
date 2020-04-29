package demo14;

import java.util.*;
import java.util.stream.Stream;

/**
 * Java 1.8 引入 Stream 流，位于 java.util.stream 包。
 *
 * Stream 流是一个来自数据源的元素队列，数据源可以是集合，数组等。
 * Stream 流支持函数式编程和链式操作，可以进行惰性求值。
 *
 * Stream 流操作的基础特征：
 * 1. 中间操作都会返回流对象本身。多个操作可以串联成一个管道，这样做可以对操作进行优化，比如延迟执行(laziness)和短路(short-circuiting)。
 * 2. 内部迭代。以前对集合遍历都是通过 Iterator 或者增强 for 的方式, 这叫做外部迭代。Stream 流提供了内部迭代的方式，流可以直接调用遍历方法。
 *
 * Stream 流是一种管道流，只能被消费一次
 *
 * 每次转换数据原有 Stream 对象不变，返回一个新的 Stream 对象
 *
 * java.util.stream.Stream<T> 流接口(不是函数式接口)。
 * static <T> Stream<T>	of​(T... values)：返回其元素为指定值的顺序有序流。
 * void	forEach​(Consumer<> action): 对此流的每个元素执行操作。
 *
 * 获取 Stream 流：
 * Stream 接口的静态方法 of 可以获取数组对应的流。
 * 所有的 Collection 集合都可以通过 stream 默认方法获取流。
 * Map 接口获取流需要分 key、value 或 entry 等情况。
 *
 * Stream 流常用方法(两类)：
 *
 * 延迟方法：返回值类型仍然是 Stream 类型，可以继续链式调用
 *
 * filter(Predicate<> predicate)：接收一个 Predicate 接口参数作为筛选条件来过滤流，返回过滤后的流。
 * map(Function<> mapper)：接收一个 Function 接口参数，将流中的元素映射到另一个流中，返回映射后的流。
 * limit(long maxSize)：截取前几个元素，返回截取后的流。
 * skip​(long n)：跳过前几个元素，返回剩余元素组成的流。
 * concat​(Stream<> a, Stream<> b)：将两个流连接成一个流。
 * sorted()：按照自然顺序对流进行排序。
 * distinct()：对流中的元素进行去重。
 * empty()：返回空序列流。
 *
 * 终结方法：返回值类型不再是 Stream 类型，不能再链式调用。
 *
 * forEach(Consumer<> action)：接收一个 Consumer 接口参数，对流中的每个元素执行操作。
 * count()：统计流中元素的个数。
 * reduce​(T identity, BinaryOperator<T> accumulator)：所有元素按照聚合函数聚合成一个结果。
 * collect(Collector<> collector)：每个元素收集到集合。
 * max​(Comparator<> comparator)：返回此流的最大元素。
 * min​(Comparator<> comparator)：返回此流的最小元素。
 * allMatch​(Predicate<> predicate)：所有元素是否与提供的条件匹配。
 * anyMatch​(Predicate<> predicate)：任何元素是否与提供的条件匹配。
 * sum()：对所有元素求和；
 * average()：对所有元素求平均数。
 *
 * Stream 流常用操作分类：
 * 转换操作：map()，filter()，sorted()，distinct()
 * 合并操作：concat()，flatMap()
 * 聚合操作：reduce()，collect()，count()，max()，min()，sum()，average()
 * 匹配操作：allMatch(), anyMatch()
 * 遍历操作：forEach()
 *
 *
 */

public class StreamTest {
    public static void main(String[] args) {
//        useStream();
//        getStream();
//        testForEach();
//        testFilter();
//        testMap();
//        testReduce();
//        testLimit();
//        testSkip();
//        testCount();
//        testConcat();
//        testSorted();
//        testDistinct();


    }

    // 使用 Stream 流
    public static void useStream() {
        List<String> list = new ArrayList<>();

        list.add("Clack");
        list.add("Neil");
        list.add("Connie");
        list.add("Rex");
        list.add("Remy");
        list.add("Chris");

        // 将集合转换成流，再进行过滤
        list.stream()
                .filter(name -> name.startsWith("C"))
                .filter(name -> name.length() == 5)
                .forEach(name -> System.out.println(name));
    }

    // 获取 Stream 流
    public static void getStream() {
        // 把集合转换为 Stream 流
        List<String> list = new ArrayList<>();
        Stream<String> stream1 = list.stream();

        // 把 Set 集合转换为 Stream 流
        Set<String> set = new HashSet<>();
        Stream<String> stream2 = set.stream();

        // 先获取 Map 集合的 key、value、entry 再转换成 Stream 流
        Map<String, String> map = new HashMap<>();
        // 获取 Map 的键，存在一个 Set 集合中
        Set<String> keySet = map.keySet();
        Stream<String> stream3 = keySet.stream();
        // 获取 Map 的值，存储到一个 Collection 集合中
        Collection<String> values = map.values();
        Stream<String> stream4 = values.stream();
        // 获取 Map 的键值对
        Set<Map.Entry<String, String>> entries = map.entrySet();
        Stream<Map.Entry<String, String>> stream5 = entries.stream();

        // 把数组转换成 Stream 流
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);
        // 可变参数可以传递数组
        Integer[] arr1= {1, 2, 3, 4, 5};
        Stream<Integer> integerStream1 = Stream.of(arr1);
        String[] arr2 = {"aaa", "bbb", "ccc"};
        Stream<String> stringStream = Stream.of(arr2);
    }

    // void	forEach​(Consumer<? super T> action)：接收一个 Consumer 接口参数，对每个元素执行操作
    // Consumer 接口是一个消费型接口，接口中的 accept 方法消费一个指定类型的数据
    public static void testForEach() {
        Stream<String> stream = Stream.of("Van", "Pag", "Mag", "Rex", "Eve", "Ada", "Ula", "Amy");

        // 使用流中的 forEach 方法，对每个元素执行操作
        stream.forEach(item -> System.out.println(item));
    }

    // Stream<T> filter(Predicate<? super T> predicate)：接收一个 Predicate 接口参数作为筛选条件来过滤流
    // Predicate 接口中的 test 方法会根据指定的条件是否满足，返回一个布尔值，结果为真则留下元素
    public static void testFilter() {
        Stream<String> stream = Stream.of("Van", "Pag", "Mag", "Rex", "Eve", "Ada", "Ula", "Amy");

        // 使用流中的 filter 方法，传入过滤条件，返回满足条件的元素，组成新的流
        Stream<String> newStream = stream.filter(item -> item.startsWith("A"));

        newStream.forEach(item -> System.out.println(item));

        // Stream 流属于管道流，只能消费一次，第一个流调用方法完毕，数据会流转到下一个流，第一个流就不能再调用方法了
        // 抛出异常 IllegalStateException：stream has already been operated upon or closed
        // stream.forEach(item -> System.out.println(item));
    }

    // <R> Stream<R> map(Function<? super T, ? extends R> mapper)：接收一个 Function 接口参数，将流中的元素映射到另一个流中，
    // Function 接口中的 apply 方法可以将一种类型转换成为另一种类型，而这种转换的动作，就称为映射。
    public static void testMap() {
        Stream<String> stream = Stream.of("1", "2", "3", "4", "5");

        // 使用流中的 map 方法，映射出一个新的流
        Stream<Integer> newStream = stream.map(item -> Integer.parseInt(item)).map(item -> item * item);

        newStream.forEach(item -> System.out.println(item));
    }

    // T reduce​(T identity, BinaryOperator<T> accumulator)：将流中的所有元素按照聚合函数聚合成一个结果。
    // BinaryOperator 接口定义了一个 apply 法，把上次聚合的结果和本次的元素进行运算，并返回累加的结果
    public static void testReduce() {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);

        // 使用 reduce 方法聚合数据，第一参数是初始值，第二个参传入聚合方法，参数是上次聚合的结果和本次当前元素
        Integer sum = stream.reduce(0, (acc, curr) -> acc + curr);
        System.out.println(sum);
    }

    // Stream<T> limit(long maxSize): 截取流中前 n 个元素，返回截取后的流
    public static void testLimit() {
        Stream<String> stream = Stream.of("Van", "Pag", "Mag", "Rex", "Eve", "Ada", "Ula", "Amy");

        Stream<String> newStream = stream.limit(3);

        newStream.forEach(item -> System.out.println(item));
    }

    // Stream<T> skip(long n)：跳过前几个元素，返回剩余元素组成的流。
    public static void testSkip() {
        Stream<String> stream = Stream.of("Van", "Pag", "Mag", "Rex", "Eve", "Ada", "Ula", "Amy");

        Stream<String> newStream = stream.skip(3);

        newStream.forEach(item -> System.out.println(item));
    }

    // static <T> Stream<T> concat(Stream<? extends T> a, Stream<? extends T> b)：将两个流连接在一起，返回一个新的流
    public static void testConcat() {
        Stream<Integer> stream1 = Stream.of(1, 2, 3);
        Stream<Integer> stream2 = Stream.of(4, 5, 6);

        // 使用 Stream 接口的静态方法 concat 连接两个流
        Stream<Integer> newStream = Stream.concat(stream1, stream2);

        newStream.forEach(item -> System.out.println(item));
    }

    // long count()：统计流中元素的个数
    public static void testCount() {
        Stream<String> stream = Stream.of("Van", "Pag", "Mag", "Rex", "Eve", "Ada", "Ula", "Amy");

        // 使用 count 方法统计元素的个数
        long count = stream.count();
        System.out.println(count);
    }

    // Stream<T> sorted()：按照自然顺序对流进行排序。
    public static void testSorted() {
        Stream<String> stream = Stream.of("Van", "Pag", "Mag", "Rex", "Eve", "Ada", "Ula", "Amy");

        Stream<String> newStream = stream.sorted();

        newStream.forEach(item -> System.out.println(item));
    }

    // Stream<T> distinct()：对流中的元素去重
    public static void testDistinct() {
        Stream<Integer> stream = Stream.of(1, 2, 2, 3, 3, 4, 5);

        Stream<Integer> newStream = stream.distinct();

        newStream.forEach(item -> System.out.println(item));
    }
}

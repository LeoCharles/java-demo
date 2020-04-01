package demo04;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * JDK 9 新特性：
 * List 接口，Set 接口，Map 接口 增加了一个静态方法 of ，可以一次性给集合添加多个元素
 * 前提是集合中存储的元素个数已经确定
 *
 * 注意：
 * 1. of 方法只适用 List接口、Set接口、Map接口，不适用接口的实现类
 * 2. of 的返回值是一个不能改变的集合，不能再使用 add、put 方法
 * 3. Set接口、Map接口在使用 of 方法时，不能有重复的元素
 *
 */
public class OfMethodTest {
    public static void main(String[] args) {

        testOf();
    }
    // List、Set、Map 接口的 of 方法可以一次性给集合添加多个元素
    public static void testOf() {

        // List 接口使用 of 方法
        List<String> list = List.of("Leo", "Aem", "Eve", "Rex", "Van");
        System.out.println(list); // [Leo, Aem, Eve, Rex, Van]
        // 使用 of 方法后，集合不能在改变
        //list.add("Tom"); // UnsupportedOperationException 不支持的操作
        //list.remove("Leo"); // UnsupportedOperationException

        // Set 接口使用 of 方法
        // 不能有重复元素，否则会抛异常
        Set<String> set = Set.of("Leo", "Aem", "Eve", "Rex", "Van");
        System.out.println(set); // [Rex, Eve, Leo, Aem, Van]

        // Map 接口使用 of 方法
        Map<String, Integer> map = Map.of("Leo", 29, "Tom", 20);
        System.out.println(map); // {Leo=29, Tom=20}
        // 不能再使用 put / remove 改变元素
        //map.put("Van", 39); // UnsupportedOperationException
        //map.remove("Leo"); // UnsupportedOperationException
    }
}

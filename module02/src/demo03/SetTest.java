package demo03;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Set 接口
 * java.util.Set 接口 extends Collection 接口
 *
 * Set 接口的方法与 Collection 的方法基本一致，只是比 Collection 更加严格了。
 *
 * Set 接口特点：
 * 1. 不允许存储重复的元素
 * 2. 没有索引，没有带索引的方法，不能使用普通的 for 循环
 *
 * java.util.HashSet 类实现 Set 接口，由哈希表（实际上是一个 HashMap 实例）支持。
 * 特点：
 * 1. 无序集合，存储元素和取出元素的顺序有可能不一致。
 * 2. 底层是一个哈希表结构，查询快。
 *
 * 哈希值：是一个十进制的整数，表示对象的逻辑地址，不是真实的物理地址。
 *
 * 使用 Object 的 hashCode 方法获取地址。
 *
 * JDK1.8之前，哈希表 = 数组 + 链表
 * JDK1.8之后，哈希表 = 数组 + 链表 + 红黑树实现
 * 哈希表查询速度快
 *
 * Set 集合存储元素不重复前提是重写  hashCode 与 equals 方法
 *
 * java.util.LinkedHashSet 类继承 extends HashSet 集合
 * LinkedHashSet 集合特点：
 * 底层是一个哈希表(数组 + 链表/红黑树) + 链表，多了一层链表记录元素存储顺序，保证元素有序
 *
 */
public class SetTest {
    public static void main(String[] args) {

        //testHashSet();

        //testStringHash();

        //testHashCode();

        testLinkedHashSet();

    }

    private static void testHashSet() {
        // 创建 HashSet
        Set<String> hashSet = new HashSet<>();
        // 添加元素
        hashSet.add("Amy");
        hashSet.add("May");
        hashSet.add("Van");
        hashSet.add("Joy");
        hashSet.add("Joy"); // 不能添加重复元素

        // 不能使用普通 for 循序，使用迭代器或增强 for
        for (String s : hashSet) {
            System.out.println(s);
        }
    }

    private static void testStringHash() {
        // String 类重写了 hashCode 方法
        String s1 = "abc";
        System.out.println(s1.hashCode()); // 96354
        // 内容不同，哈希值相同
        String s2 = "重地";
        String s3 = "通话";
        System.out.println(s2.hashCode()); // 1179395
        System.out.println(s3.hashCode()); // 1179395
    }

    private static void testHashCode() {
        // Set 存储自定义对象，必须重写 hashcode 和 equals
        HashSet<Person> set = new HashSet<>();

        Person p1 = new Person("Leo", 20);
        Person p2 = new Person("Tom", 20);
        Person p3 = new Person("Leo", 20);
        set.add(p1);
        set.add(p2);
        set.add(p3);
        // p1 和 p2 hashCode 相同
        System.out.println(p1.hashCode()); // 2365599
        System.out.println(p2.hashCode()); // 2613475
        System.out.println(p3.hashCode()); // 2365599

        System.out.println(set); // [Person{name='Tom', age=20}, Person{name='Leo', age=20}]
    }

    private static void testLinkedHashSet() {
        HashSet<String> set = new HashSet<>();
        set.add("Tom");
        set.add("Leo");
        set.add("Van");
        set.add("Amy");
        set.add("Joy");
        // HashSet 无序
        System.out.println(set); // [Van, Tom, Joy, Leo, Amy]

        LinkedHashSet<String> linkedSet = new LinkedHashSet<>();
        linkedSet.add("Tom");
        linkedSet.add("Leo");
        linkedSet.add("Van");
        linkedSet.add("Amy");
        linkedSet.add("Joy");
        // LinkedHashSet 有序
        System.out.println(linkedSet); // [Tom, Leo, Van, Amy, Joy]
    }
}

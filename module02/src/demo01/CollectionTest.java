package demo01;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 集合接口
 *
 * 集合是java中提供的一种容器，可以用来存储多个数据。

 * 集合和数组的区别：
 * 数组的长度固定，集合的长度可变。
 * 数组中存储的是同一类型元素，集合存储的都是对象，而且对象的类型可以不一致。
 *
 * 集合按照存储结构可以分为两大类：
 * 1.单列集合：java.util.Collection
 * 2.双列集合：java.util.Map
 *
 * Collection接口：
 * Collection接口是单列集合的根接口，用于存储一系列符合某种规则的元素。
 *
 * Collection接口定义了单列集合框架中最共性的方法，所有单列集合都可以使用。
 *
 * Collection接口有两个重要的子接口：
 *
 * 1.java.util.List 接口
 * 特点：元素可重复，有索引，有序，可以使用 for 循环遍历
 * 子接口：java.util.ArrayList(数组实现)、 java.util.LinkedList(链表实现)、java.util.Vector(数组实现)
 *
 * 2.java.util.Set 接口
 * 特点：元素不可重复，没有索引，不能使用 for 循环遍历
 * 子接口：java.util.HashSet(哈希表实现)、java.util.TreeSet(红黑树实现)、java.util.LinkedHashSet(链表和哈希表实现)
 *
 * Collection接口中常用方法(List和Map都可以使用)
 * public boolean add(E e)：把给定对象添加到当前集合。
 * public void clear()：清空集合中所有元素。
 * public boolean remove(E e)：把给定的对象从当前集合中删除。
 * public boolean contains(E e)：判断当前集合是否包含给定的对象。
 * public boolean isEmpty(E e)：判断当前集合是否为空。
 * public int size()：获取集合中元素的个数。
 * public Object[] toArray()：把集合中的元素存储到数组中。
 *
 *
 */
public class CollectionTest {

    public static void main(String[] args) {

        // 创建集合对象，可以使用多态
        Collection<String> coll = new ArrayList<>();
        System.out.println(coll); // [], 重写了 toString 方法

        // boolean add(E e)，添加元素到集合的尾部
        coll.add("Amy");
        coll.add("Eve");
        coll.add("Rex");
        coll.add("Jim");
        coll.add("Joy");
        coll.add("Van");
        System.out.println(coll); // [Amy, Eve, Rex, Jim, Joy, Van]

        // int size() 获取集合中元素的个数
        System.out.println(coll.size()); // 6

        // boolean contains(E e) 判断当前集合是否包含给定的对象
        System.out.println(coll.contains("Eve")); // true
        System.out.println(coll.contains("Leo")); // false

        // boolean remove(E e)，删除集合中指定元素，元素不存在返回 false
        coll.remove("Joy");
        System.out.println(coll); // [Amy, Eve, Rex, Jim, Van]
        System.out.println(coll.remove("Tom")); // false

        // Object[] toArray() 把集合中的元素存储到数组中。
        Object[] arr = coll.toArray();
        // 遍历数组
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        // void clear()清空集合中所有元素，集合还存在
        coll.clear();
        System.out.println(coll);

        // boolean isEmpty(E e) 判断当前集合是否为空
        System.out.println(coll.isEmpty()); // true
    }
}

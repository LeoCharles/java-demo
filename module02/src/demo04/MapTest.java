package demo04;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * java.util.Map 映射
 *
 * Collection 接口中的集合元素都是孤立存在的，称为单列集合
 *
 * Map 接口中的集合元素是成对存在的，称为双列集合
 *
 * Map 接口的特点：
 * 1. Map 集合是一个双列集合，一个元素包含两个值：key 和 value
 * 2. Mao 集合中的元素，key 和 value 的数据类型可以相同也可以不同
 * 3. Map 集合中的元素，key 不允许重复，value 可以重复
 * 4. Map 集合中的元素，key 和 value 一一对应
 *
 * Map 接口中常用方法：
 * public V put(K key, V value):  把指定的键与指定的值添加到 Map 集合中。
 * public V remove(Object key): 把指定的键 所对应的键值对元素 在 Map 集合中删除，返回被删除元素的值。
 * public V get(Object key): 根据指定的键，在 Map 集合中获取对应的值。
 * boolean containsKey(Object key): 判断集合中是否包含指定的键。
 * public Set<K> keySet(): 获取 Map 集合中所有的键，存储到 Set 集合中。
 * public Set<Map.Entry<K,V>> entrySet(): 获取到 Map 集合中所有的键值对对象的集合(Set集合)。
 *
 * Map.Entry 对象中的方法:
 * K getKey() 返回与此项对应的键。
 * V getValue() 返回与此项对应的值。
 *
 *
 * java.util.HashMap<k, v> 集合  implements Map<k, v> 接口
 * 特点：
 * HashMap 哈希表底层是数组 + 单向链表/红黑树，查询速度快
 * HashMap 是一个无序集合，存储元素和取出元素的顺序可能不一致
 *
 * java.util.LinkedHashMap 集合 extends HashMap<k, v> 集合
 * 特点：
 * LinkedHashMap 底层是哈希表 + 链表
 * LinkedHashMap 是一个有序集合
 *
 *
 */
public class MapTest {
    public static void main(String[] args) {

        testMapMethod();
    }

    public static void testMapMethod() {

        // 创建 Map 集合，使用多态
        Map<String, Integer> map = new HashMap<>();

        // put 添加键值对，若 key 重复，返回被替换的 value，否则返回的是 null
        map.put("Leo", 30);
        map.put("Amy", 23);
        map.put("Van", 34);
        map.put("Rex", 23);
        map.put("Joy", 43);
        System.out.println(map.put("Leo", 32)); // 返回被替换的 value
        System.out.println(map); // 重写了 toString

        // get 通过指定的 key 获取对应的 value
        System.out.println(map.get("Leo"));

        // containsKey 判断集合是否包含指定的 key
        System.out.println(map.containsKey("Leo"));

        // remove 删除 key 指定的元素，若 key 存在，返回 value，否则返回 null
        System.out.println(map.remove("Van"));

        // KeySet 把 Map 中的 key 取出来 存储在 Set 中
        Set<String> keys = map.keySet();

        // 通过迭代器遍历
        Iterator<String> it = keys.iterator();
        while (it.hasNext()) {
            System.out.println("key: " + it.next() + ", value: " + map.get(it.next()));
        }

        // 通过增强 for 遍历
        for (Object key : map.keySet()) {
            System.out.println("key: " + key + ", value: " + map.get(key));
        }

        // entrySet 把 Map 中的 Entry 对象(键值对对象)存储到 Set 集合中
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        System.out.println("使用 Map.Entry 对象遍历 Map");
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println("key: " + entry.getKey() + ", value: " + entry.getValue());
        }

    }

}

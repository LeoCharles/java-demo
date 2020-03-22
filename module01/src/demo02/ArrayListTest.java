package demo02;

import java.util.ArrayList;
import java.util.Random;

/**
 * Array 的长度不能发生改变
 * ArrayList 集合的长度可以随意变化。
 *
 * ArrayList <E> 中 <E>表示泛型，泛型只能是引用类型，不能是基本类型
 * 备注：从 JDK 1.7 开始，右侧尖括号内部可以不写内容，但是 <> 必须写
 *
 * 使用 add() 方法添加数据
 */
public class ArrayListTest {
    public static void main(String[] args) {
        // 创建一个全都是 String 类型的 ArrayList
        ArrayList<String> strArrayList = new ArrayList<>();
        System.out.println(strArrayList); // []
        // 添加数据
        strArrayList.add("学习 Java");
        strArrayList.add("学习 Spring");
        strArrayList.add("学习 React");
        strArrayList.add("学习 Electron");
        // 集合长度
        System.out.println(strArrayList.size()); // 4
        // 获取元素
        System.out.println(strArrayList.get(2)); // 学习 React
        // 删除元素
        String whoRemoved = strArrayList.remove(3);
        System.out.println(whoRemoved); // 学习 Electron
        // 遍历集合
        for (int i = 0; i < strArrayList.size(); i++) {
            System.out.println(strArrayList.get(i));
        }

        // 创建 Integer 类型的 ArrayList
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            integerArrayList.add(i);
        }
        System.out.println(integerArrayList);

        // 生成 6 个 1 ~ 10 之间的随机整数
        ArrayList<Integer> randomNumList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            int randomNum = random.nextInt(10) + 1;
            randomNumList.add(randomNum);
        }
        System.out.println("6 个随机数集合是：" + randomNumList);

        // 创建一个集合存储 4 个 Person 对象
        Person p1 = new Person("Tom", 34);
        Person p2 = new Person("Bob", 12);
        Person p3 = new Person("Job", 39);
        Person p4 = new Person("Leo", 30);

        ArrayList<Person> personList = new ArrayList<>();
        personList.add(p1);
        personList.add(p2);
        personList.add(p3);
        personList.add(p4);
        for (int i = 0; i < personList.size(); i++) {
            Person p = personList.get(i);
            System.out.println("姓名：" + p.getName() + ", 年龄：" + p.getAge());
        }

        // 用集合作为参数
        printArrayList(strArrayList);

        // 用一个大集合存 20 个 随机数字，然后随机筛选其中偶数元素放到小集合里
        ArrayList<Integer> bigList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            int num = random.nextInt(100) + 1;
            bigList.add(num);
        }
        ArrayList<Integer> res = filterArrayList(bigList);
        System.out.println(res);
        System.out.println("偶数总共：" + res.size());
    }

    // 按特殊格式打印 ArrayList  {元素@元素@元素}
    public static void printArrayList(ArrayList<String> list) {
        System.out.print("{");
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            if (i == list.size() - 1) {
                System.out.println(str + "}");
            } else {
                System.out.print(str + "@");
            }
        }
    }

    // 从集合中筛选偶数放入小集合中
    public static ArrayList<Integer> filterArrayList (ArrayList<Integer> bigList) {
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = 0; i < bigList.size(); i++) {
            int num = bigList.get(i);
            if(num % 2 == 0) {
                temp.add(num);
            }
        }
        return temp;
    }


}
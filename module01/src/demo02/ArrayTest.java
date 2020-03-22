package demo02;

/**
 * // 数组有一个缺点，一旦创建，程序运行期间，长度不可以改变
 */
public class ArrayTest {
    public static void main(String[] args) {
        // 创建一个长度为 3 的数组，用来存放 Person 类对象
        Person[] array = new Person[3];

        // 创建 3 个对象
        Person one = new Person("Tom", 30);
        Person two = new Person("Bob", 28);
        Person three = new Person("Job", 12);


        array[0] = one;
        array[1] = two;
        array[2] = three;

        Person p1 = array[0];
        System.out.println(p1.getName());

    }
}

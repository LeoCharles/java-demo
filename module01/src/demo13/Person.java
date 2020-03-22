package demo13;

// Objects 工具类提供了一些方法来操作对象
import java.util.Objects;


/**
 * 覆盖重写 toString、equals 方法
 *
 *
 */
public class Person {

    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

//    @Override
//    public String toString() {
//        return "Person{" + "name='" + name + "', age=" + age + "}";
//    }

    // 使用快捷键

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }


    // 重写 equals
//    @Override
//    public boolean equals(Object obj) {
//        // 如果参数 obj 是 this 本身，直接返回 false
//        if (obj == this) {
//            return true;
//        }
//        // 如果参数 obj 是 null 直接返回 false
//        if (obj == null) {
//            return false;
//        }
//        // 向下转型前，加一个类型判断
//        if (obj instanceof Person) {
//            // 使用向下转型，把 obj 转成 Person
//            Person p = (Person) obj;
//            // 比较两个对象的属性
//            return this.name.equals(p.name) && this.age == p.age;
//        }
//        // 不是 Person 类型，直接返回
//        return false;
//    }

    // 使用 IDEA 快捷键重写


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        // getClass() != o.getClass() 使用反射技术，判断 o 是否 Person 类型
        // 等效于o instanceof Person
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        // 使用 Objects.equals 避免空指针异常 null 不能调用方法
        return age == person.age && Objects.equals(name, person.name);

    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

package demo12;

import java.io.Serializable;

/**
 * 对象的序列化和反序列化，需要实现 java.io.Serializable 接口
 *
 * Serializable 是标记型接口，没有方法
 *
 * 进行序列化和反序列化时，会检测类上是否有这个标记
 * 如果没有会抛出 NoSerializableException
 *
 * 可序列化类可以通过显式声明自己的 serialVersionUID，指定一个序列化版本号
 * 无论是否对类进行修改，都不会生成新的序列化版本号
 * serialVersionUID 字段必须是 static final 的 long 类型字段
 *
 *
 */
public class Person implements Serializable {
    // 添加序列化版本号， serialVersionUID 字段必须是 static final 的 long 类型字段
    private static final long serialVersionUID = 1L;

    private String name;
    private int  age;
//    private static int  age;    // 静态关键字 static 修饰的不能被反序列化
//    private transient int  age; // 瞬态关键字 transient 修饰的不能被反序列化

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
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

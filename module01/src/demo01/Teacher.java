package demo01;

/**
 * 标准的 Teacher 类
 * 一个标准的类通常需要以下四个组成部分
 * 1. 所有的成员变量都使用 private 关键字修饰
 * 2. 为每一个成员变量编写一对 Getter / Setter 方法
 * 3. 编写一个无参数的构造方法
 * 4. 编写一个全参数的构造方法
 *
 * 一个标准的类也叫做 Java Bean
 *
 *  快捷键 Alt + Insert
 */
public class Teacher {

    private String name;
    private int age;

    public Teacher() {
    }

    public Teacher(String name, int age) {
        this.name = name;
        this.age = age;
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

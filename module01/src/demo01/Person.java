package demo01;

/**
 * 定义 Person 类
 * 用 private 关键字将成员变量进行修饰
 * 间接访问 private 需要定义一对 getter /  setter 方法
 * 对于 setter 来说，不能有返回值，参数类型和成员变量对应
 * 对于 getter 来说，不能有参数，返回值类型和成员变量对应
 * 快捷键 alt + insert
 *
 * 当通过关键字 new 创建对象时，就是在调用构造方法
 */
public class Person {
    // 使用 private 进行修饰，超出本类范围之外将不能使用
    private String name;
    private int age;
    private boolean isStudent;


    // 无参构造方法，名称和类一致，不写返回值类型
    public Person() {
        System.out.println("无参构造方法被调用了");
    }

    // 全参构造方法，名称和类一致，不写返回值类型
    public Person(String name, int age, boolean isStudent) {
        System.out.println("全参构造方法被调用了");
        this.name = name;
        this.age = age;
        this.isStudent = isStudent;
    }

    // getter / setter
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        if (age >= 0 && age < 120) {
            this.age = age;
        } else {
            System.out.println("年龄设置不合理！");
        }

    }

    public int getAge() {
        return age;
    }

    public void setStudent(boolean isStudent) {
        this.isStudent = isStudent;
    }

    public boolean isStudent() {
        return isStudent;
    }

    public void getInfo() {
        System.out.println("我叫" + getName() + "，今年" + getAge() + "岁，" + (isStudent() ? "我还是学生。" : "我已经毕业了。"));
    }

    public void sayHello(String name) {
        System.out.println(name + "你好，我是" + this.name);
    }
}

package demo02;

public class Student {
    private int id;
    private String name;
    private int age;
    // 使用 static 关键词，这个变量会共享
    static String room;
    private static int idCounter;  // 每当 new 一个新对象时，计数器加 1

    // 静态代码块
    static {
        // 静态代码块的内容只执行一次，一般用来给静态变量赋值
        System.out.println("静态代码块执行");
        idCounter = 10100;
    }

    public Student() {
        idCounter++;
    }

    public Student(String name, int age) {
        System.out.println("构造方法执行");
        this.name = name;
        this.age = age;
        this.id = ++idCounter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    // 静态方法
    public static void staticMethod() {
        System.out.println("Student 类中的一个静态方法");

        // 静态方法不能直接访问非静态内容
        // System.out.println(id); // 错误写法

        // 静态方法中不能使用this
        // System.out.println(this); // 错误写法

    }

    // 成员方法
    public void method() {
        System.out.println("Student 类中的一个成员方法");
    }
}

package demo01;

public class Test02 {
    public static void main(String[] args) {
        // 无参构造
        Person person1 = new Person();
        person1.setName("Tom");
        person1.setAge(20); // 不能直接访问，需要使用 setter
        person1.setStudent(true);
        person1.getInfo();
        person1.sayHello("王老师");

        System.out.println("================");
        // 使用全参构造方法，可以不用 setter 方法
        Person person2 = new Person("Leo", 30, false);
        person2.getInfo();
        // 如果需要改变对象中成员变量的数据内容，仍然需要使用 setter 方法
        person2.setAge(31);
        person2.getInfo();
    }
}

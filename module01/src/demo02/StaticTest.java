package demo02;

/**
 * static 关键字
 */
public class StaticTest {
    public static void main(String[] args) {

        Student one = new Student("Tom", 20);
        Student two = new Student("Bob", 30);

        // 给静态变量赋值 所有对象都会共享
        Student.room = "101教室";

        // 推荐使用 Student.room ，也可以用 one.room
        System.out.println("姓名：" + one.getName() + ", 年龄：" + one.getAge()
                + ", 教室：" + Student.room + "，学号：" + one.getId());
        System.out.println("姓名：" + two.getName() + ", 年龄：" + two.getAge()
                + ", 教室：" + Student.room + ", 学号：" + two.getId());


        // 使用类名称直接调用静态方法
        Student.staticMethod();

        // 本类中的静态方法可以直接调用，不需要类名称
        myStaticMethod(); // 等效于 StaticTest.myStaticMethod();

    }

    // 本类中的静态方法
    public static void myStaticMethod() {
        System.out.println("本类中的一个静态方法");
    }


}

package demo01;

/**
 * 通常一个类不能直接使用，需要根据类创建一个对象后才能使用
 * 1. 导包: import 包名.类名;
 * 2. 创建: 类名称 对象名 = new 类名称();
 * 3. 使用: 对象名.成员变量名    对象名.成员方法(参数);
 */
public class Test01 {
    public static void main(String[] args) {

        // 实例化一个 Student 类
        Student stu1 = new Student();
        stu1.name = "Leo";
        stu1.age = 30;
        stu1.sex = "男";
        stu1.getInfo();

        System.out.println("==============");

        // 实例化一个 Phone 类
        Phone phone1 = new Phone();
        phone1.brand = "苹果";
        phone1.price = 8388.0;
        phone1.color = "玫瑰金";
        System.out.println(phone1.brand);
        System.out.println(phone1.price);
        System.out.println(phone1.color);
        phone1.call("乔布斯");
        phone1.sendMessage();

        System.out.println("==============");

        // 将 phone1 保存的对象地址值赋值给 phone2
        Phone phone2 = phone1;
        phone2.brand = "华为";
        System.out.println(phone2.brand);
        System.out.println(phone2.price);
        System.out.println(phone2.color);

        System.out.println("==============");

        // 将对象作为参数
        getPhoneInfo(phone1); // 传递的是地址值
        getPhoneInfo(phone2); // 传递的是地址值

    }

    public static void getPhoneInfo(Phone phone) {
        System.out.println(phone.brand);
        System.out.println(phone.price);
        System.out.println(phone.color);
    }
}

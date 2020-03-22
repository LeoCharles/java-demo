package demo08;

/**
 * final 修饰成员变量
 *
 * 如果使用 final 修饰成员变量，这个成员变量不可变
 *
 * 注意：使用 final 修饰成员变量后必须手动赋值，不会在给默认值
 */
public class Person {

    // 没有 final 修饰符时，name 有 默认值 null
    // 使用 final 后需要直接赋值，或者使用构造赋值
    final private String name = "Leo";

    public Person() {
        // 直接赋值和构造赋值只能选其一
//        name = "Tom"
    }


    public Person(String name) {
        // 直接赋值和构造赋值只能选其一
//        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 不能再有改变 name 的方法了
//    public void setName(String name) {
//         this.name = name;
//    }
}

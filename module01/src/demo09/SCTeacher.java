package demo09;

/**
 * 会唱歌的厨子是老师
 *
 * 先继承后实现
 */
public class SCTeacher extends Person implements Cooking, Sing {

    String course; // 教的科目

    public void setInfo() {
        super.name = "Tom";
        super.age = 30;
        super.sex = 1;
        this.course = "英语";
    }

    @Override
    public void showInfo() {
        System.out.println("会唱歌的厨子是老师信息是：");
        System.out.println(super.name);
        System.out.println(super.age);
        System.out.println(super.sex);
        System.out.println(this.course);
    }

    @Override
    public void fry() {
        System.out.println(super.name + "老师会炒菜");
    }

    @Override
    public void singing() {
        System.out.println(super.name + "老师擅长美声唱法");
    }
}

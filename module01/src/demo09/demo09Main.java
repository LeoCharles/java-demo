package demo09;

/**
 * 描述：会唱歌的厨子是老师
 *
 * 老师继承 Person 类，实现 唱歌、炒菜接口
 *
 */

public class demo09Main {


    public static void main(String[] args) {

        SCTeacher sct = new SCTeacher();

        sct.setInfo();

        sct.showInfo();

        sct.fry();

        sct.singing();
    }
}

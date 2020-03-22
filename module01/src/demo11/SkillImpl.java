package demo11;

public class SkillImpl implements Skill {

    // 重写接口抽象方法
    @Override
    public void use() {
        System.out.println("释放大火球术！");
    }
}

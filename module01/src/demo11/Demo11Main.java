package demo11;

/**
 * 自定义类、接口作为成员变量类型
 */
public class Demo11Main {

    public static void main(String[] args) {

        // 创建英雄角色
        Hero hero = new Hero();
        hero.setName("伊利丹");
        hero.setAge(10000);

        // 创建武器
        Weapon weapon = new Weapon("霜之哀伤");
        // 为英雄配武器
        hero.setWeapon(weapon);

        // 设置英雄技能
        hero.setSkill(new SkillImpl());

        // 开始攻击
        hero.attack();
    }
}

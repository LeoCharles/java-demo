package demo04;

import java.util.ArrayList;
import java.util.Random;

/**
 * 成员类
 *
 * 成员收红包
 */
public class Member extends User {

    public Member() {
    }

    public Member(String name, int money) {
        super(name, money);
    }

    /**
     * 收红包
     * @param list 红包集合
     */
    public void receive(ArrayList<Integer> list) {
        // 随机获取一个集合中的索引编号
        int index = new Random().nextInt(list.size());

        // 根据索引从集合中删除一个，即收到的红包金额
        int delta = list.remove(index);

        // 获取成员当前余额
        int money = super.getMoney();

        // 余额增加红包金额
        super.setMoney(money + delta);

    }
}

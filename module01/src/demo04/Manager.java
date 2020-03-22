package demo04;

import java.util.ArrayList;

/**
 * 群主类
 *
 * 群主发红包
 */
public class Manager extends User {

    public Manager() {
    }

    public Manager(String name, int money) {
        // 调用父类的构造方法
        super(name, money);
    }

    /**
     * 发红包
     * @param totalMoney 红包总金额
     * @param count 红包个数
     * @return 红包金额集合
     */
    public ArrayList<Integer> send(int totalMoney, int count) {
        ArrayList<Integer> list = new ArrayList<>();

        // 获取群主的余额，红包总金额不能大于余额
        int leftMoney = super.getMoney();
        if (totalMoney > leftMoney) {
            System.out.println("余额不足！");
            // 返回空集合
            return list;
        }

        // 群主扣钱
        super.setMoney(leftMoney - totalMoney);

        // 均分红包总金额
        int avg = totalMoney / count; // 每个红包的金额
        int mod = totalMoney % count; // 余数，金额零头

        // 把红包放入集合中
        for (int i = 0; i < count - 1; i++) {
            list.add(avg);
        }
        // 零头放入最后一个红包中
        int last = avg + mod;
        list.add(last);

        return list;
    }
}

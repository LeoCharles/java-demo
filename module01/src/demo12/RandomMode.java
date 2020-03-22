package demo12;

import java.util.ArrayList;
import java.util.Random;

/**
 * 随机红包
 */
public class RandomMode implements OpenMode {

    @Override
    public ArrayList<Integer> divide(final int totalMoney, final int totalCount) {
        ArrayList<Integer> list = new ArrayList<>();

        // 随机分配，最少 1 分钱，最多不超过下剩下金额平均数的 2 倍
        // 1 + random.nextInt((leftMoney / leftCount) * 2)

        Random r = new Random();

        int leftMoney = totalMoney;
        int leftCount = totalCount;

        // 随机发 n-1 个，最后一个不需要随机
        for (int i = 0; i < totalCount - 1; i++) {
            // 生成随机金额
            int money = r.nextInt(leftMoney / leftCount * 2) + 1;
            list.add(money);

            // 剩余金额
            leftMoney -= money;
            leftCount--;
        }
        // 最后一个红包
        list.add(leftMoney);

        return list;
    }
}

package demo12;

import java.util.ArrayList;

/**
 * 普通红包
 */
public class NormalMode implements OpenMode {
    @Override
    public ArrayList<Integer> divide(final int totalMoney, final int totalCount) {
        ArrayList<Integer> list = new ArrayList<>();

        int avg = totalMoney / totalCount; // 平均数
        int mod = totalMoney % totalCount; // 余数，放入最后一个红包

        for (int i = 0; i < totalCount - 1; i++) {
            list.add(avg);
        }
        list.add(avg + mod);

        return list;
    }
}

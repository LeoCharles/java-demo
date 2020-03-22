package demo12;

import java.util.ArrayList;

public interface OpenMode {

    /**
     * 发红包
     * @param totalMoney 总金额，将金额变成以 ‘分’ 为单位的整数
     * @param totalCount 红包个数
     * @return 红包金额组成的整数集合
     */
    ArrayList<Integer> divide(int totalMoney, int totalCount);
}

package demo01;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 斗地主
 *
 * 1. 准备 54 张牌
 * 特殊牌：大王、小王
 * 其他52张牌：四种花色，13个序号，遍历循环两个集合组装牌
 *
 * 2. 洗牌
 * 使用 java.util.Collections 类的 shuffle() 方法洗牌
 * static void shuffle(List<?> list) 使用默认随机源对指定列表进行置换
 *
 * 3. 发牌
 * 三个人每人 17 张，最后三张底牌给地主
 * 使用 索引 % 3 来循环发牌
 */
public class DouDiZhu {
    public static void main(String[] args) {
        // 1. 准备牌
        ArrayList<String> poker = new ArrayList<>();
        String[] colors = {"♠", "♥", "♣", "♦"};
        String[] numbers = {"2", "A", "K", "Q", "J", "10", "9", "8","7", "6", "5", "4", "3"};
        // 先把大王、小王存储到扑克牌中
        poker.add("大王");
        poker.add("小王");
        // 循环遍历两个数组
        for (String color : colors) {
            for (String number : numbers) {
                poker.add(color + number);
            }
        }

        // 2. 洗牌 shuffle()
        Collections.shuffle(poker);
        //System.out.println(poker);


        // 3. 发牌 索引 % 3
        // 定义3个玩家和最后三张底牌
        ArrayList<Object> playerOne = new ArrayList<>();
        ArrayList<Object> playerTwo = new ArrayList<>();
        ArrayList<Object> playerThree = new ArrayList<>();
        ArrayList<Object> threeCards = new ArrayList<>();

        for (int i = 0; i < poker.size(); i++) {
            // 获取每一张牌
            String p = poker.get(i);

            if (i >= 51) {
                threeCards.add(p);
            } else if (i % 3 == 0) {
                playerOne.add(p);
            } else if (i % 3 == 1) {
                playerTwo.add(p);
            } else {
                playerThree.add(p);
            }
        }

        System.out.println("玩家 1：" + playerOne);
        System.out.println("玩家 2：" + playerTwo);
        System.out.println("玩家 3：" + playerThree);
        System.out.println("三张底牌：" + threeCards);

    }
}

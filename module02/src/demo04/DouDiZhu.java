package demo04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * 斗地主(有序版)
 *
 * 1.准备牌
 * 使用 Map 集合存储牌，key：牌的索引；value：组合好的牌(花色和数字)
 * 使用 List 集合存储牌的索引
 *
 * 2.洗牌
 * 使用 Collections 中的 shuffle 方法洗牌
 *
 * 3.发牌
 * 集合的索引 % 3
 * 剩余三张给底牌
 *
 * 4.排序
 * 使用 Collections 中的 sort 方法排序
 *
 * 5.看牌
 * 遍历玩家和底牌的 List 集合，获取到 Map 的 key，通过 key 找到 value
 *
 */
public class DouDiZhu {
    public static void main(String[] args) {
        // 1.准备牌
        // 使用 Map 集合存储牌
        HashMap<Integer, String> poker = new HashMap<>();
        // 使用 List 集合存储牌的索引
        ArrayList<Integer> pokerKeys = new ArrayList<>();
        // 使用 List 接口的 of 方法创建花色和数字
        List<String> colors = List.of("♠", "♥", "♣", "♦");
        List<String> numbers = List.of("2", "A", "K", "Q", "J", "10", "9", "8","7", "6", "5", "4", "3");
        // 定义牌的编号变量
        int key = 1;
        // 先存储大、小王
        poker.put(key, "大王");
        pokerKeys.add(key);
        poker.put(key + 1, "小王");
        pokerKeys.add(key + 1);
        // 再存储其他 52 张牌
        for (String number : numbers) {
            for (String color : colors) {
                poker.put(key + 2, color + number);
                pokerKeys.add(key + 2);
                key++;
            }
        }
        System.out.println(poker);
        System.out.println(pokerKeys);

        // 2.洗牌
        Collections.shuffle(pokerKeys);

        // 3.发牌
        // 定义 3 个玩家集合和 1 个底牌集合
        ArrayList<Integer> playerOne = new ArrayList<>();
        ArrayList<Integer> playerTwo = new ArrayList<>();
        ArrayList<Integer> playerThree = new ArrayList<>();
        ArrayList<Integer> threeCards = new ArrayList<>();
        for (int i = 0; i < pokerKeys.size(); i++) {
            Integer k = pokerKeys.get(i);
            // 先判断底牌
            if (i >= 51) {
                threeCards.add(k);
            } else if (i % 3 == 0) {
                playerOne.add(k);
            } else if (i % 3 == 1) {
                playerTwo.add(k);
            } else {
                playerThree.add(k);
            }
        }

        // 4.排序，默认升序
        Collections.sort(playerOne);
        Collections.sort(playerTwo);
        Collections.sort(playerThree);
        Collections.sort(threeCards);

        // 5.看牌
        lookPoker("玩家1", playerOne, poker);
        lookPoker("玩家2", playerTwo, poker);
        lookPoker("玩家3", playerThree, poker);
        lookPoker("底牌", threeCards, poker);
    }

    public static void lookPoker(String name, ArrayList<Integer> list, HashMap<Integer, String> poker) {
        System.out.print(name + ": ");
        // 遍历玩家或底牌
        for (Integer k : list) {
            // 根据牌的索引在 Map 中找到对应的牌
            String v = poker.get(k);
            System.out.print(v + "  ");
        }
        System.out.println(); // 换行
    }
}

package demo04;

import java.util.ArrayList;

/**
 * 群主发红包，成员收红包
 */
public class MainRedPacket {
    static Manager manager;
    static Member m1;
    static Member m2;
    static Member m3;
    static Member m4;
    static Member m5;
    static Member m6;

    public static void main(String[] args) {

        init();
        showInfo();

        System.out.println("============");

        // 群主发红包
        ArrayList<Integer> redList1 = manager.send(20, 3);
        // 成员收红包
        m1.receive(redList1);
        m3.receive(redList1);
        m6.receive(redList1);

        showInfo();

    }

    // 初始化群主和成员
    public static void init() {

        manager = new Manager("群主", 200);
        m1 = new Member("Bob", 0);
        m2 = new Member("Tom", 0);
        m3 = new Member("Leo", 0);
        m4 = new Member("Job", 0);
        m5 = new Member("Cat", 0);
        m6 = new Member("Jon", 0);
    }

    // 查看信息
    public static void showInfo () {
        manager.showInfo();
        m1.showInfo();
        m2.showInfo();
        m3.showInfo();
        m4.showInfo();
        m5.showInfo();
        m6.showInfo();
    }


}

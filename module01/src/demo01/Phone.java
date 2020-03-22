package demo01;

public class Phone {
    // 成员变量
    String brand;
    double price;
    String color;


    public void call(String who) {
        System.out.println("給" + who + "打电话");
    }

    public void sendMessage() {
        System.out.println("群发短信");
    }

}

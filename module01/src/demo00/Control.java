package demo00;

public class Control {
    public static void main(String[] args) {
        int a = 10;

        if (a % 2 == 0) {
            System.out.println("偶数");
        } else {
            System.out.println("奇数");
        }

        int b = 2;
        switch(b) {
            case 1:
                System.out.println("星期一");
                break;
            case 2:
                System.out.println("星期二");
                break;
            case 3:
                System.out.println("星期三");
                break;
            default:
                break;
        }

        // for 循环
        for (int i = 0; i < a; i++) {
            System.out.println("for 循环" + i);
        }

        System.out.println("===========");

        // while 循环
        int i = 0;
        while (i < 10) {
            System.out.println("while 循环" + i);
            i++;
        }

        System.out.println("===========");

        // do while 循环
        int c = 1;
        do {
            System.out.println("do while 循环" + c);
            c ++;
        } while (c < 10);


        // 1 - 100 偶数和
        int sum = 0;
        for (int num = 1; num <= 100; num++) {
            if (num % 2 == 0) {
                sum += num;
            }

        }
        System.out.println("偶数和" + sum);
    }
}

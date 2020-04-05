package demo06;

/**
 * java.lang.Thread 类是所有线程对象的父类
 *
 *
 *
 *
 *
 */
public class MainThread {
    public static void main(String[] args) {

        testSleep();

    }

    // sleep 方法模拟秒表
    public static void testSleep() {
        for (int i = 0; i < 60; i++) {
            System.out.println(i);

            // 使用 Thread 类中的 sleep 方法，让程序睡眠指定的时间
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

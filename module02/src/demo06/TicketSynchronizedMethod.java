package demo06;

/**
 * 同步方法
 *
 * 使用 synchronized 修饰的方法, 就叫做同步方法
 *
 * 格式：
 * public synchronized 返回值类型 方法名(参数列表) {
 *     // 可能会产生线程安全问题的代码
 * }
 *
 * 同步方法的锁对象是实现类对象，也就是 this
 *
 */
public class TicketSynchronizedMethod implements Runnable {
    private int ticket = 100;



    @Override
    public void run() {
        System.out.println("this:" + this);
        // 调用同步方法
        sellTicket();
    }

    // 同步方法
    public synchronized void sellTicket() {
        while (true) {
            if (ticket > 0) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + "正在卖第" + ticket + "张票");
                ticket--;

            } else {
                break;
            }
        }

    }
}

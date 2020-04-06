package demo06;

/**
 * 同步代码块
 *
 *  synchronized 关键字可以用于方法中的某个代码块中，表示只对这个区块的资源实行互斥访问
 *
 *  在任何时候，最多允许一个线程拥有同步锁,谁拿到锁就进入代码块,其他的线程处于阻塞状态(BLOCKED)
 *
 * 格式:
 * synchronized(锁对象) {
 *     // 可能会出现线程安全问题的代码
 * }
 *
 * 注意：
 * 1. 同步代码块中的锁对象可以使用任意对象
 * 2. 必须保证多个线程使用的锁对象是同一个锁对象
 * 3. 锁对象的作用：把同步代码块锁住，只让一个线程在同步代码块中执行
 *
 *
 *
 */
public class TicketSynchronizedBlock implements Runnable {
    private int ticket = 100;
    // 创建一个锁对象
    final Object lock = new Object();

    @Override
    public void run() {
        while (true) {
            // 同步代码块，解决线程安全问题
            synchronized (lock) {
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
}

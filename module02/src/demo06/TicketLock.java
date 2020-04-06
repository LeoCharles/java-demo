package demo06;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * java.util.concurrent.locks.Lock 接口
 *
 * 使用 Lock 锁解决线程安全问题
 *
 * Lock 锁机制提供了比同步代码块和同步方法更广泛的锁定操作
 *
 * Lock 接口中的方法：
 * public void lock() : 加同步锁。
 * public void unlock() :释放同步锁。
 *
 * java.util.concurrent.locks.ReentrantLock 实现了 Lock 接口
 *
 * 使用步骤：
 * 1. 在成员变量位置创建一个 ReentrantLock 对象
 * 2. 在可能出现线程安全的代码前调用 lock() 方法加锁
 * 3. 在可能出现线程安全的代码后调用 unlock() 方法解锁
 *
 *
 *
 *
 */
public class TicketLock  implements Runnable{
    private int ticket = 100;

    // 创建 ReentrantLock 对象
    Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {

            // 加锁
            lock.lock();

            if (ticket > 0) {
                try {
                    Thread.sleep(10);

                    System.out.println(Thread.currentThread().getName() + "正在卖第" + ticket + "张票");
                    ticket--;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            } else {
                break;
            }

            // 解锁
            lock.unlock();
        }
    }
}

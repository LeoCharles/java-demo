package demo06;

/**
 * 多个线程同时对共享的资源进行读写操作，可能会有线程安全问题
 *
 * 为了保证每个线程都能正确执行操作，Java 引入了线程同步机制
 *
 * 线程同步的三种方式：
 * 1.同步代码块
 * 2.同步方法
 * 3.锁机制
 *
 *
 *
 *
 */
public class SynchronizedTest {
    public static void main(String[] args) {
//        testThreadUnsafe();
//        testSynchronizedBlock();
        testSynchronizedMethod();

    }

    // 多线程同时操作共享资源，会有线程安全问题
    public static void testThreadUnsafe() {
        // 创建 Runnable 接口的实现类对象
        TicketRunnable run = new TicketRunnable();
        // 创建 Thread 类对象
        Thread t0 = new Thread(run);
        Thread t1 = new Thread(run);
        Thread t2 = new Thread(run);
        // 调用 start 方法，开启多线程
        t0.start();
        t1.start();
        t2.start();
    }

    // 同步代码块解决线程安全问题
    public static void testSynchronizedBlock() {
        // 创建 Runnable 接口的实现类对象
        TicketSynchronizedBlock run = new TicketSynchronizedBlock();
        // 创建 Thread 类对象
        Thread t0 = new Thread(run);
        Thread t1 = new Thread(run);
        Thread t2 = new Thread(run);
        // 调用 start 方法，开启多线程
        t0.start();
        t1.start();
        t2.start();
    }

    // 同步方法解决线程安全问题
    public static void testSynchronizedMethod() {
        // 创建 Runnable 接口的实现类对象
        TicketSynchronizedMethod run = new TicketSynchronizedMethod();
        System.out.println("run:" + run);
        // 创建 Thread 类对象
        Thread t0 = new Thread(run);
        Thread t1 = new Thread(run);
        Thread t2 = new Thread(run);
        // 调用 start 方法，开启多线程
        t0.start();
        t1.start();
        t2.start();
    }
}

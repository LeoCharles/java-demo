package demo06;

/**
 * 进程：是指一个内存中运行的应用程序，每个进程都有一个独立的内存空间，一个应用程序可以同时运行多个进程。
 * 线程：是进程中的一个执行单元，负责当前进程中程序的执行，一个进程中至少有一个线程。一个进程中是可以有多个线程。
 *
 * 一个程序运行后至少有一个进程，一个进程中可以包含多个线程
 *
 * 实现多任务的方法，既可以由多进程实现，也可以由单进程内的多线程实现，还可以混合多进程＋多线程。
 *
 *
 * 多进程的优点：
 * 1.多进程稳定性比多线程高，因为在多进程的情况下，一个进程崩溃不会影响其他进程
 * 2.多线程的情况下，任何一个线程崩溃会直接导致整个进程崩溃
 *
 * 多进程的缺点：
 * 1. 创建进程比创建线程开销大，尤其是在 Windows 系统上
 * 2. 进程间通信比线程间通信要慢，因为线程间通信就是读写同一个变量，速度很快
 *
 * 多线程：
 * 一个 Java 程序实际上是一个 JVM 进程，JVM 进程用一个主线程来执行 main()方法，在 main() 方法内部，又可以启动多个线程。
 * 此外，JVM 还有负责垃圾回收的其他工作线程等。
 *
 * 多线程模型是 Java 程序最基本的并发模型，读写网络、数据库、Web开发等都依赖 Java 多线程模型。
 *
 * 线程调度
 * 分时调度：所有线程轮流使用 CPU 的使用权，平均分配每个线程占用 CPU 的时间
 * 抢占式调度：优先让优先级高的线程使用 CPU，如果线程的优先级相同，那么会随机选择一个(线程随机性)
 * Java 使用抢占式调度
 *
 * 线程的状态：
 * New：新创建的线程，尚未执行；
 * Runnable：运行中的线程，正在执行 run() 方法的 Java 代码；
 * Blocked：运行中的线程，因为某些操作被阻塞而挂起；
 * Waiting：运行中的线程，因为某些操作在等待中；
 * Timed Waiting：运行中的线程，因为执行 sleep()方法正在计时等待；
 * Terminated：线程已终止，因为run()方法执行完毕。
 *
 * 当线程启动后，它可以在 Runnable、Blocked、Waiting 和 Timed Waiting 这几个状态之间切换
 * 直到最后变成 Terminated 状态，线程终止。
 *
 * Timed Waiting 计时等待状态
 * 1.调用 sleep(long m) 方法，线程就会进入到计时等待状态，睡眠时间结束后进入可运行或阻塞状态
 * 2.调用 wait(long m) 方法，线程就会进入到计时等待状态，如果在等待时间结束后没有被 notify 唤醒，自定进入可运行或阻塞状态
 *
 * Blocked 锁阻塞状态
 * 没有争取到锁对象的线程进入锁阻塞状态
 *
 * Waiting 无限等待状态
 * 一个正在无限期等待另一个线程执行一个唤醒动作的线程处于无限等待状态
 *
 * void wait(): 在其他线程调用此对象的 notify() 或 notifyAll() 前，保持当前线程等待
 * void notify(): 唤醒在此对象监视器(对象锁)上等待的单个线程，继续执行 wait 方法后的代码
 * void notifyAll()：唤醒在此对象监视器(对象锁)上等待的所有线程
 *
 *
 */
public class MainThread {
    public static void main(String[] args) {

//        testSleep();
        testWaitAndNotify();


    }

    // Timed Waiting 计时等待状态
    public static void testSleep() {
        for (int i = 0; i < 60; i++) {
            System.out.println(i);

            // 使用 sleep 方法，让程序睡眠指定的时间
            // 线程进入Timed Waiting 状态
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // 等待与唤醒，线程执行的通信
    // 消费者线程和生产者线程必须使用同步代码块，确保等待和唤醒只有一个在执行
    // 同步锁对象必须确保唯一，只有锁对象才能调用 wait 和 notify 方法
    public static void testWaitAndNotify() {
        // 创建锁对象，保证唯一
        final Object lock = new Object();

        // 创建消费者线程
        new Thread() {
            @Override
            public void run() {
                // 确保等待和唤醒只有一个在执行，需要同步技术
                synchronized (lock) {
                    System.out.println("消费者 1 告诉生产者产品的种类和数量");

                    // 调用 wait 方法，放弃 cpu 执行，进入无限等待状态
                    try {
                        lock.wait();
//                        lock.wait(5000); // 计时等待,等待时间到，自动醒来

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    // 唤醒之后执行的代码
                    System.out.println("消费者 1 被唤醒，可以使用产品了");
                }

            }
        }.start(); // 开启线程

        // 创建消费者线程
        new Thread() {
            @Override
            public void run() {
                // 确保等待和唤醒只有一个在执行，需要同步技术
                synchronized (lock) {
                    System.out.println("消费者 2 告诉生产者产品的种类和数量");

                    // 调用 wait 方法，放弃 cpu 执行，进入无限等待状态
                    try {
                        lock.wait();
//                        lock.wait(5000); // 计时等待,等待时间到，自动醒来

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    // 唤醒之后执行的代码
                    System.out.println("消费者 2 被唤醒，可以使用产品了");
                }

            }
        }.start(); // 开启线程

        // 创建生产者线程
        new Thread() {
            @Override
            public void run() {
                try {
                    // 经过一段时间，生产产品
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 确保等待和唤醒只有一个在执行，需要同步技术
                synchronized (lock) {
                    System.out.println("生产者生产出了产品，通知消费者");
                    // 随机唤醒单个消费者，执行后续代码
//                    lock.notify();
                    // 唤醒所有消费者，执行后续代码
                    lock.notifyAll();
                }
            }
        }.start(); // 开启线程
    }


}

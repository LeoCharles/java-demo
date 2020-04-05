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

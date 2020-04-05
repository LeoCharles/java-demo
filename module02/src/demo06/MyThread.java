package demo06;

/**
 * 创建多线程的第一种方式：继承 Thread 类
 *
 * Thread 类的构造方法：
 * public Thread() :分配一个新的线程对象。
 * public Thread(String name) :分配一个指定名字的新的线程对象。
 * public Thread(Runnable target) :分配一个带有指定目标新的线程对象。
 * public Thread(Runnable target,String name) :分配一个带有指定目标新的线程对象并指定名字。
 *
 * Thread 类的常用方法：
 * public String getName() :获取当前线程名称。
 * public void start() :导致此线程开始执行; Java虚拟机调用此线程的run方法。
 * public void run() :此线程要执行的任务在此处定义代码。
 * public static void sleep(long millis) :使当前正在执行的线程以指定的毫秒数暂停（暂时停止执行）。
 * public static Thread currentThread() :返回对当前正在执行的线程对象的引用。
 * public int getPriority() 返回线程的优先级。
 * public void setPriority(int newPriority) 更改线程的优先级。
 *
 */
public class MyThread extends Thread {

    public MyThread() {
    }

    public MyThread(String name) {
        super(name);
    }

    // 重写 run 方法，设置线程任务
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            // getName() :获取当前线程名称
            System.out.println("子线程" + getName() + "-->" + i);
        }
    }
}

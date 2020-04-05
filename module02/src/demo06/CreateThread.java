package demo06;

/**
 * java.lang.Thread 类表示线程，所有的线程对象都必须是 Thread 类或其子类的实例。
 *
 * 继承 Thread 类创建多线程
 * 1. 创建一个 Thread 类的子类，在子类中重写 run 方法，设置线程任务
 * 2. 创建子类对象，调用 Thread 类 start 方法，开启新的线程，执行线程任务
 *
 * 实现 Runnable 接口创建多线程
 * 1. 定义 Runnable 接口的实现类，并重写该接口的 run 方法，设置线程任务
 * 2. 创建 Thread 类对象，构造方法中传递 Runnable 接口的实现类对象
 * 3. 调用线程对象的 start 方法
 *
 * 实现 Runnable 接口创建多线程的优点：
 * 1.避免了单继承的局限性，实现了 Runnable 接口，还可以继承其他的类，实现其他接口
 * 2.增强的了程序的扩展性（解耦），把设置线程任务和开启新线程进行了分离，
 *   传递不同的实现类，实现不同的线程任务
 *
 * 使用匿名内部类创建多线程
 *
 * 格式：
 * new Thread/Runnable () {
 *     重写 run 方法
 * }
 *
 *
 */
public class CreateThread {
    public static void main(String[] args) {
//        test01();
//        test02();
        test03();

    }

    // 继承 Thread 类创建多线程
    public static void test01() {
        // 创建子线程对象
        MyThread myThread = new MyThread();

        // 调用 Thread 类的 start 方法，开启子线程，执行 run 方法
        myThread.start();

        // 主线程和新的线程一起抢夺 cpu 的执行权，随机打印
        for (int i = 0; i < 20; i++) {
            // Thread.currentThread().getName() 获取当前线程名称
            System.out.println("主线程" + Thread.currentThread().getName() + "-->" + i);
        }
    }

    // 实现 Runnable 接口创建多线程
    public static void test02() {
        // 创建一个 Runnable 接口的实现类对象
        Runnable myRunnable = new MyRunnable();

        // 创建 Thread 类对象，构造方法中传递 Runnable 接口的实现类对象
        // 传递不同的实现类对象，可以实现不同的线程任务
        Thread thread = new Thread(myRunnable);

        // 调用 Thread 类的 start 方法，开启新的线程，执行 run 方法
        thread.start();

        // 主线程
        for (int i = 0; i < 20; i++) {
            System.out.println("主线程" + Thread.currentThread().getName() + "-->" + i);
        }
    }

    // 使用匿名内部类创建多线程
    public static void test03() {
        // 线程的父类 Thread
        new Thread() {
            // 线程任务
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println("子线程0" + Thread.currentThread().getName() + "-->" + i);
                }
            }
        }.start(); // 开启新线程

        // 线程的接口 Runnable
        Runnable r = new Runnable() {
            // 线程任务
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println("子线程1" + Thread.currentThread().getName() + "-->" + i);
                }
            }
        };
        // 开启新线程
        new Thread(r).start();

        // 简化接口的方法
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println("子线程2" + Thread.currentThread().getName() + "-->" + i);
                }
            }
        }).start();

    }
}

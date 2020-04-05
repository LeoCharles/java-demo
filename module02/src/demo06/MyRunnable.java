package demo06;

/**
 * 创建多线程的第二种方法：实现 Runnable 接口
 *
 *
 */

public class MyRunnable implements Runnable  {

    // 重写 run 方法
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            // Thread.currentThread().getName() 获取当前线程名称
            System.out.println("子线程" + Thread.currentThread().getName() + "-->" + i);
        }
    }
}

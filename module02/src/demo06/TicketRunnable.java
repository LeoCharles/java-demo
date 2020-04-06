package demo06;

/**
 * 多线程同时操作共享资源，会产生线程安全性问题
 */
public class TicketRunnable implements Runnable {
    // 定义一个多线程共享的数据
    private int ticket = 100;

    // 设置线程任务，卖票
    @Override
    public void run() {
        // 重复卖票
        while (true) {
            if (ticket > 0) {
                // 为了提高安全性问题出现的概率，设置睡眠
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

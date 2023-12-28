package javahigh.day02.com.atguigu.java1;


import java.util.concurrent.locks.ReentrantLock;

/**
 * 解决线程安全问题的方式三:Lock锁     ----JDK5.0新增
 * <p>
 * 1.面试题：synchronized 与 Lock的异同？
 * 相同：二者都可以解决线程安全问题
 * 不同：synchronized机制在执行完相应的代码以后，自动的释放同步监视器
 * Lock需要手动的启动同步（Lock()）,同时结束同步也需要手动的实现（unlock()）
 * Lock->同步代码块（已经进入了方法体，分配了相应的资源）->同步方法（在方法体之外）
 * <p>
 * 2.面试题 解决线程安全问题有哪几种方式？
 * 1.synchronized
 * （1）同步代码块
 * 1.同步监视器（
 * （1）类.class[类只加载一次]，当前类
 * （2）this[在实现runnable接口的时候，作为唯一对象，注释：共享资源]
 * ）
 * （2）同步方法
 * * 关于同步方法的总结
 * * 1.同步方法仍然涉及到同步监视器，只是不需要我们显示声明
 * * 2.非静态的同步方法，同步监视器是：this[监听的是当前类的对象]   用在实现runnalble接口中
 * 例：newThread（window1）
 * window1实现runnable接口，但是实际就一个对象 都是window1，所以可以做同步监视器
 * 【而继承的thread的进程类，每次都创建新的进程，不是同步资源去进行同步监视，都单独计数。】
 * <p>
 * * 3.静态的同步方法，同步监视器是：当前类本身  用在继承Thread类中。
 * *
 * 2.Lock
 *
 * @author lizhihao
 * @create 2023-09-24 下午：20：59
 */

class Window implements Runnable {
    private int ticket = 100;

    //1.实例化ReentrantLock
    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            try {

                //2.调用锁定方法lock()【获取同步监视器】
                lock.lock();

                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Thread.currentThread().getName() + ":售票，票号为：" + ticket);
                    ticket--;
                } else {
                    break;
                }
            } finally {
                //3.调用解锁方法：unlock()
                lock.unlock();
            }
        }
    }
}

public class LockTest {
    public static void main(String[] args) {
        Window w = new Window();
        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.setName("窗口一");
        t2.setName("窗口二");
        t3.setName("窗口三");

        t1.start();
        t2.start();
        t3.start();
    }

}



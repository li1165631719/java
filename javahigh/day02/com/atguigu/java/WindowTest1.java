package javahigh.day02.com.atguigu.java;

/**
 * 例子：创建三个窗口卖票，总票数为100，使用实现Runnable接口的方式
 * 存在线程安全问题，待解决
 * 1.问题：在卖票过程中，出现了重票、错票---->出现了线程安全的问题
 * 2.问题出现的原因：当某个线程操作车票的过程中，尚未操作完成时，其他线程参与进来，也操作车票
 * 3.如何解决：当一个线程在操作ticket的时候，其他线程不能参与进来，直到线程a操作完ticket的时候，
 * 其他线程才可以开始操作ticket。即使线程a出现的阻塞，也不能改变。
 * 4.在java中，我们通过同步机制，来解决线程问题。
 * <p>
 * 方式一：同步代码块
 * synchronized(同步监视器){
 * //需要被同步的代码
 * <p>
 * <p>
 * }
 * 说明：1.操作共享数据的代码，即为需要被同步的代码
 * 2.共享数据：多个线程共同操作的变量。比如：ticket就是共享数据
 * 3.同步监视器，俗称：锁。任何一个类的对象，都会充当锁。
 * 要求：多个线程共用同一把锁
 * <p>
 * 补充：在实现Runnable接口创建的多线程的方式中，我们可以考虑用this充当同步监视器
 * 方式二：同步方法
 * 如果操作共享数据的代码完整的声明在一个方法中，我们不妨将此方法声明为同步的。
 * <p>
 * <p>
 * <p>
 * <p>
 * 5.同步的方式，解决了线程的安全问题  ----好处
 * 操作同步代码时，只能有一个线程，其他线程等待，相当于一个单线程的过程，效率低。------局限性
 *
 * @author 李志豪
 * @create 2023/5/8
 */
class Window1 implements Runnable {
    //不加static，用的同一对象的数据
    private int ticket = 100;
//    Object obj=new Object();

    @Override
    public void run() {
        while (true) {
            synchronized (this) {//此时的this：唯一的window的对象 方式二：synchronized (obj)
                if (ticket > 0) {
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }//重票
                    System.out.println(Thread.currentThread().getName() + "票号为：" + ticket);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }//错票
                    ticket--;
                } else {
                    //     System.out.println("已无余票出售");
                    break;
                }
            }
        }
    }
}

public class WindowTest1 {
    public static void main(String[] args) {
        Window1 window1 = new Window1();
        Thread t1 = new Thread(window1);
        Thread t2 = new Thread(window1);
        Thread t3 = new Thread(window1);

        t1.setName("窗口一");
        t2.setName("窗口二");
        t3.setName("窗口三");

        t1.start();
        t2.start();
        t3.start();
    }
}

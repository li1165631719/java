package javahigh.day02.com.atguigu.java;

/**
 * 使用同步方法解决实现Runnable接口的线程安全问题
 * <p>
 * <p>
 * 关于同步方法的总结
 * 1.同步方法仍然涉及到同步监视器，只是不需要我们显示声明
 * 2.非静态的同步方法，同步监视器是：this
 * 3.静态的同步方法，同步监视器是：当前类本身
 *
 * @author 李志豪
 * @create 2023/8/11
 */
class Window3 implements Runnable {
    //不加static，用的同一对象的数据
    private int ticket = 100;

    @Override
    public void run() {//synchronized 直接加，使得并行部分都上锁了
        while (true) {
            show();
        }
    }

    private synchronized void show() {//同步监视器：this
        if (ticket > 0) {
            System.out.println(Thread.currentThread().getName() + "票号为：" + ticket);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }//错票
            ticket--;
        }
//        } else {
//            //       System.out.println("已无余票出售");
//            break;
//        }
    }
}

public class WindowTest3 {
    public static void main(String[] args) {
        Window3 window3 = new Window3();
        Thread t1 = new Thread(window3);
        Thread t2 = new Thread(window3);
        Thread t3 = new Thread(window3);

        t1.setName("窗口一");
        t2.setName("窗口二");
        t3.setName("窗口三");

        t1.start();
        t2.start();
        t3.start();
    }
}
package javahigh.day01.java;

/**
 * 例子：创建三个窗口卖票，总票数为100，使用实现Runnable接口的方式
 * 存在线程安全问题，待解决
 *
 * @author 李志豪
 * @create 2023/5/8
 */
class Window1 implements Runnable {

    //不加static，用的同一对象的数据
    private int ticket = 100;

    @Override
    public void run() {
        while (true) {
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + "票号为：" + ticket);
                ticket--;
            } else {
                System.out.println("已无余票出售");
                break;
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

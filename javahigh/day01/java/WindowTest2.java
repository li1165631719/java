package javahigh.day01.java;

/**
 * 例子：创建三个窗口卖票，总票数为100张，使用继承Thread类的方式
 * <p>
 * <p>
 * 说明：在继承Thread类的方式中，慎用this充当同步监视器，可以考虑使用当前类使用同步监视器(当前类：类.class)
 * (在实现runnable接口的模式中使用this去当同步监视器，因为就一个) 只加载一次，所以不会被其他人用到
 *
 * @author 李志豪
 * @create 2023/5/6
 */

//本身就是个线程的子类中，不要当前线程
class Window2 extends Thread {//现在的猜想的是window只会被其中一个对象所占有。

    private static int ticket = 100;
    private static Object obj = new Object();

    @Override
    public void run() {
        //synchronized (obj) {//这样的话，一个窗口把票全卖完了
        while (true) {
            //正确的
            //synchronized (obj){
            synchronized (Window2.class) {//Class clazz = Window2.class  类只会加载一次
                //错误的的方式，this代表t1,t2.t3三个对象
                //synchronized (this) {
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(getName() + ":卖票，票号为：" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
            //  }

        }
    }

}

public class WindowTest2 {
    public static void main(String[] args) {
        Window2 w1 = new Window2();
        Window2 w2 = new Window2();
        Window2 w3 = new Window2();

        w1.setName("窗口一");
        w2.setName("窗口二");
        w3.setName("窗口三");

        w1.start();
        w2.start();
        w3.start();


    }
}
package javahigh.day01.java;

/**
 * 多线程的创建，方式一：继承于Thread类
 * 1.创建一个继承于Thread类的子类
 * 2.重写Thread类的run方法 ---> 将此线程执行的操作声明在run方法中
 * 3.创建Thread类的子类的对象
 * 4.通过对象调用start方法
 * <p>
 * 例子：遍历100以内的所有偶数
 *
 * @author 李志豪
 * @create 2023/4/11
 */

//1、创建一个继承于Thread类的子类
class MyThread extends Thread {
    //2、重写Thread类的run（）方法
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }


}

public class ThreadTest {

    public static void main(String[] args) {
        //3.创建Thread类的子类的对象
        MyThread myThread = new MyThread();
        //4.通过对象调用start方法
        myThread.start();

        //问题一：我们不能直接调用run（）的方法启动线程
        //      myThread.run();

        //问题二：再启动一个线程，遍历100以内的偶数，不可以还让已经start()的线程去执行。会报IllegalThreadStateException
//        myThread.start();
        //我们需要重新创建一个线程的对象
        MyThread myThread1 = new MyThread();
        myThread1.start();
        //如下操作仍然是在main线程中执行的
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i + "*************************main()****************************");
            }
        }
        System.out.println("hello");

    }
}

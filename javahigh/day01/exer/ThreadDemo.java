package javahigh.day01.exer;

/**
 * 练习：创建两个分线程，其中一个线程遍历100以内的偶数，另一个进程遍历100以内的奇数
 *
 * @author 李志豪
 * @create 2023/4/21
 */
public class ThreadDemo {
    public static void main(String[] args) {
//        MyThread1 myThread1=new MyThread1();
//        MyThread2 myThread2=new MyThread2();
//
//        myThread1.start();
//        myThread2.start();

        //创建thread类的匿名子类的方式
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if (i % 2 == 0) {
                        System.out.println(Thread.currentThread().getName() + ":" + i);
                    }
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if (i % 2 != 0) {
                        System.out.println(Thread.currentThread().getName() + ":" + i);
                    }
                }
            }
        }.start();

    }

}

//1、创建一个继承于Thread类的子类
class MyThread1 extends Thread {
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

//1、创建一个继承于Thread类的子类
class MyThread2 extends Thread {
    //2、重写Thread类的run（）方法
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}
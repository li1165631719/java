package javahigh.day01.exer;

/**
 * ��ϰ�������������̣߳�����һ���̱߳���100���ڵ�ż������һ�����̱���100���ڵ�����
 *
 * @author ��־��
 * @create 2023/4/21
 */
public class ThreadDemo {
    public static void main(String[] args) {
//        MyThread1 myThread1=new MyThread1();
//        MyThread2 myThread2=new MyThread2();
//
//        myThread1.start();
//        myThread2.start();

        //����thread�����������ķ�ʽ
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

//1������һ���̳���Thread�������
class MyThread1 extends Thread {
    //2����дThread���run��������
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}

//1������һ���̳���Thread�������
class MyThread2 extends Thread {
    //2����дThread���run��������
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}
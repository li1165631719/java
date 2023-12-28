package javahigh.day01.java;

/**
 * ���̵߳Ĵ�������ʽһ���̳���Thread��
 * 1.����һ���̳���Thread�������
 * 2.��дThread���run���� ---> �����߳�ִ�еĲ���������run������
 * 3.����Thread�������Ķ���
 * 4.ͨ���������start����
 * <p>
 * ���ӣ�����100���ڵ�����ż��
 *
 * @author ��־��
 * @create 2023/4/11
 */

//1������һ���̳���Thread�������
class MyThread extends Thread {
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

public class ThreadTest {

    public static void main(String[] args) {
        //3.����Thread�������Ķ���
        MyThread myThread = new MyThread();
        //4.ͨ���������start����
        myThread.start();

        //����һ�����ǲ���ֱ�ӵ���run�����ķ��������߳�
        //      myThread.run();

        //�������������һ���̣߳�����100���ڵ�ż���������Ի����Ѿ�start()���߳�ȥִ�С��ᱨIllegalThreadStateException
//        myThread.start();
        //������Ҫ���´���һ���̵߳Ķ���
        MyThread myThread1 = new MyThread();
        myThread1.start();
        //���²�����Ȼ����main�߳���ִ�е�
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i + "*************************main()****************************");
            }
        }
        System.out.println("hello");

    }
}

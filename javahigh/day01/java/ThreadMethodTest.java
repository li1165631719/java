package javahigh.day01.java;

/**
 * ����thread��ĳ��÷���
 * void start():�����̣߳���ִ�ж����run����
 * run():�߳��ڱ�����ʱִ�еĲ������������̵߳�Ҫִ�еĲ��������ڴ˷�����
 * String getName():�����̵߳�����
 * void setName(String name):�����߳�����
 * static Thread currentThread():���ص�ǰ���̡߳���Thread�����о���this��ͨ���������̵߳ĺ�Runnableʵ����
 * yeild():�ͷŵ�ǰcpu��ִ��
 * join():���߳�a�е����߳�b��join()����ʱ���߳�a�ͽ�������״̬��ֱ���߳�b��ȫִ�����Ժ��߳�a�Ž�������״̬
 * stop():ǿ���߳��������ڽ��������Ƽ�ʹ��
 * sleep(long millitime):�õ�ǰ�̡߳�˯�ߡ�ָ����millitime���룬��ָ����millitimeʱ���ڣ���ǰ�߳��Ƕ���״̬
 * ��λ�����룩 ����Ӧ�õ���ʱ ÿ����һ��
 * isAlive():�жϵ�ǰ�߳��Ƿ���
 * <p>
 * <p>
 * �̵߳����ȼ���
 * 1.
 * MIN_PRIORITY = 1;
 * NORM_PRIORITY=5; ------>normal  Ĭ�ϵ����ȼ�
 * MAX_PRIORITY=10;
 * 2.��λ�ȡ�����õ�ǰ�̵߳����ȼ�
 * getPriority();��ȡ�̵߳����ȼ�
 * setPriority(int p);�����̵߳����ȼ�
 * <p>
 * ˵���������ȼ����߳�Ҫ��ռ�����ȼ��̵߳�cpuִ��Ȩ������ֻ�ǴӸ����������������ȼ����̸߳߸��ʵ������
 * ��ִ�У�������ζ��ֻ�е������ȼ����߳�ִ�����Ժ󣬲�ִ�е����ȼ����߳�
 * <p>
 * �߳�ͨ�ţ�wait()/notify()/notifyAll():�����������Ƕ�����Object���еġ�
 *
 * @author ��־��
 * @create 2023/5/4
 */
class HelloThread extends Thread {
    //ͨ�����������߳�������
    HelloThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {

                //ֻ��try-catch����Ϊ�����û�����쳣�����಻���׳���throws���ȸ��������쳣
//                try {
//                    sleep(10);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }

                System.out.println(Thread.currentThread().getName() + ":" + Thread.currentThread().getPriority() + ":" + i);
            }

//            if(i%20==0){
//                yield();
//                //this.yield();
//                //Thread.currentThread().yield();
//
//            }
        }


    }

}

public class ThreadMethodTest {
    public static void main(String args[]) {
        HelloThread h1 = new HelloThread("Thread:1");
        //h1.setName("�߳�һ");

        //���÷��̵߳����ȼ�
        h1.setPriority(Thread.MAX_PRIORITY);

        h1.start();


        //���߳�
        Thread.currentThread().setName("���߳�");
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + Thread.currentThread().getPriority() + ":" + i);
            }

//            if(i==20){
//                try {
//                    h1.join();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
        }

        System.out.println(h1.isAlive());

    }
}


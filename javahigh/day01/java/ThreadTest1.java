package javahigh.day01.java;

/**
 * �������̵߳ķ�ʽ����ʵ��Runnable�ӿ�
 * 1.����һ��ʵ����Runnable�ӿڵ���
 * 2.ʵ����ȥʵ��Runnable�ĳ��󷽷�:run();
 * 3.����ʵ����ĵĶ���
 * 4.���˶�����Ϊ�������ݵ�Thread��Ĺ������У�����Thread��Ķ���
 * 5.ͨ��Thread��Ķ������start()����
 * <p>
 * �Ƚϴ����̵߳����ַ�ʽ��
 * �����У�����ѡ��ʵ��Runnable�ӿڵķ�ʽ
 * ԭ��1��ʵ�ֵķ�ʽû����ĵ��̳о�����
 * 2��ʵ�ֵķ�ʽ���ʺϴ������߳��й������ݵ����
 * <p>
 * ��ϵ:public class Thread implements Runnnable
 * ��ͬ�㣺���ַ�ʽ��������дrun()�����߳�ִ���߼�������run()��
 * Ŀǰ���ַ�ʽ��Ҫ�������̣߳����ǵ��õ�Thread���е�start����
 *
 * @author ��־��
 * @create 2023/5/8
 */
//1.����һ��ʵ����Runnable�ӿڵ���
class MThread implements Runnable {
    //2.ʵ����ȥʵ��Runnable�ĳ��󷽷�:run();
    @Override
    public void run() {

        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }

    }
}


public class ThreadTest1 {
    public static void main(String[] args) {
        //3.����ʵ����ĵĶ���
        MThread mThread = new MThread();
        //4.���˶�����Ϊ�������ݵ�Thread��Ĺ������У�����Thread��Ķ���
        Thread t1 = new Thread(mThread);
        //5.ͨ��Thread��Ķ������start():�������߳� �ڵ��õ�ǰ�̵߳�run();
        t1.setName("�߳�һ");
        t1.start();

        //������һ���̣߳�����100���ڵ�ż��
        Thread t2 = new Thread(mThread);
        t2.setName("�̶߳�");
        t2.start();

    }


}

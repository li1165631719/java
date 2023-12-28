package javahigh.day02.com.atguigu.java1;


import java.util.concurrent.locks.ReentrantLock;

/**
 * ����̰߳�ȫ����ķ�ʽ��:Lock��     ----JDK5.0����
 * <p>
 * 1.�����⣺synchronized �� Lock����ͬ��
 * ��ͬ�����߶����Խ���̰߳�ȫ����
 * ��ͬ��synchronized������ִ������Ӧ�Ĵ����Ժ��Զ����ͷ�ͬ��������
 * Lock��Ҫ�ֶ�������ͬ����Lock()��,ͬʱ����ͬ��Ҳ��Ҫ�ֶ���ʵ�֣�unlock()��
 * Lock->ͬ������飨�Ѿ������˷����壬��������Ӧ����Դ��->ͬ���������ڷ�����֮�⣩
 * <p>
 * 2.������ ����̰߳�ȫ�������ļ��ַ�ʽ��
 * 1.synchronized
 * ��1��ͬ�������
 * 1.ͬ����������
 * ��1����.class[��ֻ����һ��]����ǰ��
 * ��2��this[��ʵ��runnable�ӿڵ�ʱ����ΪΨһ����ע�ͣ�������Դ]
 * ��
 * ��2��ͬ������
 * * ����ͬ���������ܽ�
 * * 1.ͬ��������Ȼ�漰��ͬ����������ֻ�ǲ���Ҫ������ʾ����
 * * 2.�Ǿ�̬��ͬ��������ͬ���������ǣ�this[�������ǵ�ǰ��Ķ���]   ����ʵ��runnalble�ӿ���
 * ����newThread��window1��
 * window1ʵ��runnable�ӿڣ�����ʵ�ʾ�һ������ ����window1�����Կ�����ͬ��������
 * �����̳е�thread�Ľ����࣬ÿ�ζ������µĽ��̣�����ͬ����Դȥ����ͬ�����ӣ���������������
 * <p>
 * * 3.��̬��ͬ��������ͬ���������ǣ���ǰ�౾��  ���ڼ̳�Thread���С�
 * *
 * 2.Lock
 *
 * @author lizhihao
 * @create 2023-09-24 ���磺20��59
 */

class Window implements Runnable {
    private int ticket = 100;

    //1.ʵ����ReentrantLock
    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            try {

                //2.������������lock()����ȡͬ����������
                lock.lock();

                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Thread.currentThread().getName() + ":��Ʊ��Ʊ��Ϊ��" + ticket);
                    ticket--;
                } else {
                    break;
                }
            } finally {
                //3.���ý���������unlock()
                lock.unlock();
            }
        }
    }
}

public class LockTest {
    public static void main(String[] args) {
        Window w = new Window();
        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.setName("����һ");
        t2.setName("���ڶ�");
        t3.setName("������");

        t1.start();
        t2.start();
        t3.start();
    }

}



package javahigh.day02.com.atguigu.java2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * �����̵߳ķ�ʽ�ģ�ʹ���̳߳�
 * <p>
 * �ô���
 * 1.�����Ӧ�ٶȣ������˴������̵߳�ʱ�䣩
 * 2. ������Դ���ģ��ظ������̳߳����̣߳�����Ҫÿ�ζ�������
 * 3. �����̹߳���
 * corePoolSize�����ĳصĴ�С
 * maximumPoolSize������߳���
 * keepAliveTime���߳�û������ʱ��ౣ�ֶ೤ʱ������ֹ
 *
 * @author ��־��
 * @create 2023/10/9
 */
class NumberThread implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}

class NumberThread1 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}

public class ThreadPool {
    public static void main(String[] args) {
        //1.�ṩָ���߳��������̳߳�
        ExecutorService service = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor service1 = (ThreadPoolExecutor) service;

        //�����̳߳ص�����
        //System.out.println(service.getClass());
        service1.setCorePoolSize(15);
        service1.setKeepAliveTime(1000, TimeUnit.SECONDS);

        //2.ִ��ָ�����̵߳Ĳ�������Ҫ�ṩһ��ʵ��Runnable�ӿڻ�Callable�ӿ�ʵ����Ķ���
        service.execute(new NumberThread());//�ʺ�������Runnbale
        service.execute(new NumberThread1());//�ʺ�������Runnbale
//        service.submit();//�ʺ�������Callable

        //3.�ر��̳߳�
        service.shutdown();


    }
}

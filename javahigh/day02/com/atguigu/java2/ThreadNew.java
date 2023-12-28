package javahigh.day02.com.atguigu.java2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * �����̵߳÷�ʽ����ʵ��Callable�ӿڡ�-----JDK 5.0����
 * <p>
 * ������ʵ��Callable�ӿڵķ�ʽ�������̱߳�ʵ��Runnable�ӿ�ʵ�ֶ��߳�Ҫǿ��
 * 1.call()���������з���ֵ
 * 2.call()���������׳��쳣��������Ĳ������񣬻�ȡ�쳣��Ϣ
 * 3.Callable��֧�ַ��͵�
 *
 * @author ��־��
 * @create 2023/10/9
 */
//1.����һ��ʵ��Callable��ʵ����
class NumThread implements Callable<Integer> {
    //2.ʵ��call�����������߳���Ҫִ�еĲ���������call������
    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
                sum += i;
            }
        }
        return sum;
    }
}

public class ThreadNew {
    public static void main(String[] args) {
        //3.����Callable�ӿ�ʵ����Ķ���
        NumThread numThread = new NumThread();
        //4.��Callable�ӿ�ʵ����Ķ�����Ϊ�������ݵ�FutureTask�������У�����FutureTask�Ķ���
        FutureTask<Integer> futureTask = new FutureTask<Integer>(numThread);
        //5.��FutureTask�Ķ�����Ϊ�������ݵ�Thread��Ĺ������У�����Thread���󣬲�����start����
        Thread t1 = new Thread(futureTask);
        t1.start();
        try {
            //6.��ȡCallable��call()�����ķ���ֵ
            //get()�����ķ���ֵ��ΪfutureTask����������Callableʵ������д��call()�����ķ���ֵ
            Integer sum = futureTask.get();
            System.out.println("�ܺ�Ϊ��" + sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

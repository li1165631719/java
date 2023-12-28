package javahigh.day02.com.atguigu.java2;

/**
 * �߳�ͨ�ŵ����ӣ�ʹ���̴߳�ӡ1-100.�߳�1���߳�2�������ӡ
 *
 * @Author lizhihao
 * @Date 2023/10/5 20:18
 * @PackageName:javahigh.day02.com.atguigu.java2
 * @ClassName: CommunicationTest
 * @Description: TODO
 * @Version 1.0
 */

class Number implements Runnable {
    private int number = 1;

    @Override
    public void run() {

        //1-100
        while (true) {
            synchronized (this) {
                if (number < 100) {
                    System.out.println(Thread.currentThread().getName() + ":" + number);
                    number++;
                } else {
                    break;
                }
            }
        }
    }
}

public class CommunicationTest {
    public static void main(String[] args) {
        Number number = new Number();

    }
}

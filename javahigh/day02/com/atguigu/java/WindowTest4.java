package javahigh.day02.com.atguigu.java;

/**
 * @author ��־��
 * @create 2023/8/11
 */
class Window4 extends Thread {

    private static int ticket = 100;
    private static Object obj = new Object();

    private static synchronized void show() {//ͬ����������Window4.class
        //private  synchronized void show() {//ͬ����������t1,t2,t3,���ַ�������Ǵ����
        if (ticket > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + ":��Ʊ��Ʊ��Ϊ��" + ticket);
            ticket--;
        }
    }

    @Override
    public void run() {
        while (true) {
            show();
        }
    }

}

public class WindowTest4 {
    public static void main(String[] args) {
        Window4 w1 = new Window4();
        Window4 w2 = new Window4();
        Window4 w3 = new Window4();

        w1.setName("����һ");
        w2.setName("���ڶ�");
        w3.setName("������");

        w1.start();
        w2.start();
        w3.start();


    }
}

package javahigh.day01.java;

/**
 * ���ӣ���������������Ʊ����Ʊ��Ϊ100��ʹ��ʵ��Runnable�ӿڵķ�ʽ
 * �����̰߳�ȫ���⣬�����
 *
 * @author ��־��
 * @create 2023/5/8
 */
class Window1 implements Runnable {

    //����static���õ�ͬһ���������
    private int ticket = 100;

    @Override
    public void run() {
        while (true) {
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + "Ʊ��Ϊ��" + ticket);
                ticket--;
            } else {
                System.out.println("������Ʊ����");
                break;
            }


        }
    }
}

public class WindowTest1 {
    public static void main(String[] args) {
        Window1 window1 = new Window1();
        Thread t1 = new Thread(window1);
        Thread t2 = new Thread(window1);
        Thread t3 = new Thread(window1);

        t1.setName("����һ");
        t2.setName("���ڶ�");
        t3.setName("������");

        t1.start();
        t2.start();
        t3.start();
    }
}

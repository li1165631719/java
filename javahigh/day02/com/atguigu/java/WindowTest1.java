package javahigh.day02.com.atguigu.java;

/**
 * ���ӣ���������������Ʊ����Ʊ��Ϊ100��ʹ��ʵ��Runnable�ӿڵķ�ʽ
 * �����̰߳�ȫ���⣬�����
 * 1.���⣺����Ʊ�����У���������Ʊ����Ʊ---->�������̰߳�ȫ������
 * 2.������ֵ�ԭ�򣺵�ĳ���̲߳�����Ʊ�Ĺ����У���δ�������ʱ�������̲߳��������Ҳ������Ʊ
 * 3.��ν������һ���߳��ڲ���ticket��ʱ�������̲߳��ܲ��������ֱ���߳�a������ticket��ʱ��
 * �����̲߳ſ��Կ�ʼ����ticket����ʹ�߳�a���ֵ�������Ҳ���ܸı䡣
 * 4.��java�У�����ͨ��ͬ�����ƣ�������߳����⡣
 * <p>
 * ��ʽһ��ͬ�������
 * synchronized(ͬ��������){
 * //��Ҫ��ͬ���Ĵ���
 * <p>
 * <p>
 * }
 * ˵����1.�����������ݵĴ��룬��Ϊ��Ҫ��ͬ���Ĵ���
 * 2.�������ݣ�����̹߳�ͬ�����ı��������磺ticket���ǹ�������
 * 3.ͬ�����������׳ƣ������κ�һ����Ķ��󣬶���䵱����
 * Ҫ�󣺶���̹߳���ͬһ����
 * <p>
 * ���䣺��ʵ��Runnable�ӿڴ����Ķ��̵߳ķ�ʽ�У����ǿ��Կ�����this�䵱ͬ��������
 * ��ʽ����ͬ������
 * ��������������ݵĴ���������������һ�������У����ǲ������˷�������Ϊͬ���ġ�
 * <p>
 * <p>
 * <p>
 * <p>
 * 5.ͬ���ķ�ʽ��������̵߳İ�ȫ����  ----�ô�
 * ����ͬ������ʱ��ֻ����һ���̣߳������̵߳ȴ����൱��һ�����̵߳Ĺ��̣�Ч�ʵ͡�------������
 *
 * @author ��־��
 * @create 2023/5/8
 */
class Window1 implements Runnable {
    //����static���õ�ͬһ���������
    private int ticket = 100;
//    Object obj=new Object();

    @Override
    public void run() {
        while (true) {
            synchronized (this) {//��ʱ��this��Ψһ��window�Ķ��� ��ʽ����synchronized (obj)
                if (ticket > 0) {
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }//��Ʊ
                    System.out.println(Thread.currentThread().getName() + "Ʊ��Ϊ��" + ticket);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }//��Ʊ
                    ticket--;
                } else {
                    //     System.out.println("������Ʊ����");
                    break;
                }
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

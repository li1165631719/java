package javahigh.day02.com.atguigu.java;

/**
 * ʹ��ͬ���������ʵ��Runnable�ӿڵ��̰߳�ȫ����
 * <p>
 * <p>
 * ����ͬ���������ܽ�
 * 1.ͬ��������Ȼ�漰��ͬ����������ֻ�ǲ���Ҫ������ʾ����
 * 2.�Ǿ�̬��ͬ��������ͬ���������ǣ�this
 * 3.��̬��ͬ��������ͬ���������ǣ���ǰ�౾��
 *
 * @author ��־��
 * @create 2023/8/11
 */
class Window3 implements Runnable {
    //����static���õ�ͬһ���������
    private int ticket = 100;

    @Override
    public void run() {//synchronized ֱ�Ӽӣ�ʹ�ò��в��ֶ�������
        while (true) {
            show();
        }
    }

    private synchronized void show() {//ͬ����������this
        if (ticket > 0) {
            System.out.println(Thread.currentThread().getName() + "Ʊ��Ϊ��" + ticket);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }//��Ʊ
            ticket--;
        }
//        } else {
//            //       System.out.println("������Ʊ����");
//            break;
//        }
    }
}

public class WindowTest3 {
    public static void main(String[] args) {
        Window3 window3 = new Window3();
        Thread t1 = new Thread(window3);
        Thread t2 = new Thread(window3);
        Thread t3 = new Thread(window3);

        t1.setName("����һ");
        t2.setName("���ڶ�");
        t3.setName("������");

        t1.start();
        t2.start();
        t3.start();
    }
}
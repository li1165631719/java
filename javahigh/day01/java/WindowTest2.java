package javahigh.day01.java;

/**
 * ���ӣ���������������Ʊ����Ʊ��Ϊ100�ţ�ʹ�ü̳�Thread��ķ�ʽ
 * <p>
 * <p>
 * ˵�����ڼ̳�Thread��ķ�ʽ�У�����this�䵱ͬ�������������Կ���ʹ�õ�ǰ��ʹ��ͬ��������(��ǰ�ࣺ��.class)
 * (��ʵ��runnable�ӿڵ�ģʽ��ʹ��thisȥ��ͬ������������Ϊ��һ��) ֻ����һ�Σ����Բ��ᱻ�������õ�
 *
 * @author ��־��
 * @create 2023/5/6
 */

//������Ǹ��̵߳������У���Ҫ��ǰ�߳�
class Window2 extends Thread {//���ڵĲ������windowֻ�ᱻ����һ��������ռ�С�

    private static int ticket = 100;
    private static Object obj = new Object();

    @Override
    public void run() {
        //synchronized (obj) {//�����Ļ���һ�����ڰ�Ʊȫ������
        while (true) {
            //��ȷ��
            //synchronized (obj){
            synchronized (Window2.class) {//Class clazz = Window2.class  ��ֻ�����һ��
                //����ĵķ�ʽ��this����t1,t2.t3��������
                //synchronized (this) {
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(getName() + ":��Ʊ��Ʊ��Ϊ��" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
            //  }

        }
    }

}

public class WindowTest2 {
    public static void main(String[] args) {
        Window2 w1 = new Window2();
        Window2 w2 = new Window2();
        Window2 w3 = new Window2();

        w1.setName("����һ");
        w2.setName("���ڶ�");
        w3.setName("������");

        w1.start();
        w2.start();
        w3.start();


    }
}
package javahigh.day01.java;

/**
 * ���ӣ���������������Ʊ����Ʊ��Ϊ100�ţ�ʹ�ü̳�Thread��ķ�ʽ
 *
 * @author ��־��
 * @create 2023/5/6
 */

//������Ǹ��̵߳������У���Ҫ��ǰ�߳�
class Window extends Thread {

    private static int ticket = 100;

    @Override
    public void run() {
        while (true) {
            if (ticket > 0) {
                System.out.println(getName() + ":��Ʊ��Ʊ��Ϊ��" + ticket);
                ticket--;
            } else {
                break;
            }
        }
    }

}

public class WindowTest {
    public static void main(String[] args) {
        Window w1 = new Window();
        Window w2 = new Window();
        Window w3 = new Window();

        w1.setName("����һ");
        w2.setName("���ڶ�");
        w3.setName("������");

        w1.start();
        w2.start();
        w3.start();


    }
}

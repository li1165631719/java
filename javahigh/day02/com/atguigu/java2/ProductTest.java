package javahigh.day02.com.atguigu.java2;

/**
 * �߳�ͨ�ŵ�Ӧ�ã��������⣺������/����������
 * <p>
 * �����ߣ�Productor������Ʒ������Ա��Clerk�����������ߣ�Customer���ӵ�Ա��ȡ�߲�Ʒ��
 * ��Աһ��ֻ�ܳ��й̶������Ĳ�Ʒ�����磺20���������������ͼ��������Ĳ�Ʒ����Ա�������
 * ��ͣһ�£���������п�λ�Ų�Ʒ����֪ͨ�����߼����������������û�в�Ʒ�ˣ���Ա�������
 * ���ߵ�һ�£�����в�Ʒ��֪ͨ������ȡ�߲�Ʒ��
 * <p>
 * ����:
 * 1.�Ƿ��Ƕ��߳����⣿�ǣ������ߵ��̣߳������ߵ��߳�
 * 2.�Ƿ��й������ݣ��ǣ���Ա�����߲�Ʒ����Ʒ������
 * 3.��ν���̵߳İ�ȫ���⣿ͬ�����ƣ������ַ���
 * 4.�Ƿ��漰�̵߳�ͨѶ����
 *
 * @author ��־��
 * @create 2023/10/8
 */
class Clerk {
    private int productCount = 0;

    //������Ʒ
    public synchronized void productProduct() {
        if (productCount < 20) {
            productCount++;
            System.out.println(Thread.currentThread().getName() + "����ʼ������" + productCount + "����Ʒ");
            notify();//һ��������Ʒ��֪ͨ����
        } else {
            //notify();//���ֿ����������
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //���Ѳ�Ʒ
    public synchronized void consumeProduct() {
        if (productCount > 0) {
            System.out.println(Thread.currentThread().getName() + "����ʼ���ѵ�" + productCount + "����Ʒ");
            productCount--;
            //һ���ѾͿ�����������������
            notify();
        } else {
            //�ȴ�
            //notify();//���������ٽ���
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Producer extends Thread {//������
    private Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName() + ":��ʼ������Ʒ������������");

        while (true) {
            try {
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.productProduct();
        }
    }
}

class Consumer extends Thread {//������
    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName() + ":��ʼ���Ѳ�Ʒ������������");

        while (true) {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.consumeProduct();
        }
    }
}

public class ProductTest {

    public static void main(String[] args) {
        Clerk clerk = new Clerk();

        Producer p1 = new Producer(clerk);
        p1.setName("������һ");
        p1.start();

        Consumer c1 = new Consumer(clerk);
        c1.setName("������һ");
        c1.start();

        Consumer c2 = new Consumer(clerk);
        c2.setName("�����߶�");
        c2.start();
    }
}

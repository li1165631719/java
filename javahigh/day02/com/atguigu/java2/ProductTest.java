package javahigh.day02.com.atguigu.java2;

/**
 * 线程通信的应用：经典例题：生产者/消费者问题
 * <p>
 * 生产者（Productor）将产品交给店员（Clerk），而消费者（Customer）从店员处取走产品，
 * 店员一次只能持有固定数量的产品（比如：20），如果生产者试图生产更多的产品，店员会叫生产
 * 者停一下，如果店中有空位放产品了再通知生产者继续生产；如果店中没有产品了，店员会告诉消
 * 费者等一下，如果有产品再通知消费者取走产品。
 * <p>
 * 分析:
 * 1.是否是多线程问题？是，生产者的线程，消费者的线程
 * 2.是否有共享数据？是，店员，或者产品（产品数量）
 * 3.如何解决线程的安全问题？同步机制，有三种方法
 * 4.是否涉及线程的通讯？是
 *
 * @author 李志豪
 * @create 2023/10/8
 */
class Clerk {
    private int productCount = 0;

    //生产产品
    public synchronized void productProduct() {
        if (productCount < 20) {
            productCount++;
            System.out.println(Thread.currentThread().getName() + "：开始生产第" + productCount + "个产品");
            notify();//一生产出商品就通知卖货
        } else {
            //notify();//保持库存满再卖货
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //消费产品
    public synchronized void consumeProduct() {
        if (productCount > 0) {
            System.out.println(Thread.currentThread().getName() + "：开始消费第" + productCount + "个产品");
            productCount--;
            //一消费就可以让生产者生产了
            notify();
        } else {
            //等待
            //notify();//消费完了再进货
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Producer extends Thread {//生产者
    private Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName() + ":开始生产产品。。。。。。");

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

class Consumer extends Thread {//消费者
    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName() + ":开始消费产品。。。。。。");

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
        p1.setName("生产者一");
        p1.start();

        Consumer c1 = new Consumer(clerk);
        c1.setName("消费者一");
        c1.start();

        Consumer c2 = new Consumer(clerk);
        c2.setName("消费者二");
        c2.start();
    }
}

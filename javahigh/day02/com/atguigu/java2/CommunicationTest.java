package javahigh.day02.com.atguigu.java2;

/**
 * 线程通信的例子：使用线程打印1-100.线程1，线程2，交替打印
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

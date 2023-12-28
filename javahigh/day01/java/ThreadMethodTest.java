package javahigh.day01.java;

/**
 * 测试thread类的常用方法
 * void start():启动线程，并执行对象的run方法
 * run():线程在被调度时执行的操作，将创建线程的要执行的操作声明在此方法中
 * String getName():返回线程的名称
 * void setName(String name):设置线程名称
 * static Thread currentThread():返回当前的线程。在Thread子类中就是this，通常用于主线程的和Runnable实现类
 * yeild():释放当前cpu的执行
 * join():在线程a中调用线程b的join()，此时的线程a就进入阻塞状态，直到线程b完全执行完以后，线程a才结束阻塞状态
 * stop():强制线程生命周期结束，不推荐使用
 * sleep(long millitime):让当前线程“睡眠”指定的millitime毫秒，在指定的millitime时间内，当前线程是堵塞状态
 * 单位（毫秒） 桌面应用倒计时 每秒跳一下
 * isAlive():判断当前线程是否存活
 * <p>
 * <p>
 * 线程的优先级：
 * 1.
 * MIN_PRIORITY = 1;
 * NORM_PRIORITY=5; ------>normal  默认的优先级
 * MAX_PRIORITY=10;
 * 2.如何获取和设置当前线程的优先级
 * getPriority();获取线程的优先级
 * setPriority(int p);设置线程的优先级
 * <p>
 * 说明：高优先级的线程要抢占低优先级线程的cpu执行权，但是只是从概率上来讲。高优先级的线程高概率的情况下
 * 被执行，并不意味着只有当高优先级的线程执行完以后，才执行低优先级的线程
 * <p>
 * 线程通信：wait()/notify()/notifyAll():此三个方法是定义在Object类中的。
 *
 * @author 李志豪
 * @create 2023/5/4
 */
class HelloThread extends Thread {
    //通过构造器给线程起名字
    HelloThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {

                //只能try-catch，因为父类的没有抛异常，子类不能抛出（throws）比父类更大的异常
//                try {
//                    sleep(10);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }

                System.out.println(Thread.currentThread().getName() + ":" + Thread.currentThread().getPriority() + ":" + i);
            }

//            if(i%20==0){
//                yield();
//                //this.yield();
//                //Thread.currentThread().yield();
//
//            }
        }


    }

}

public class ThreadMethodTest {
    public static void main(String args[]) {
        HelloThread h1 = new HelloThread("Thread:1");
        //h1.setName("线程一");

        //设置分线程的优先级
        h1.setPriority(Thread.MAX_PRIORITY);

        h1.start();


        //主线程
        Thread.currentThread().setName("主线程");
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + Thread.currentThread().getPriority() + ":" + i);
            }

//            if(i==20){
//                try {
//                    h1.join();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
        }

        System.out.println(h1.isAlive());

    }
}


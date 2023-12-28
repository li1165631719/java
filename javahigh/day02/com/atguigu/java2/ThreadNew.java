package javahigh.day02.com.atguigu.java2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 创建线程得方式三：实现Callable接口。-----JDK 5.0新增
 * <p>
 * 如何理解实现Callable接口的方式创建多线程比实现Runnable接口实现多线程要强大？
 * 1.call()方法可以有返回值
 * 2.call()方法可以抛出异常，被外面的操作捕获，获取异常信息
 * 3.Callable是支持泛型的
 *
 * @author 李志豪
 * @create 2023/10/9
 */
//1.创建一个实现Callable的实现类
class NumThread implements Callable<Integer> {
    //2.实现call方法，将此线程需要执行的操作声明在call方法中
    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
                sum += i;
            }
        }
        return sum;
    }
}

public class ThreadNew {
    public static void main(String[] args) {
        //3.创建Callable接口实现类的对象
        NumThread numThread = new NumThread();
        //4.将Callable接口实现类的对象作为参数传递到FutureTask构造器中，创建FutureTask的对象
        FutureTask<Integer> futureTask = new FutureTask<Integer>(numThread);
        //5.将FutureTask的对象作为参数传递到Thread类的构造器中，创建Thread对象，并调用start方法
        Thread t1 = new Thread(futureTask);
        t1.start();
        try {
            //6.获取Callable中call()方法的返回值
            //get()方法的返回值即为futureTask构造器参数Callable实体类重写的call()方法的返回值
            Integer sum = futureTask.get();
            System.out.println("总和为：" + sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

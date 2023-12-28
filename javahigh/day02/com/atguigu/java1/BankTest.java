package javahigh.day02.com.atguigu.java1;

/**
 * 使用同步机制将单例模式中的懒汉式改为线程安全的
 *
 * @author 李志豪
 * @create 2023/8/11
 */
public class BankTest {
}

//风险出现在第一次创建的时候，第一次创建的时候，同时调用2次，让instance赋值了两次
class Bank {
    private static Bank instance = null;

    private Bank() {

    }

    //静态类就是类本身，Bank.class   不是静态类指的就是this
    //public static synchronized Bank getInstance(){也相当于给代码块包上synchronized(类.class)
    public static Bank getInstance() {

        //方式一：效率稍差
//        synchronized (Bank.class) {
//            if (instance == null) {
//                instance = new Bank();
//            }
//            return instance;
//        }
        //方式二：效率更高
        if (instance == null) {
            synchronized (Bank.class) {
                if (instance == null) {
                    instance = new Bank();
                }
            }
        }
        return instance;
    }
}

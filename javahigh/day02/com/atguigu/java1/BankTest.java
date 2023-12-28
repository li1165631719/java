package javahigh.day02.com.atguigu.java1;

/**
 * ʹ��ͬ�����ƽ�����ģʽ�е�����ʽ��Ϊ�̰߳�ȫ��
 *
 * @author ��־��
 * @create 2023/8/11
 */
public class BankTest {
}

//���ճ����ڵ�һ�δ�����ʱ�򣬵�һ�δ�����ʱ��ͬʱ����2�Σ���instance��ֵ������
class Bank {
    private static Bank instance = null;

    private Bank() {

    }

    //��̬������౾��Bank.class   ���Ǿ�̬��ָ�ľ���this
    //public static synchronized Bank getInstance(){Ҳ�൱�ڸ���������synchronized(��.class)
    public static Bank getInstance() {

        //��ʽһ��Ч���Բ�
//        synchronized (Bank.class) {
//            if (instance == null) {
//                instance = new Bank();
//            }
//            return instance;
//        }
        //��ʽ����Ч�ʸ���
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

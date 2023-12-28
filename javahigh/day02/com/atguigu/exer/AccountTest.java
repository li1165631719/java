package javahigh.day02.com.atguigu.exer;

/**
 * ������һ���˻���
 * �����������ֱ���ͬһ���˻���3000Ԫ��ÿ�δ�1000����3�Σ�ÿ�δ����ӡ�˻���
 * <p>
 * ������
 * 1.�Ƿ��Ƕ��̵߳����⣿�ǣ����������߳�
 * 2.�Ƿ��й������ݣ��У��˻������˻���
 * 3.�Ƿ����̰߳�ȫ���⣿��
 * 4.��Ҫ������ν���̰߳�ȫ���⣿ͬ�����ƣ������ַ�ʽ��
 * <p>
 * ��������ʱ������̳е�ʱ����Ҫ�ѹ�����Դ��Ϊstatic�������Ͷ�����ס���Է���סһ���������һ�������û��ס
 *
 * @Author lizhihao
 * @Date 2023/9/25 20:38
 * @PackageName:day02.com.atguigu.exer
 * @ClassName: AccountTest
 * @Description: TODO
 * @Version 1.0
 */

class Account {
    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    //��Ǯ
    public synchronized void deposit(double amt) {
        if (amt > 0) {
            balance += amt;
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
            System.out.println(Thread.currentThread().getName() + "��Ǯ�ɹ������Ϊ��" + balance);
        }
    }
}

class Customer extends Thread {
    private Account acct;

    public Customer(Account acct) {
        this.acct = acct;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            acct.deposit(1000);
        }
    }
}

public class AccountTest {
    public static void main(String[] args) {
        Account acct = new Account(0);
        Customer c1 = new Customer(acct);
        Customer c2 = new Customer(acct);

        c1.setName("��");
        c2.setName("��");

        c1.start();
        c2.start();

    }
}

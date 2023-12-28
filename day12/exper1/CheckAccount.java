package day12.exper1;

public class CheckAccount extends Account {
    private double overdraft;

    public CheckAccount(int id, double balance, double annualInterestRate, double overdraft) {
        super(id, balance, annualInterestRate);
        this.overdraft = overdraft;

    }

    public void withdraw(double amount) {
        if (amount <= this.getBalance()) {
            System.out.println("取款成功，取出了:" + amount);
            this.setBalance(this.getBalance() - amount);
            System.out.println("余额为：" + this.getBalance());
        } else if (amount <= (this.getBalance() + overdraft)) {
            System.out.println("取款成功，取出了：" + amount + ",\n透支了：" + overdraft);
            overdraft -= (amount - this.getBalance());
            this.setBalance(0);
            System.out.println("可透支余额为：" + overdraft);
        } else {
            System.out.println("取款失败，超过可透支金额！");
            System.out.println("可透支金额为：" + overdraft);
        }

    }
}

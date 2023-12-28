package day12.exper1;

public class Account {
    private int id;
    private double balance;
    private double annualInterestRate;

    public Account(int id, double balance, double annualInterestRate) {
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public double getMonthlyInterestRate() {
        return annualInterestRate / 12;
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            System.out.println("取钱成功，取出了：" + amount);
            balance -= amount;
            System.out.println("您的账户余额为：" + balance);
        } else {
            System.out.println("取钱失败，余额不足！");
        }

    }

    public void deposit(double amount) {
        if (balance > 0) {
            System.out.println("存钱成功，存了：" + amount);
            balance += amount;
            System.out.println("余额为：" + balance);
        } else {
            System.out.println("存钱失败！存钱金额有误！");
        }

    }


}

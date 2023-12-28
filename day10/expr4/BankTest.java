package day10.expr4;

public class BankTest {
    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.addCustomer("Jane", "Smith");
        bank.getCustomers(0).setAccount(new Account(2000));
        bank.getCustomers(0).getAccount().withdraw(500);
        double balance = bank.getCustomers(0).getAccount().getBalance();
        System.out.println(bank.getCustomers(0).getFirstName() + bank.getCustomers(0).getLastName() + "的账户余额为" + balance);
        System.out.println("**********************************");
        bank.addCustomer("万里", "杨");
        System.out.println("银行的客户有" + bank.getNumberOfCustomer() + "个");
    }
}

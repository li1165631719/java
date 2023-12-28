package day15.java;

public class SingletonTest {
    public static void main(String[] args) {
        Bank bank1 = Bank.instance;
        Bank bank2 = Bank.instance;

        System.out.println(bank1 == bank2);
    }


}

class Bank {
    public static final Bank instance = new Bank();

    private Bank() {

    }
}

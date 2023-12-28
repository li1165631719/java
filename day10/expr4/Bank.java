package day10.expr4;

public class Bank {
    private Customer[] customers;
    private int numberOfCustomer;

    public Bank() {
        customers = new Customer[10];

    }

    //获取指定的客户
    public Customer getCustomers(int index) {
        if (index >= numberOfCustomer && index < 0) {
            System.out.println("查询不到此客户！");
            return null;
        } else {
            return customers[index];
        }

    }

    public int getNumberOfCustomer() {
        return numberOfCustomer;
    }

    public void addCustomer(String firstName, String lastName) {
        Customer customer = new Customer(firstName, lastName);
        customers[numberOfCustomer] = customer;
        numberOfCustomer++;

    }
}

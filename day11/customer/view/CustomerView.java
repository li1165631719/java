package day11.customer.view;

import day11.customer.bean.Customer;
import day11.customer.controller.CustomerList;
import day11.customer.util.CMUtility;

public class CustomerView {
    private CustomerList customerList = new CustomerList(10);

    public CustomerView() {
        Customer customer = new Customer("王涛", '男', 23, "123123121", "wt@gmail.com");
        customerList.addCustomer(customer);
    }

    public static void main(String[] args) {
        CustomerView view = new CustomerView();
        view.enterMainMenu();
    }

    public void enterMainMenu() {
        boolean isFlag = true;
        while (isFlag) {
            System.out.println("\n-----------------客户信息管理软件-----------------\n");
            System.out.println("                   1 添 加 客 户");
            System.out.println("                   2 修 改 客 户");
            System.out.println("                   3 删 除 客 户");
            System.out.println("                   4 客 户 列 表");
            System.out.println("                   5 退    出\n");
            System.out.print("                   请选择(1-5)：");
            char menu = CMUtility.readMenuSelection();
            switch (menu) {
                case '1':
                    addNewCustomer();
                    break;
                case '2':
                    modifyCustomer();
                    break;
                case '3':
                    deleteCustomer();
                    break;
                case '4':
                    listAllCustomers();
                    break;
                case '5':
                    System.out.print("确认是否退出（Y/N）：");
                    char isExit = CMUtility.readConfirmSelection();
                    if (isExit == 'Y') {
                        isFlag = false;
                    }

            }

        }
    }

    public void addNewCustomer() {
        System.out.println("---------------------添加客户---------------------");
        System.out.print("姓名:");
        String name = CMUtility.readString(10);
        System.out.print("性别:");
        char gender = CMUtility.readChar();
        System.out.print("年龄:");
        int age = CMUtility.readInt();
        System.out.print("电话:");
        String phone = CMUtility.readString(13);
        System.out.print("邮箱:");
        String email = CMUtility.readString(30);
        //将上述对象封装到对象中
        Customer customer = new Customer(name, gender, age, phone, email);
        boolean isSuccess = customerList.addCustomer(customer);
        if (isSuccess) {
            System.out.println("---------------------添加完成---------------------");
        } else {
            System.out.println("----------------客户目录已满，添加失败---------------");
        }
    }

    private void modifyCustomer() {
        System.out.println("---------------------修改客户---------------------");
        int number = 0;
        Customer customer;
        for (; ; ) {

            System.out.print("请选择待修改客户编号(-1退出)：");
            number = CMUtility.readInt();
            if (number == -1) {

                return;
            }
            customer = customerList.getCustomer(number - 1);
            if (customer == null) {
                System.out.println("无法找到指定客户！");
            } else {//找到相应序号的客户
                break;
            }
        }
        //修改客户信息
        System.out.print("姓名(" + customer.getName() + "):");
        String name = CMUtility.readString(10, customer.getName());
        System.out.print("性别(" + customer.getGender() + "):");
        char gender = CMUtility.readChar(customer.getGender());
        System.out.print("年龄(" + customer.getAge() + "):");
        int age = CMUtility.readInt(customer.getAge());
        System.out.print("手机号(" + customer.getPhone() + "):");
        String phone = CMUtility.readString(13, customer.getPhone());
        System.out.print("邮箱(" + customer.getEmail() + "):");
        String email = CMUtility.readString(30, customer.getEmail());
        Customer customer1 = new Customer(name, gender, age, phone, email);
        boolean isReplaced = customerList.replaceCustomer(number - 1, customer1);
        if (isReplaced) {
            System.out.println("---------------------修改完成---------------------");
        } else {
            System.out.println("---------------------修改失败---------------------");
        }

    }

    private void deleteCustomer() {
        System.out.println("---------------------删除客户---------------------");
        System.out.print("请选择待删除客户编号(-1退出)：");
        for (; ; ) {
            int number = CMUtility.readInt();
            if (number == -1) {
                return;
            }
            Customer customer = customerList.getCustomer(number - 1);
            if (customer == null) {
                System.out.println("无法找到该用户");
            } else {
                break;
            }
            //找到了指定的元素
            System.out.print("确认是否删除(Y/N)：");
            char isDelete = CMUtility.readConfirmSelection();
            if (isDelete == 'Y') {
                customerList.deleteCustomer(number - 1);
            }
        }
    }

    private void listAllCustomers() {
        System.out.println("---------------------------客户列表---------------------------");
        int total = customerList.getTotal();
        if (total == 0) {
            System.out.println("没有客户记录！");
        } else {
            System.out.println("编号\t姓名\t\t性别\t年龄\t\t电话\t\t\t\t邮箱");
            Customer[] customers = customerList.getAllCustomers();
            for (int i = 0; i < total; i++) {
                Customer customer = customers[i];
                System.out.println((i + 1) + "\t" + customer.getName() + "\t\t" + customer.getGender() + "\t" + customer.getAge() + "\t\t" + customer.getPhone() + "\t\t" + customer.getEmail());
            }
        }


        System.out.println("---------------------------客户列表完成-------------------------");

    }
}

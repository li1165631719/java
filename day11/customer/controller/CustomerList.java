package day11.customer.controller;

import day11.customer.bean.Customer;

public class CustomerList {
    private Customer[] customers;//用来保存客户对象的数组

    private int total = 0;//记录已保存客户对象的数量

    /**
     * 用来初始化customers数组的构造器
     *
     * @param totalCustomer，指定数组的长度
     */
    public CustomerList(int totalCustomer) {
        customers = new Customer[totalCustomer];
    }

    /**
     * @param customer
     * @return true:添加成功 false:添加失败
     * @Description 将指定客户添加到数组中
     */

    public boolean addCustomer(Customer customer) {
        if (total >= customers.length) {
            return false;
        }
        customers[total] = customer;
        total++;
        return true;
    }

    /**
     * @param index
     * @param customer
     * @return true:修改成功 false:修改失败
     * @Description 修改指定索引位置的客户信息
     */

    public boolean replaceCustomer(int index, Customer customer) {
        if (index < 0 || index >= total) {
            return false;
        }
        customers[index] = customer;//赋了一个新对象的地址给customers数组
        return true;

    }

    /**
     * @param index
     * @return true:删除成功 false:删除失败
     * @Description 删除指定索引位置上的客户
     */
    public boolean deleteCustomer(int index) {
        if (index < 0 || index >= total) {
            return false;
        }
        for (int i = index; i < total - 1; i++) {
            customers[i] = customers[i + 1];
        }
        //最后有数据的元素需要置空
//        customers[total - 1] = null;
//        total--;
//        或
        customers[--total] = null;
        return true;
    }

    /**
     * @return
     * @Description 获取所有用户信息
     */
    public Customer[] getAllCustomers() {
//        return customers;
        Customer[] customers = new Customer[total];
        for (int i = 0; i < total; i++) {
            customers[i] = this.customers[i];
        }
        return customers;
    }

    /**
     * @param index
     * @return 如果找到了元素，则返回；如果没有找到，则返回null
     * @Description 获取指定索引位置上的客户
     */
    public Customer getCustomer(int index) {
        if (index < 0 || index >= total) {
            return null;
        }
        return customers[index];
    }

    /**
     * @return
     * @Description 获取存储客户的数量
     */
    public int getTotal() {
        return total;
    }
}

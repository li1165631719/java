package day13.java1;

import java.util.Objects;

public class Customer {
    private String name;
    private int age;

    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Customer() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
//重写的原则：比较对象的实体内容(即name和age)是否相同

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o instanceof Customer) {
//
//            Customer customer = (Customer) o;
//            return age == customer.age && Objects.equals(name, customer.name);
//        }
//        return false;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return getAge() == customer.getAge() && Objects.equals(getName(), customer.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge());

    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}

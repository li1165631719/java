package day15.exer1;

/**
 * 编写一个Employee类，声明为抽象类，
 * 包含如下三个属性：name，id，salary。
 * 提供必要的构造器和抽象方法：work()。
 */
public abstract class Employee {
    private String name;
    private String id;
    private double salary;

    public Employee() {

    }

    public Employee(String id, String name, double salary) {

        this.id = id;
        this.name = name;
        this.salary = salary;

    }

    public abstract void work();
}

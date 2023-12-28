package day12.java;

public class Student extends Person {
    String major;

    public Student() {


    }

    public Student(String major) {
        this.major = major;
    }

    public void study() {
        System.out.println("学习，专业是：" + major);
    }

    //对父类中的eat方法进行了重写
    public void eat() {
        System.out.println("学生应该多吃点有营养的食物");
    }

    public void show() {
        System.out.println("我是一名学生");
    }

    public String info() {
        return null;
    }
}

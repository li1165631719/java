package day12.java3;

public class Student extends Person {
    String major;
    int id = 1002;//学号

    public Student() {

    }

    public Student(String major) {
        super();
        this.major = major;
    }

    public Student(String name, int age, String major) {
        super(name, age);//如果父类的属性是私有的
        this.major = major;
    }


    @Override
    public void eat() {
        System.out.println("学生，多吃有营养的食物");
    }

    public void study() {
        System.out.println("学生，学习知识");
    }

    public void show() {
        System.out.println("name:" + this.name + ",age=" + super.age);
        System.out.println("id=" + this.id);
        System.out.println("id=" + super.id);
    }
}

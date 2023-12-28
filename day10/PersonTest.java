package day10;

public class PersonTest {
    public static void main(String[] args) {
        //创建类的对象：new +构造器
        Person person = new Person();
        person.eat();
    }
}

class Person {
    //属性
    private String name;
    private int age;

    //构造器
    public Person() {

    }


    //方法
    public void eat() {
        System.out.println("人吃饭");
    }


}

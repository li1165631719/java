package javahigh.day03.java;

/**
 * @Author lizhihao
 * @Date 2023/11/19 16:10
 * @PackageName:javahigh.day03
 * @ClassName: Person
 * @Description: TODO
 * @Version 1.0
 */
public class Person {
    String name;
    int age;


    public Person(String name, int age) {
        this.name = name;
        this.age = age;
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
}

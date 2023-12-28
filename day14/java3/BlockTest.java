package day14.java3;

/***
 * 类的成员之四：代码块（初始化块）
 *
 * 1.代码块的作用：用来初始化类、对象
 * 2.代码块如果有修饰的话，只能用static.
 * 3.分类：静态代码块 vs 非静态代码块
 *
 * 4.静态代码块
 *       >内部可以有输出语句
 *       >随着类的加载而执行,而且只执行一次
 *       >作用：初始化一些类的属性
 *       >如果一个类中定义了多个静态的代码块，则按先后顺序执行
 *       >静态代码块的执行要优先于非静态代码的执行
 *       >静态代码块内只能调用静态的属性、静态的方法，不能用非静态的结构
 *
 * 5.非静态代码块
 *       >内部可以有输出语句
 *       >随着对象的创建而执行
 *       >每创建一个对象，就执行一次非静态代码块
 *       >作用：在创建对象时，对对象的属性等进行初始化
 *       >如果一个类中定义了多个非静态代码块，则按照声明的先后顺序执行
 *       >非静态代码块内只能调用静态的属性、静态的方法，不能调用非静态的结构
 *
 *
 * 对象可以赋值的位置：
 * ①默认初始化
 * ②显示初始化
 * ③构造器中初始化
 * ④有了对象以后，可以通过”对象.属性“或”对象.方法“，进行赋值
 * ⑤在代码过中赋值
 */
public class BlockTest {
    public static void main(String[] args) {
        String desc = Person.desc;
        Person person = new Person();
        Person person1 = new Person();
        Person.info();
    }
}

class Person {
    static String desc = "我是一个人";

    //static代码块
    static {

        System.out.println("hello,static block");
    }

    //属性
    String name;
    int age;

    //非static的代码块
    {

        System.out.println("hello，block");
    }

    //构造器
    public Person() {

    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;

    }

    public static void info() {
        System.out.println("我是一个快乐的人");
    }

    //方法
    public void eat() {
        System.out.println("吃饭");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
package day14.java1;

/**
 * static关键字的使用
 * <p>
 * 1.static：静态的
 * 2.static可以用来修饰、属性、方法、代码块、内部类
 * <p>
 * 3.使用static修饰属性:静态变量，
 * 3.1属性按是否使用static修饰，又分为：静态属性vs非静态属性（实例变量）
 * 实例变量：我们创建了类的多个对象，每个对象都独立的拥有一套类中的非静态属性，当修改其中一个对象中的
 * 非静态属性时，不会导致其他对象中同样的属性值的修改
 * 静态变量：我们创建了类的多个对象，多个对象共享同一个静态变量。当通过某一个对象修改静态变量时，会导致
 * 其他对象调用此静态变量时，是修改过了的。
 * 3.2 static修饰属性的其他说明：
 * ①静态变量随着类的加载而加载，可以通过"类.静态变量"的方式调用（实例变量随着变量的创建而加载）
 * ②静态变量的加载要早于对象的创建。
 * ③由于类只会加载一次。则静态变量字内容中也只会存在一份，存在方法区的静态域中。
 * <p>
 * ④           类变量         实例变量
 * 类            yes           no
 * 对象          yes           yes
 * 3.3 静态属性举例：System.out;Math.PI;
 * <p>
 * <p>
 * 4.使用static修饰方法:静态方法
 * ①随着类的加载而加载，可以通过”类.方法名“来进行调用
 * ②              变量名          非静态方法
 * 类           yes             no
 * 对象         yes             yes
 * ③ 静态方法中：只能调用静态的方法或属性
 * 非静态方法中：既可以调用非静态的方法或属性，也可以调用静态的方法或属性
 * <p>
 * 5。 static注意点：
 * 5.1在静态方法内，不能用this关键字、super关键字
 * 5.2关于静态属性和静态方法的使用，大家都从生命周期的角度区理解。
 * <p>
 * 6. 开发中，如何确定一个属性是否声明为static的？
 * >属性是可以被多个对象所共享的，不会随着对象的不同而不同的。
 * >类中的常量也常常声明为static
 * <p>
 * 开发中，如何确定一个方法是否声明为static的？
 * >操作静态属性的方法，通常设置为static的
 * >工具类中的方法，习惯上声明为static的。比如：Math、Arrays、Collections
 */

public class StaticTest {

    public static void main(String[] args) {

        Chinese.nation = "中国";
        Chinese.show();


        Chinese chinese = new Chinese();
        chinese.name = "姚明";
        chinese.age = 40;

        Chinese chinese1 = new Chinese();
        chinese1.name = "马龙";
        chinese1.age = 30;

        chinese.nation = "CHN";
        chinese.eat();


        System.out.println(chinese1.nation);

    }

}

//中国人
class Chinese {
    static String nation;
    String name;
    int age;

    public static void show() {
        //不能调用非静态的结构
        System.out.println("我是一个中国人");
        System.out.println(Chinese.nation);
        walk();
    }

    public static void walk() {

    }

    public void eat() {
        System.out.println("中国人吃中餐");
        //调用非静态结构
        this.info();
        System.out.println("name:" + name);
        //调用静态结构
        walk();
        System.out.println("nation:" + nation);


    }

    public void info() {
        System.out.println("name:" + name + ",age:" + age);
    }
}
